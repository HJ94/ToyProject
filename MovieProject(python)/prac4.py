import os
import sys
import json
import urllib.request
client_id = "L2VNblW5zyeEhe1spHWn"
client_secret = "wLXwWM8n0C"
encText = urllib.parse.quote("임희재")
url = "https://openapi.naver.com/v1/search/movie?query=" + encText # json 결과
# url = "https://openapi.naver.com/v1/search/blog.xml?query=" + encText # xml 결과
request = urllib.request.Request(url)
request.add_header("X-Naver-Client-Id",client_id)
request.add_header("X-Naver-Client-Secret",client_secret)
response = urllib.request.urlopen(request)
rescode = response.getcode()

result = response.read()

r = json.loads(result)

total = r['total']

items = r['items']

print(total, items)
