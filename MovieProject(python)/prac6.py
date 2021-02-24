from flask import Flask, render_template, request, jsonify
from urllib.request import urlopen
from bs4 import BeautifulSoup
app = Flask(__name__)

from pymongo import MongoClient           # pymongo를 임포트 하기(패키지 인스톨 먼저 해야겠죠?)
client = MongoClient('localhost', 27017)  # mongoDB는 27017 포트로 돌아갑니다.
db = client.dbsparta                      # 'dbsparta'라는 이름의 db를 만듭니다.

import requests
import urllib.request
import urllib.parse
import json
## URL 별로 함수명이 같거나,
## route('/') 등의 주소가 같으면 안됩니다.





@app.route('/')
def home():
    return render_template('first_page.html')

# 슬라이드에 들어갈 이미지
@app.route('/slide/search', methods=['POST'])
def slide_search():
    headers = {
        'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64)AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36'}
    data = requests.get('https://movie.naver.com/movie/running/premovie.nhn?order=reserve', headers=headers)

    soup = BeautifulSoup(data.text, 'html.parser')

    images = soup.select('#content > div.article > div:nth-child(1) > div.lst_wrap > ul > li')

    for image in images:
        img_tag = image.select_one('div > a > img')
        if not img_tag == None:
            img = (img_tag['src'])

            doc = {
                'img': img
            }
            db.movieList.insert_one(doc)

    return jsonify({'result':'success'})

## 영화 검색
@app.route('/api/search', methods=['POST'])
def api_search(request=request):

    client_id = "L2VNblW5zyeEhe1spHWn"
    client_secret = "wLXwWM8n0C"

    keyword_receive = request.form['keyword_give']
    baseurl = "https://openapi.naver.com/v1/search/movie?query="  # json 결과
    plusurl = keyword_receive
    url = baseurl + urllib.parse.quote(plusurl)

    request = urllib.request.Request(url)
    request.add_header("X-Naver-Client-Id", client_id)
    request.add_header("X-Naver-Client-Secret", client_secret)
    response = urllib.request.urlopen(request)

    result = response.read()

    r = json.loads(result)

    gus = r['items']

    for gu in gus:
        doc = {
            'title': gu['title'],
            'link': gu['link'],
            'image': gu['image'],
            'actor': gu['actor'],
            'director': gu['director']
        }
        if gus is not None:
            db.movies.insert_one(doc)
        else:
            return False

    return jsonify({'result':'success'})

@app.route('/api/show', methods=['GET'])
def api_show():
    all_movies = list(db.movies.find({},{'_id':0}))
    return jsonify({'result':'success', 'movies' :all_movies})



@app.route('/slide/show', methods=['GET'])
def slide_show():
    all_image = list(db.movieList.find({},{'_id':0}))
    return jsonify({'result':'success', 'slides' :all_image})


if __name__ == '__main__':
    app.run('0.0.0.0',port=5000,debug=True)