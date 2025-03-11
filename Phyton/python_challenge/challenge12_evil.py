data = open("Phyton\\python_challenge\\challenge12_evil2.gfx").read()
for i in range(5):
    open('%d.jpg' % i ,'wb').write(data[i::5])
    
# Essa era pra ser a resposta, mas o codigo n funciona e eu não sei por que, eu só vou pular mesmo '-'