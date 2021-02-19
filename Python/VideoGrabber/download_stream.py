import requests
 
def download_file(url, path):
    with requests.get(url, stream=True) as r:
        chunk_size = 1024
        content_size = int(r.headers['content-length'])
        print('Start downloading')
        with open(path, "wb") as f:
            for chunk in r.iter_content(chunk_size=chunk_size):
                f.write(chunk)
 
 
if __name__ == '__main__':
    url = 'https://scratch.mit.edu/#'
    path = '/Users/samueltan/Downloads/download/auto/stream/test.mp4'
    download_file(url, path)