import os

source_location = "/Volumes/Seagate 3T/System Volume Information"
avatar_location = "/Users/samueltan/Downloads/download/avatar"

cnt = 0
cnt_exists = 0
for root, dirs, files in os.walk(source_location):
    for file in files:
        if file.startswith("._") or not file.endswith(".mp4"):
            continue

        # full_path = os.path.join(avatar_location, file)
        # if os.path.exists(full_path):
        #     cnt_exists += 1
        #     print("%d: The file '%s' already exists!" % (cnt_exists, os.path.join(root, file)))
        # else:
        #     cnt += 1
        #     open(full_path, 'a').close()

print("%d files have been created as avatars!" % cnt)