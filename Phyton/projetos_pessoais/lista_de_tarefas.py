import tkinter as tk
from tkinter import *
from tkinter import font
from tkinter import ttk

janela = tk.Tk()

def delete_selecao():
    selecao = (lista_tarefas.curselection())
    if selecao:
        lista_tarefas.delete(selecao)
        
def add_lembrete():
    if lembrete_texto:
        lista_tarefas.insert(0, str(lembrete_texto.get()))
        lembrete_texto.set("")
        frame_principal.tkraise()
    
fonte_label = font.Font(font="Arial",size=10)

frame_principal = Frame(janela)
frame_principal.grid(row=0, column=0, sticky="nsew")
frame_add = Frame(janela)
frame_add.grid(row=0, column=0, sticky="nsew")

lembrete_texto = StringVar(frame_add)

# No frame_principal
label1 = Label(frame_principal, text="Lista de Lembretes", font=fonte_label)
label1.grid(row=0, column=0, columnspan=2, pady=10, padx=65)

lista_tarefas = Listbox(frame_principal)
lista_tarefas.grid(row=1, columnspan=2, column=0)
lista_tarefas.insert(0,"teste")

botao_add = Button(frame_principal, text="Adicionar Lembrete", command=lambda: frame_add.tkraise())
botao_add.grid(row=2, column=0, pady=20, padx=0)

botao_remove = Button(frame_principal, text="Deletar Lembrete", command=lambda: delete_selecao())
botao_remove.grid(row=2, column=1, pady=20, padx=0)

# No frame_add
label2 = Label(frame_add, text="Adicionar Lembrete", font=fonte_label)
label2.grid(row=0, column=0, pady=10, padx=65)

lembrete = Entry(frame_add, font=fonte_label, textvariable=lembrete_texto)
lembrete.grid(row=1,column=0)

botao2 = Button(frame_add, text="Adicionar", command=lambda: add_lembrete())
botao2.grid(row=2, column=0, pady=30)

frame_principal.tkraise()
janela.title("Lembretes :3")
janela.geometry("300x275")
janela.resizable(True,True)
janela.configure(background="#ffffff")
janela.attributes('-topmost',True)
janela.mainloop()