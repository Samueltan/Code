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

FAIL_LIMIT = 50
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

# https://my.tokyo-hot.com/product/SKYHD-028/
# https://my.cdn.tokyo-hot.com/media/samples/6390.mp4
# https://my.cdn.tokyo-hot.com/media/samples/21262.mp4
# https://my.cdn.tokyo-hot.com/media/samples/40886.mp4
# https://my.cdn.tokyo-hot.com/media/samples/n1524.mp4
url = sys.argv[1]
url_new = url.replace("tokyo-hot.com/product", "cdn.tokyo-hot.com/media/samples")
url_new = url_new[:-1] + ".mp4"
pattern = "(https:[^\d]*\/)(([^\d\/]*)([\d]*)([^\d\/]*)\.mp4)"
match = re.search(pattern, url_new)

# url_prefix = match.group(1)
url_prefix = "https://my.cdn.tokyo-hot.com/media/samples/"
file_name = match.group(2)
file_prefix = match.group(3) if match.group(3) else ""
sid = match.group(4)
file_suffix = match.group(5) if match.group(5) else ""
width = len(sid)
id = int(sid)
if log:
    print("url_new = " + url_new)
    print("url_prefix = " + url_prefix)
    print("file_name = " + file_name)
    print("file_prefix = " + file_prefix)
    print("file_suffix = " + file_suffix)
    print("sid = " + sid)

idx = 0
cnt_success = 0
cnt_exist = 0
cnt_fail = 0
start = time.time()
i = id
while cnt_fail <= FAIL_LIMIT:
    file_name = file_prefix + str(i).zfill(width) + file_suffix + ".mp4"
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
                        cnt_fail = 0
                else:
                    print(" Failed!")
                    cnt_fail += 1
        except Exception as e:
            print("\nException with url: <%s>, file name: <%s>" % (current_url, file_name))
            # print(e)
            raise 
    i += 1

cnt_fail2 = 0
i = id - 1
while cnt_fail2 <= FAIL_LIMIT:
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
                        cnt_fail2 = 0
                else:
                    print(" Failed!")
                    cnt_fail2 += 1
        except Exception as e:
            print("\nException with url: <%s>, file name: <%s>" % (current_url, file_name))
            # print(e)
            raise 
    i -= 1

print("\nSuccessful: %s" % cnt_success)
print("Failed: %s" % str(cnt_fail + cnt_fail2))
print("Already Existed: %s" % cnt_exist)
end = time.time()
dur = getTimeByUnit(end - start)
print("Time used: %s" % dur)