from PIL import Image

file_name = "Phyton\python_challenge\challenge11_thecave.jpg"
im = Image.open(file_name)

#640x480
cod_x = 0
cod_y = 0
odd = Image.new(mode="RGB", size=im.size)
even = Image.new(mode="RGB", size=im.size)

while cod_y < im.size[1]:
    
    while cod_x < im.size[0]:
        pixel = im.getpixel((cod_x, cod_y))
        
        if (cod_x+cod_y) % 2 == 0:
            even.putpixel((cod_x, cod_y),pixel)
        else:
            odd.putpixel((cod_x, cod_y),pixel)
        cod_x += 1
        
    cod_y += 1
    cod_x = 0
        
odd.show()
even.show()

# mano que porra é essa, eu juro vai virar um DNBHL daqui a pouco