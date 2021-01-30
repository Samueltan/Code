import os
import sys
import sqlite3
import requests
import re
import time
import shutil
import ffmpeg
from datetime import datetime 
from datetime import timedelta 
import urllib3
from pathlib import Path

urllib3.disable_warnings(urllib3.exceptions.InsecureRequestWarning)

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
    print("\nProcessing url: '%s'" % link)
    
    r = requests.get(link)
    page_source = r.text.split('\n')
    video_urls = []
    # pattern_hd = '"(https?:\\\\?\/\\\\?\/[^"(]*720P_[^"]*\.mp4[^"]*)"'
    pattern = '"(https?:\\\\?\/\\\\?\/[^"(]*\.mp4[^"]*)"'

    for row in page_source:
        matches = re.findall(pattern, row)
        p720_found = False
        p480_found = False
        selected_url = ""

        for match in matches:
            matched_url = match.replace("\/", "/")
            if "720P_" in match:
                selected_url = matched_url
            elif "480P_" in match:
                p480_found = True
                if not p720_found:
                    selected_url = matched_url
            elif "240P_" in match:
                continue
            else:
                selected_url = matched_url

        if selected_url:
            # print("selected_url = " + selected_url)
            video_urls.append(selected_url)

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

    idx += 1
    source = 'Normal'
    if ".com/preview" in url or ".com/samples" in url:
        pattern = '(preview|samples)\/(.*)\/sample\.mp4'
        source = 'FJSM'
    elif "uralesbian" in url:
        pattern = '(tour\/)(.*)\/sample\.mp4'
        source = 'UL'
    elif "lollipopgirls" in url:
        pattern = '(scenes\/)(.*)\/sample\.mp4'
        source = 'LG'
    else:
        pattern = '([^"^(]*/)*([^"^(]*\.mp4).*'
    match = re.search(pattern, url)
    if match:
        if source == 'FJSM':
            file_name = match.group(2) + '.mp4'
            file_path = DOWNLOAD_PATH + 'fjsm/' + file_name
        elif source == 'UL':
            file_name = 'uralesbian_' + match.group(2) + '.mp4'
            file_path = DOWNLOAD_PATH + 'fjsm/' + file_name
        elif source == 'LG':
            file_name = 'lollipopgirls_' + match.group(2) + '.mp4'
            file_path = DOWNLOAD_PATH + 'fjsm/' + file_name
        else:
            file_name = match.group(2)
            file_path = DOWNLOAD_PATH + file_name
        # print(file_path)
        now = datetime.now().strftime("%H:%M:%S")

        print("[%s] Video url: '%s'" % (now, url))

        if os.path.exists(file_path):
            cnt_exist += 1
            print("[%s] %d: The file '%s' already exists!" % (now, idx, file_name))
        else:
            print("[%s] %d: Downloading '%s'..." % (now, idx, file_name), end="")

            try:
                r = requests.get(url, verify=False)
                if r.status_code == 200:
                    with open(file_path, 'wb') as f:
                        f.write(r.content)
                        print(" Completed!")
                        cnt_success += 1
                else:
                    cnt_failed += 1
            except Exception as e:
                print("\nException with url: <%s>, file name: <%s>" % (url, file_name))
                # print(e)
                raise 

    else:
        print("No valid video found!")

# download all possible video files from bookmarks
def download_videos(days):
    timestamp = datetime.timestamp(datetime.now() - timedelta(days = days)) * 1000 * 1000

    # get firefox profile
    profiles = [i for i in os.listdir(bookmarks_path) if '.default' in i]

    # get sqlite database of firefox bookmarks
    sqlite_path = bookmarks_path+ profiles[0]
    sqlite_db_file_source = sqlite_path + '/places.sqlite'
    sqlite_db_file_dest = sqlite_path + '/places.sqlite copy'

    # print(sqlite_db_file_source)

    if os.path.exists(sqlite_db_file_source):
        shutil.copyfile(sqlite_db_file_source, sqlite_db_file_dest)
        firefox_connection = sqlite3.connect(sqlite_db_file_dest)
        cursor = firefox_connection.cursor()

        process_bookmarks(cursor, timestamp)
        
        cursor.close()

# download all possible pictures files from url
def download_pics(url):
    pattern = '(http.*\/)(\d+)\/(.*?)-(\d+).jpg'
    match = re.search(pattern, url)
    if match:
        full_prefix = match.group(1)
        group = match.group(2)
        name = match.group(3)
        width = len(match.group(4))
        folder = DOWNLOAD_PATH + 'pic/' + name
        Path(folder).mkdir(parents=True, exist_ok=True)
        # print('folder = ' + folder)
        # print('full_prefix = ' + full_prefix)
        # print('folder = ' + folder)
        # print('name = ' + name)

        save_pics(full_prefix, group, name, width)
    else:
        pattern = '(http.*\/(.*?)-)(\d+).jpg'
        match = re.search(pattern, url)
        if match:
            full_prefix = match.group(1)
            group = ""
            name = match.group(2)
            width = len(match.group(3))
            folder = DOWNLOAD_PATH + 'pic/' + name
            Path(folder).mkdir(parents=True, exist_ok=True)
            # print('folder = ' + folder)
            # print('full_prefix = ' + full_prefix)
            # print('folder = ' + folder)
            # print('name = ' + name)

            save_pics(full_prefix, group, name, width)

# save pics based on group id and file name
def save_pics(full_prefix, group, name, width):
    gi = 0
    cnt = 0
    fail = 0
    while True:
        i = 0
        gi += 1
        while True:
            try:
                i += 1
                now = datetime.now().strftime("%H:%M:%S")
                if group:
                    file_name = name + '-' + str(gi).zfill(3) + str(i).zfill(3)
                else:
                    file_name = name + '-' + str(i).zfill(3)
                folder = DOWNLOAD_PATH + 'pic/' + name
                full_file_path = folder + '/' + file_name + '.jpg'

                if os.path.exists(full_file_path):
                    cnt += 1
                    print("[%s] %d: The file '%s' already exists!" % (now, cnt, file_name))
                else:
                    if group:
                        current_url = full_prefix + str(gi).zfill(len(group)) + '/' + name + '-' + str(i).zfill(width) + '.jpg'
                    else:
                        current_url = full_prefix + str(i).zfill(width) + '.jpg'

                    print("gi = %d, current_url = %s" % (gi, current_url))
                    r = requests.get(current_url, allow_redirects=False)
                    if r.status_code == 200:
                        fail = 0
                        cnt += 1
                        print("[%s] %d: Downloading '%s'..." % (now, cnt, file_name), end="")
                        with open(full_file_path, 'wb') as f:
                            f.write(r.content)
                            print(" Completed!")
                    else:
                        fail += 1
                        print('fail = ' + str(fail))
                        break
            except Exception as e:
                print("\nException with url: <%s>, file name: <%s>" % (url, file_name))
                # print(e)
                break 

        # if not group or (fail >1 and gi > 1):
        if not group or fail > 1:
            break

        if fail == 1 and gi == 1:
            gi = int(group) - 1
            print('gi = ' + str(gi))
            continue

# check if a video contains audio track or not
def isAudioIncluded(filename):
    p = ffmpeg.probe(filename, select_streams='a')

    # If p['streams'] is not empty, clip has an audio stream
    if p['streams']:
        print('Video clip has audio!')

n = len(sys.argv)

idx = 0
cnt_success = 0
cnt_failed = 0
cnt_exist = 0
start = time.time()

if n == 1:
    download_videos(1)
else:
    arg = sys.argv[1]
    if arg.isnumeric():
        days = int(arg)
        download_videos(days)
    elif "http" in arg:
        url = arg
        if ".mp4" in url:
            save_video_file(url)
        elif ".jpg" in url:
            download_pics(url)
        else:
            video_list = get_video_urls(url)
            if video_list:
                save_video_files(video_list)
            else:
                print("No valid video found!")
    elif ".mp4" in arg:
        isAudioIncluded(arg)
    else:
        print("Invalid argument!")

end = time.time()
print("Time used: %s Secs" % (end - start))