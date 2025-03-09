function meuEscopo(){
    const form = document.querySelector('.form');
    const resultado = document.querySelector('.resultado');
    const pessoas = [];

    function recebeEventoForm(event){
        event.preventDefault(); // Evita que a página seja recarregada

        nome = form.querySelector('.nome');
        sobrenome = form.querySelector('.sobrenome');
        peso = form.querySelector('.peso');
        altura = form.querySelector('.altura');

        pessoas.push({
            nome: nome.value,
            sobrenome: sobrenome.value,
            peso: peso.value,
            altura: altura.value,
        });

        console.log(pessoas);
        resultado.innerHTML += `<p>${nome.value} ${sobrenome.value} ${peso.value} ${altura.value}</p>`
    }

    form.addEventListener('submit', recebeEventoForm);
}
meuEscopo();