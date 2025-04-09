import tkinter as tk
from tkinter import *
from tkinter import ttk
from tkinter import font
from tkinter import filedialog as fd
from PIL import Image

def imagem_transparente(image_filename):
    if image_filename:
        global imagem
        imagem = Image.open(image_filename)
        imagem = imagem.convert("RGBA")
        datas = imagem.getdata()

        novadata = []
        cor = lista_cores.get()
        if cor == "Branco":
            for item in datas:
                if item[0] >= 245 and item[1] >= 245 and item[2] >= 245:
                    novadata.append((255, 255, 255, 0))
                else:
                    novadata.append(item)
        elif cor == "Preto":
            for item in datas:
                if item[0] <= 10 and item[1] <= 10 and item[2] <= 10:
                    novadata.append((255, 255, 255, 0))
                else:
                    novadata.append(item)
        else:
            return None
        
        imagem.putdata(novadata)
        imagem.show()
        print(imagem)
        #frame_pergunta.tkraise()
        return imagem
        #imagem.save(image_filename, "PNG")
    else:
        return None
    
def selecionar_imagem():
    global filename
    filename = fd.askopenfilename(title="Escolha uma imagem", filetypes=[("Arquivos PNG", "*.png"),("Arquivos JPEG", "*.jpeg"),("Arquivos JPG", "*.jpg")])

filename = ""
imagem = None

janela = tk.Tk()
frame_principal= Frame(janela)
frame_principal.grid(row=0, column=0, sticky="nsew")
frame_pergunta = Frame(janela)
frame_pergunta.grid(row=0, column=0, sticky="nsew")

fonte_label = font.Font(font="Arial",size=10)

label_titulo = Label(frame_principal, text="Imagem para deixar transparente", font=fonte_label)
label_titulo.grid(row=0, column=0, columnspan=2, pady=10, padx=65)

botao_imagem = Button(frame_principal, text="Selecionar Imagem", command=lambda: selecionar_imagem())
botao_imagem.grid(row=1, column=0, columnspan=2, pady=10)

label_cor = Label(frame_principal, text="Cor a retirar", font=fonte_label)
label_cor.grid(row=2, column=0, columnspan=2, pady=5, padx=65)

cores = ["Branco", "Preto"]
lista_cores = ttk.Combobox(frame_principal, height=6, values=cores, state="readonly")
lista_cores.grid(row=3, column=0, columnspan=2, pady=10)
lista_cores.set("Branco")

botao_funcao_transparente = Button(frame_principal, text="Concluir", command=lambda: imagem_transparente(filename))
botao_funcao_transparente.grid(row=4, column=0, columnspan=2, pady=5, padx=65)

frame_principal.tkraise()
janela.title("Trans")
janela.geometry("400x400")
janela.resizable(False,False)
janela.configure(background="#ffffff")
janela.mainloop()