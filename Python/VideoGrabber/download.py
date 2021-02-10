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
import urllib.request

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
        if log:
            print(str(error) + "\n " + query)

# get bookmarks from firefox sqlite database file and print all
def process_bookmarks(cursor, timestamp):
    bookmarks_query = """select url, moz_places.title from moz_places join \
        moz_bookmarks on moz_bookmarks.fk=moz_places.id 
        where moz_bookmarks.dateAdded >= {}
        and moz_places.url like 'http%'
        order by dateAdded desc;""".format(timestamp)
    if log:
        print(bookmarks_query)

    execute_query(cursor, bookmarks_query)
    for row in cursor:
        link = row[0]
        title = row[1]
        file_list = get_mp4_urls(link)
        save_files(file_list)

# get the file urls from the link
def get_mp4_urls(link):
    print("Processing url: '%s'" % link)
    
    r = requests.get(link)
    page_source = r.text.split('\n')
    mp4_urls = []
    jpg_urls = []
    # pattern_hd = '"(https?:\\\\?\/\\\\?\/[^"(]*720P_[^"]*\.mp4[^"]*)"'
    pattern_mp4 = '["\'](https?:\\\\?\/\\\\?\/[^"\'(]*\.mp4[^\'"]*)["\']'
    pattern_jpg = '["\'](https?:\\\\?\/\\\\?\/[^"\\\'(]*\.jpg[^\\\'"]*)["\']'
    # pattern_jpg = '\'(https?:\\\\?\/\\\\?\/[^"\'(]*\.jpg[^\'"]*)\''

    if log:
        print("pattern_mp4: " + pattern_mp4)
    for row in page_source:
        matches = re.findall(pattern_mp4, row)
        p720_found = False
        p480_found = False
        p360_found = False
        selected_url = ""

        if matches:
            # find mp4 files
            for match in matches:
                matched_url = match.replace("\/", "/")

                if "720P" in match or "720p" in match:
                    p720_found = True
                    selected_url = matched_url
                    break
                elif "480P" in match or "480p"  in match:
                    p480_found = True
                    if not p720_found:
                        selected_url = matched_url
                elif "360P" in match or "360p"  in match:
                    p360_found = True
                    if not p480_found and not p720_found:
                        selected_url = matched_url
                elif "240P" in match or "240p"  in match:
                    continue
                else:
                    selected_url = matched_url
            if selected_url:
                mp4_urls.append(selected_url)
                
        else:
            # find jpg files
            matches = re.findall(pattern_jpg, row)
            for match in matches:
                matched_url = match.replace("\/", "/")
                jpg_urls.append(matched_url)

    return mp4_urls if len(mp4_urls) != 0 else jpg_urls

# save the files to a specific location
def save_files(urls):
    for url in urls:
        try:
            save_file(url)
        except Exception as e:
            if log:
                print(e)
            continue

# save a single file from the url
def save_file(url):
    global idx
    global cnt_success
    global cnt_failed
    global cnt_exist

    file_size = urllib.request.urlopen(url).length
    if ".mp4" in url:
        if file_size < 1024 * 1024:
            print("Small mp4 file is ignored..")
            return

        # download a single mp4 file
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
            pattern = '([^"\'\/(]*\/)*\/([^"\'\/(]+?\/[^"\'\/(]*\.mp4).*'
        match = re.search(pattern, url)
        if match:
            if source == 'FJSM':
                file_name = match.group(2) + '.mp4'
                file_path = DOWNLOAD_PATH + 'fjsm/'
            elif source == 'UL':
                file_name = 'uralesbian_' + match.group(2) + '.mp4'
                file_path = DOWNLOAD_PATH + 'fjsm/' + file_name
            elif source == 'LG':
                file_name = 'lollipopgirls_' + match.group(2) + '.mp4'
                file_path = DOWNLOAD_PATH + 'fjsm/' + file_name
            else:
                file_name = match.group(2).replace('/', '_')
                if log:
                    print("file_name = " + file_name)
                file_path = DOWNLOAD_PATH + file_name

            if log:
                print("file_path = " + file_path)
            now = datetime.now().strftime("%H:%M:%S")

            if os.path.exists(file_path):
                cnt_exist += 1
                print("[%s] %d: The file '%s' already exists!" % (now, idx, file_path))
            else:
                print("[%s] %d: Downloading '%s' as file '%s' ..." % (now, idx, url, file_path), end="", flush=True)

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
            print("No valid file found!")
        
    else:
        # download a single jpg file
        if "thumb" in url:
            return

        if file_size < 50 * 1024:
            # print("Small jpg file is ignored..")
            return

        idx += 1
        pattern_jpg = '\/([^\/]+\/[^\/]+.jpg)$'
        match_jpg = re.search(pattern_jpg, url)
        jpg_name = match_jpg.group(1).replace("/", "_")
        file_path = DOWNLOAD_PATH + 'pic/misc/' + jpg_name
        now = datetime.now().strftime("%H:%M:%S")

        if log:
            print("[%s] file url: '%s'" % (now, url))

        if os.path.exists(file_path):
            cnt_exist += 1
            print("[%s] %d: The file '%s' already exists!" % (now, idx, file_path))
        else:
            print("[%s] %d: Downloading '%s' as '%s' ..." % (now, idx, url, file_path), end="", flush=True)

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
                print("\nException with url: <%s>, file name: <%s>" % (url, jpg_name))
                # print(e)
                raise 

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
def download_group_pics(url):
    pattern_with_leadingno_group  = '(http.*\/()(\d+)((_|-).*?)\/(.*?)(_|-)?)(\d+).jpg'
    pattern_with_scene_group      = '(http.*\/.*?(-|_)scene(\d+)()()\/(.*?)(_|-)?)(\d+).jpg'
    pattern_with_onlyno_group     = '(http.*\/()(\d+)()()\/(.*?)(_|-)?)(\d+).jpg'
    pattern_no_digit_group        = '(http.*\/()([^\d]*?)()()\/(.*?)(_|-)?)(\d+).jpg'

    pic_patterns = [
        pattern_with_leadingno_group,
        pattern_with_scene_group,
        pattern_with_onlyno_group,
        pattern_no_digit_group
    ]

    for pic_pattern in pic_patterns:
        # print(pic_pattern)
        match = re.search(pic_pattern, url)
        if match:
            full_prefix = match.group(1)
            group = match.group(3)
            name = match.group(6) if match.group(6) else ""
            index = match.group(8)

            folder = DOWNLOAD_PATH + 'pic/' + name if name else DOWNLOAD_PATH + 'pic/' + group
            Path(folder).mkdir(parents=True, exist_ok=True)
            if log:
                print("full_prefix = " + full_prefix)
                print("folder = " + folder)
                print("name = " + name)

            save_pics(full_prefix, group, name, index)
            break

# save pics based on group id and file name
def save_pics(full_prefix, group, name, index):
    # Save pics from current group number back to possible decreasing group number until failed or group number 1
    if group:
        gi = int(group) + 1 if group.isnumeric() else 1
    else:
        gi = 1
    cnt = 0
    fail = 0
    while gi >= 1:
        gi -= 1
        cnt, fail = save_pic_group(full_prefix, group, name, index, gi, cnt, fail)

        if not group or not group.isnumeric() or fail > 1:
            break

    # Save pics from current group number to possible increasing group numbers until failed
    if group:
        gi = int(group) if group.isnumeric() else 0
    else:
        gi = 0
    while group and group.isnumeric():
        gi += 1
        cnt, fail = save_pic_group(full_prefix, group, name, index, gi, cnt, fail)

        if fail > 1:
            break

#
def save_pic_group(full_prefix, group, name, index, gi, cnt, fail):
    i = 0
    group_fail = fail
    while True:
        try:
            i += 1
            current_url = ''
            current_url_zfilled = ''
            full_prefix_zfilled = full_prefix
            now = datetime.now().strftime("%H:%M:%S")
            if group:
                if group.isnumeric():
                    suffix = str(gi).zfill(3) + str(i).zfill(3)
                else:
                    suffix = group + '-' + str(i).zfill(3)

                file_name = name + '-' + suffix if name else suffix
            else:
                file_name = name + '-' + str(i).zfill(3)
            file_name = file_name.replace('/', '_')
            folder = DOWNLOAD_PATH + 'pic/' + name if name else DOWNLOAD_PATH + 'pic/' + group
            full_file_path = folder + '/' + file_name + '.jpg'
            if log:
                print("file_name = " + file_name)

            if os.path.exists(full_file_path):
                cnt += 1
                print("[%s] %d: The file '%s' already exists!" % (now, cnt, full_file_path))
            else:
                if group and group.isnumeric():
                    pattern_digit = '/[^/]*?(\d+)[^/]*\/' + name + '(-|_)?$' if name else '/[^/]*?(\d+)[^/]*\/' + '$'
                    match_digit = re.search(pattern_digit, full_prefix)
                    zero_width = len(group) - len(str(int(group)))
                    group_new = str(gi).zfill(len(str(gi)) + zero_width)
                    group_new_zfilled = str(gi).zfill(len(group))
                    if log:
                        print("gi = " + str(gi))
                        print("pattern_digit = " + pattern_digit)
                        print("full_prefix1 = " + full_prefix)
                        print("group_new = " + group_new)
                    full_prefix = full_prefix.replace(match_digit.group(1), group_new)
                    full_prefix_zfilled = full_prefix.replace(match_digit.group(1), group_new_zfilled)

                current_url = full_prefix + str(i) + '.jpg'
                current_url_zfilled = full_prefix_zfilled + str(i).zfill(len(index)) + '.jpg'
                if log:
                    print("full_prefix = " + full_prefix)
                    print("current_url = " + current_url)
                    print("current_url_zfilled = " + current_url_zfilled)

                    print("gi = %d, current_url = %s" % (gi, current_url))

                print("[%s] %d: Downloading '%s' as '%s' ..." % (now, cnt, current_url, full_file_path), end="", flush=True)
                r = requests.get(current_url, allow_redirects=False)
                if r.status_code == 200:
                    group_fail = 0
                    cnt += 1
                    with open(full_file_path, 'wb') as f:
                        f.write(r.content)
                        print(" Completed!")
                else:
                    if log:
                        print("gi = %d, current_url_zfilled = %s" % (gi, current_url_zfilled))

                    print("[%s] %d: Downloading '%s' as '%s'..." % (now, cnt, current_url, full_file_path), end="", flush=True)
                    r = requests.get(current_url_zfilled, allow_redirects=False)
                    if r.status_code == 200:
                        group_fail = 0
                        cnt += 1
                        with open(full_file_path, 'wb') as f:
                            f.write(r.content)
                            print(" Completed!")
                    else:
                        group_fail += 1
                        break
        except Exception as e:
            print("\nException with url: <%s>, file name: <%s>" % (current_url, file_name))
            # print(e)
            break

    return cnt, group_fail

# check if a video contains audio track or not
def isAudioIncluded(filename):
    p = ffmpeg.probe(filename, select_streams='a')

    # If p['streams'] is not empty, clip has an audio stream
    if p['streams']:
        print("Video clip has audio!")

n = len(sys.argv)

idx = 0
cnt_success = 0
cnt_failed = 0
cnt_exist = 0
start = time.time()
# log = True
log = False

if n == 1:
    # Download from bookmark db
    download_videos(1)
else:
    arg = sys.argv[1]
    if arg.isnumeric():
        # Download from bookmark db back to days
        days = int(arg)
        download_videos(days)
    elif "http" in arg:
        # Download from the given url
        url = arg
        if ".mp4" in url:
            # Download a single mp4 file
            save_file(url)
        elif ".jpg" in url:
            # Download jpg files with the similar group/file names
            download_group_pics(url)
        else:
            # Url doesn't contain mp4/jpg directly, needs to open the link and check the page source for possible mp4/jpg files
            file_list = get_mp4_urls(url)
            if file_list:
                if log:
                    print("**********************************")
                    for filename in file_list:
                        print(filename)
                    print("**********************************")
                save_files(file_list)
            else:
                print("No valid file found!")
    elif ".mp4" in arg:
        isAudioIncluded(arg)
    else:
        print("Invalid argument!")

print("\nSuccessful: %s" % cnt_success)
print("Failed: %s" % cnt_failed)
print("Already Existed: %s" % cnt_exist)
end = time.time()
print("Time used: %s Secs" % (end - start))
