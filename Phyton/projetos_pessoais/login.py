import tkinter as tk
from tkinter import *
from tkinter import font

janela = tk.Tk()

fonte_label = font.Font(font="Arial",size=10)

frame_login = Frame(janela)
frame_login.grid(row=0, column=0, sticky="nsew")
frame_confirma = Frame(janela)
frame_confirma.grid(row=0, column=0, sticky="nsew")



janela.title("Login")
janela.geometry("500x300")
janela.attributes("-topmost",True)