import tkinter as tk
from tkinter import *

calculo = ""

#Comandos
def adicionar_ao_calculo(simbolo):
    global calculo
    calculo += str(simbolo)
    txt_resultado.delete(1.0, "end")
    txt_resultado.insert(1.0, calculo)

def validar_calculo():
    global calculo
    try:
        calculo = str(eval(calculo))
        txt_resultado.delete(1.0, "end")
        txt_resultado.insert(1.0, calculo)
        calculo = ""
    except:
        limpar_calculo()
        txt_resultado.insert(1.0, "Error")
        
def limpar_calculo():
    global calculo
    calculo = ""
    txt_resultado.delete(1.0, "end")
    
#Janela
janela = tk.Tk()
janela.title("Calc do Manolo :3")
janela.geometry("300x275")
janela.resizable(False,False)
janela.configure(background="#1c1c1c")

#Texto resultado
txt_resultado = tk.Text(janela, height=2, width=16, font=("Arial", 24), bg="#505050", fg="#ffffff", bd=0)
txt_resultado.grid(columnspan=5)

#Botões
bt0 = tk.Button(janela, width=5, text="0", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(0)))
bt0.grid(row=6, column=2)
bt1 = tk.Button(janela, width=5, text="1", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(1)))
bt1.grid(row=5, column=1)
bt2 = tk.Button(janela, width=5, text="2", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(2)))
bt2.grid(row=5, column=2)
bt3 = tk.Button(janela, width=5, text="3", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(3)))
bt3.grid(row=5, column=3)
bt4 = tk.Button(janela, width=5, text="4", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(4)))
bt4.grid(row=4, column=1)
bt5 = tk.Button(janela, width=5, text="5", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(5)))
bt5.grid(row=4, column=2)
bt6 = tk.Button(janela, width=5, text="6", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(6)))
bt6.grid(row=4, column=3)
bt7 = tk.Button(janela, width=5, text="7", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(7)))
bt7.grid(row=3, column=1)
bt8 = tk.Button(janela, width=5, text="8", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(8)))
bt8.grid(row=3, column=2)
bt9 = tk.Button(janela, width=5, text="9", bg="#505050", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(9)))
bt9.grid(row=3, column=3)

bt_soma = tk.Button(janela, width=5, text="+", bg="#ff9501", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo("+")))
bt_soma.grid(row=5, column=4)
bt_sub = tk.Button(janela, width=5, text="-", bg="#ff9501", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo("-")))
bt_sub.grid(row=4, column=4)
bt_mult = tk.Button(janela, width=5, text="*", bg="#ff9501", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo("*")))
bt_mult.grid(row=3, column=4)
bt_div = tk.Button(janela, width=5, text="/", bg="#ff9501", fg="#ffffff", font=("Arial", 14), command=(lambda: adicionar_ao_calculo("/")))
bt_div.grid(row=2, column=4)

bt_ponto = tk.Button(janela, width=5, text=".", bg="#d4d4d2", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(".")))
bt_ponto.grid(row=6, column=1)
bt_open = tk.Button(janela, width=5, text="(", bg="#d4d4d2", font=("Arial", 14), command=(lambda: adicionar_ao_calculo("(")))
bt_open.grid(row=2, column=2)
bt_close = tk.Button(janela, width=5, text=")", bg="#d4d4d2", font=("Arial", 14), command=(lambda: adicionar_ao_calculo(")")))
bt_close.grid(row=2, column=3)

bt_igual = tk.Button(janela, width=11, text="=", bg="#ff9501", fg="#ffffff", font=("Arial", 14), command=validar_calculo)
bt_igual.grid(row=6, column=3, columnspan=2)
bt_ac = tk.Button(janela, width=5, text="AC", bg="#d4d4d2", font=("Arial", 14), command=limpar_calculo)
bt_ac.grid(row=2, column=1)

janela.mainloop()