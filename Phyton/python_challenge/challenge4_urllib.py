import urllib.request as url
nextNothing = "12345"
for i in range(1, 400):
    response = url.urlopen(f"http://www.pythonchallenge.com/pc/def/linkedlist.php?nothing={nextNothing}")
    nextNothing = ""
    html = response.read().decode('utf-8')
    print(f"{html} // Numero {i}")
    for char in html:
        if char.isdigit():
            nextNothing += char