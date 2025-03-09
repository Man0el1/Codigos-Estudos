from PIL import Image
im = Image.open("python_challenge\\challenge7_zoxygen.png")

im = im.convert('RGB')
im = im.crop((0, 45, 605, 50))

pixels = ""
cod_x = 0
cod_y = 0

while cod_x < 605:
    pixel = im.getpixel((cod_x, cod_y))
    pixels += chr(pixel[0])
    cod_x += 7
    
print(pixels)
    
valores_ascii = [105, 110, 116, 101, 103, 114, 105, 116, 121]
mensagem_ascii = ""
for pixel in valores_ascii:
    mensagem_ascii += chr(pixel)

print(mensagem_ascii)