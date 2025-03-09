import tkinter as tk
from tkinter import *
from PIL import Image, ImageTk
import pygame
import time

janela = tk.Tk()
tamanho_janela = (540, 382)
frame_procurado = Frame(janela)
frame_procurado.grid(row=0, column=0, sticky="nsew")
frame_principal = Frame(janela, bg="#1c1c1c")
frame_principal.grid(row=0, column=0, sticky="nsew")
frame_meme = Frame(janela)
frame_meme.grid(row=0, column=0, sticky="nsew")

pygame.mixer.init()
musica = pygame.mixer.Sound("wanted.mp3")
musica.play(loops=-1)

img = Image.open("wanted_luigi.png")
imagem_wanted = ImageTk.PhotoImage(img.resize(tamanho_janela))
wanted_luigi = tk.Label(frame_procurado, image=imagem_wanted, bd=0)
wanted_luigi.grid()

img_luigi = ImageTk.PhotoImage(Image.open("luigi.png"))
luigi = tk.Label(frame_principal, image=img_luigi, bd=0)
luigi.grid()

frame_procurado.tkraise()
janela.title("Find Luigi")
janela.geometry(f"{tamanho_janela[0]}x{tamanho_janela[1]}+508+200")
janela.resizable(False,False)
janela.configure(background="#1c1c1c")
janela.mainloop()

