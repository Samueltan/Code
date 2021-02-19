import os

source_location = "/Users/samueltan/Downloads/download/auto/farm"
prefix = ""
suffix = "_content_full"

cnt = 0
for file in os.listdir(source_location):
    print(os.path.join(source_location, file))
    file_name_split = os.path.splitext(file)
    file_name = file_name_split[0]
    file_ext = file_name_split[1]
    if not prefix in file:
        new_name = prefix + file_name
    if not suffix in file:
        new_name = file_name + suffix
        
    os.rename(os.path.join(source_location, file), os.path.join(source_location, new_name + file_ext))