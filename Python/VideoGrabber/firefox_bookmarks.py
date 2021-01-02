import os
import sys
import sqlite3
import requests
import re
import time
from datetime import datetime 
from datetime import timedelta 


# set the downloading folder
DOWNLOAD_PATH = '/Users/samueltan/Downloads/download/auto/'

# set the path of firefox folder with databases
bookmarks_path = "/Users/samueltan/Library/Application Support/Firefox/Profiles/"

# execute a query on sqlite cursor
def execute_query(cursor, query):
    try:
        cursor.execute(query)
    except Exception as error:
        print(str(error) + "\n " + query)

# get bookmarks from firefox sqlite database file and print all
def process_bookmarks(cursor, timestamp):
    bookmarks_query = """select url, moz_places.title from moz_places join \
        moz_bookmarks on moz_bookmarks.fk=moz_places.id 
        where moz_bookmarks.dateAdded >= {}
        and moz_places.url like 'http%'
        order by dateAdded desc;""".format(timestamp)
    # print(bookmarks_query)

    execute_query(cursor, bookmarks_query)
    for row in cursor:
        link = row[0]
        title = row[1]
        video_list = get_video_urls(link)
        save_video_files(video_list)
    
    print("\nSuccessful: %s" % cnt_success)
    print("Failed: %s" % cnt_failed)
    print("Already Existed: %s" % cnt_exist)

# get the video urls from the link
def get_video_urls(link):
    print("Processing url: '%s'" % link)
    
    r = requests.get(link)
    page_source = r.text.split('\n')
    video_urls = []
    pattern_hd = '"(https?:\\\\?\/\\\\?\/[^"(]*720P_[^"]*\.mp4[^"]*)"'
    pattern = '"(https?:\\\\?\/\\\\?\/[^"(]*480P_[^"]*\.mp4[^"]*)"'

    for row in page_source:
        match = re.search(pattern_hd, row)
        matched = False
        if match:
            matched = True
        else:
            match = re.search(pattern, row)
            matched = True if match else False

        if matched:
            matched_url = match.group(1).replace("\/", "/")
            video_urls.append(matched_url)

    return video_urls

# save the video files to a specific location
def save_video_files(urls):
    for url in urls:
        try:
            save_video_file(url)
        except:
            continue

# save a single video file from the url
def save_video_file(url):
    global idx
    global cnt_success
    global cnt_failed
    global cnt_exist

    print("Video url: '%s'" % url)

    idx += 1
    pattern = '([^"^(]*/)*([^"^(]*\.mp4).*'
    match = re.search(pattern, url)
    if match:
        file_name = match.group(2)
        file_path = DOWNLOAD_PATH + file_name
        # print(file_path)
        if os.path.exists(file_path):
            cnt_exist += 1
            print("%d: The file '%s' already exists!" % (idx, file_name))
        else:
            msg = str(idx) + ": Downloading '" + file_name + "'..."
            print(msg, end="")

            try:
                r = requests.get(url)
                
                if r.status_code == 200:
                    with open(file_path, 'wb') as f:
                        f.write(r.content)
                        print(" Completed!")
                        cnt_success += 1
                else:
                    cnt_failed += 1
                    print("\nFailed with error code %s" % r.status_code)
            except :
                print("\nException with url: <%s>, file name: <%s>" % (url, file_name))
                raise 
    else:
        print("No valid video found!")

# download all possible video files from bookmarks
def download_videos(days):
    timestamp = datetime.timestamp(datetime.now() - timedelta(days = days)) * 1000 * 1000

    # get firefox profile
    profiles = [i for i in os.listdir(bookmarks_path) if '.default' in i]

    # get sqlite database of firefox bookmarks
    sqlite_path = bookmarks_path+ profiles[0]+'/places.sqlite copy'

    # print(sqlite_path)

    if os.path.exists(sqlite_path):
        firefox_connection = sqlite3.connect(sqlite_path)
    cursor = firefox_connection.cursor()

    process_bookmarks(cursor, timestamp)
    
    cursor.close()

n = len(sys.argv)

idx = 0
cnt_success = 0
cnt_failed = 0
cnt_exist = 0
start = time.time()

if n == 1:
    download_videos(1)

arg = sys.argv[1]
if arg.isnumeric():
    days = int(arg)
    download_videos(days)
elif "http" in arg:
    video_url = arg
    if ".mp4" in video_url:
        save_video_file(video_url)
    else:
        video_list = get_video_urls(video_url)
        save_video_files(video_list)
else:
    print("Invalid argument!")

end = time.time()
print("Time used: %s Secs" % (end - start))