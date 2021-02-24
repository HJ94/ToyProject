from urllib.request import urlopen
import bs4
import json

url = "https://search.naver.com/search.naver?sm=top_hty&fbm=1&ie=utf8&query=%EA%B0%9C%EB%B4%89+%EC%98%88%EC%A0%95%EC%98%81%ED%99%94"
html = urlopen(url)

bs_obj = bs4.BeautifulSoup(html.read(), "html.parser")

ul = bs_obj.find("ul", {"class": "thumb_list" })

lis = ul.findAll("li")

print(lis)