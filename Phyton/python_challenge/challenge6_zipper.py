import zipfile

def get_proximo_codigo(codigo, zip_file):
    file_path = f"C://Users//LENOVO//Desktop//channel//{codigo}.txt"
    
    with open(file_path, 'r') as f:
        texto = f.read()
        print(texto)
        
    comentario = zip_file.getinfo(f"{codigo}.txt").comment.decode('utf-8')
    todo_comentario.append(comentario)
    print(comentario)
            
    return mudar_codigo(texto)
    
def mudar_codigo(texto):
    novo_texto = ""
    for char in texto:
        if char.isdigit():
            novo_texto += char
    return novo_texto

nextNothing = "90052"
zip_path = "C://Users//LENOVO//Desktop//Lixo//channel.zip"
todo_comentario = []

with zipfile.ZipFile(zip_path, 'r') as zip_file:
    while nextNothing:
        nextNothing = get_proximo_codigo(nextNothing, zip_file)
                
print("".join(todo_comentario))