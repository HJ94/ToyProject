from urllib.request import Request, urlopen
from bs4 import BeautifulSoup

url = "https://movie.naver.com/movie/running/premovie.nhn?order=reserve"
html = urlopen(url).read()
soup = BeautifulSoup(html, "html.parser")

img = soup.find("li")

print(img)