a = ['1','11','21','1211','111221']

def terminar_sequencia(numero_seguinte, unidade_comparada, ocorrencias):
    numero_seguinte += str(ocorrencias) + unidade_comparada
    return numero_seguinte

for xd in range(26):
    num_atual = a[-1]
    tamanho = len(num_atual)
    tamanho_atual = 0
    ocorrencias = 0
    numero_seguinte = ''
    unidade_comparada = ''

    for unidade in num_atual:
        tamanho_atual += 1  
        
        if unidade_comparada == '':
            unidade_comparada = unidade
            ocorrencias = 1
        elif unidade == unidade_comparada:
            ocorrencias += 1
        else:
            numero_seguinte = terminar_sequencia(numero_seguinte, unidade_comparada, ocorrencias)
            unidade_comparada = unidade
            ocorrencias = 1
            
        if tamanho_atual == tamanho:
            numero_seguinte = terminar_sequencia(numero_seguinte, unidade_comparada, ocorrencias)

    a.append(numero_seguinte)

print("Esse aqui")
print(len(a[30]))