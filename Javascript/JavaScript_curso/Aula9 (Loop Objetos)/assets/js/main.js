function inserirTextos() {

    const elementos = [
        { tag: 'p', texto: 'Frase 1' },
        { tag: 'div', texto: 'Frase 2' },
        { tag: 'footer', texto: 'Frase 3' },
        { tag: 'section', texto: 'Frase 4' }
    ];
    const container = document.querySelector('.container');
    const div = document.createElement('div');
    container.appendChild(div);

    //for(let i in elementos){
    //    let {tag, texto} = elementos[i];   i = 0, 1, 2, 3

    for(let i of elementos){ 
        let {tag, texto} = i;   // i = { tag: 'p', texto: 'Frase 1' }
        let tagCriada = document.createElement(tag); 
        tagCriada.innerText = texto;
        div.appendChild(tagCriada);
    }
}
inserirTextos();