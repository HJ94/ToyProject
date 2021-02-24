import requests
from bs4 import BeautifulSoup

from pymongo import MongoClient           # pymongo를 임포트 하기(패키지 인스톨 먼저 해야겠죠?)
client = MongoClient('localhost', 27017)  # mongoDB는 27017 포트로 돌아갑니다.
db = client.dbsparta

headers = {'User-Agent' : 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36'}
data = requests.get('https://movie.naver.com/movie/running/premovie.nhn?order=reserve',headers=headers)

soup = BeautifulSoup(data.text, 'html.parser')


images = soup.select('#content > div.article > div:nth-child(1) > div.lst_wrap > ul > li')

for image in images:
    img_tag = image.select_one('div > a > img')
    if not img_tag == None:
        img = (img_tag['src'])

        doc = {
            'img' : img
        }
        db.movieList.insert_one(doc)