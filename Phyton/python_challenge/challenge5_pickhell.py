import urllib.request as url
import pickle

pagina = "http://www.pythonchallenge.com/pc/def/banner.p"
raw = url.urlopen(pagina)
pick = pickle.load(raw)
print(pick)

for linha in pick:
    print("".join(map(lambda pair: pair[0] * pair[1], linha)))
    