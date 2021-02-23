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
from urllib.request import Request, urlopen

DOWNLOAD_PATH_TH = "/Users/samueltan/Downloads/download/auto/th/"

log = False
download = True
# log = True
# download = False

def getTimeByUnit(dur):
    if dur < 60:
        return "00:00:%s" % str(dur)
    elif dur < 3600:
        min = int(dur/60)
        sec = int(dur - min * 60)
        return "00:%s:%s" % (str(min), str(sec))
    else:
        hour = int(dur/3600)
        min = int((dur - hour * 3600)/60)
        sec = int(dur - min * 60 - hour * 3600)
        return "00:%s:%s" % (str(min), str(sec))


n = len(sys.argv)
if n != 2:
    print("Invalid argument!")
    quit()

url = sys.argv[1]
# https://my.cdn.tokyo-hot.com/media/samples/6390.mp4
# https://my.cdn.tokyo-hot.com/media/samples/21262.mp4
# https://my.cdn.tokyo-hot.com/media/samples/40886.mp4
# https://my.cdn.tokyo-hot.com/media/samples/n1524.mp4
# https://my.tokyo-hot.com/product/S2MBD-045/

pattern = "(https:[^\d]*\/)(([^\/]*[^\d\/])?([\d]*)\.mp4)"
match = re.search(pattern, url)

url_prefix = match.group(1)
file_name = match.group(2)
file_prefix = match.group(3) if match.group(3) else ""
sid = match.group(4)
width = len(sid)
id = int(sid)
print("url_prefix = " + url_prefix)
print("file_name = " + file_name)
print("file_prefix = " + file_prefix)
print("sid = " + sid)

idx = 0
cnt_success = 0
cnt_exist = 0
cnt_fail = 0
start = time.time()
i = id
while cnt_fail <= 2:
    file_name = file_prefix + str(i).zfill(width) + ".mp4"
    file_path = DOWNLOAD_PATH_TH + file_name
    current_url = url_prefix + file_name

    if log:
        print("file_name = " + file_name)
        print("current_url = " + current_url)

    now = datetime.now().strftime("%H:%M:%S")
    if os.path.exists(file_path):
        cnt_exist += 1
        print("[%s]: The file '%s' already exists!" % (now, file_path))
    else:
        try:
            if download:
                idx += 1
                print("[%s] %d: Downloading video '%s' as file '%s' ..." % (now, idx, current_url, file_path), end="", flush=True)
                r = requests.get(current_url, verify=True)
                if r.status_code == 200:
                    with open(file_path, 'wb') as f:
                        f.write(r.content)
                        print(" Completed!")
                        cnt_success += 1
                else:
                    print()
                    cnt_fail += 1
        except Exception as e:
            print("\nException with url: <%s>, file name: <%s>" % (current_url, file_name))
            # print(e)
            raise 
    i += 1

cnt_fail = 0
i = id - 1
while cnt_fail <= 2:
    file_name = file_prefix + str(i).zfill(width) + ".mp4"
    file_path = DOWNLOAD_PATH_TH + file_name
    current_url = url_prefix + file_name

    if log:
        print("file_name = " + file_name)
        print("current_url = " + current_url)

    now = datetime.now().strftime("%H:%M:%S")
    if os.path.exists(file_path):
        cnt_exist += 1
        print("[%s]: The file '%s' already exists!" % (now, file_path))
    else:
        try:
            if download:
                idx += 1
                print("[%s] %d: Downloading video '%s' as file '%s' ..." % (now, idx, current_url, file_path), end="", flush=True)
                r = requests.get(current_url, verify=True)
                if r.status_code == 200:
                    with open(file_path, 'wb') as f:
                        f.write(r.content)
                        print(" Completed!")
                        cnt_success += 1
                else:
                    print()
                    cnt_fail += 1
        except Exception as e:
            print("\nException with url: <%s>, file name: <%s>" % (current_url, file_name))
            # print(e)
            raise 
    i -= 1

print("\nSuccessful: %s" % cnt_success)
print("Failed: %s" % cnt_fail)
print("Already Existed: %s" % cnt_exist)
end = time.time()
dur = getTimeByUnit(end - start)
print("Time used: %s" % dur)