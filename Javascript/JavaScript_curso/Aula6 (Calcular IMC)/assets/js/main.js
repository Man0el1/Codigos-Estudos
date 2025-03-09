function calcularIMC() {
    const form = document.querySelector('.form');
    const tabelaIMC = ['Abaixo do peso', 'Peso normal', 'Sobrepeso', 'Obesidade grau I',
        'Obesidade grau II', 'Obesidade grau III'];
    let imc;
    let classificacao;

    function recebeEventoForm(event) {
        event.preventDefault();

        const peso = Number(form.querySelector('#input-peso').value);
        const altura = Number(form.querySelector('#input-altura').value);

        if (!peso || !altura || peso < 0 || altura < 0) {
            respostaValida = false;
            setResultado('Invalido! Insira números válidos.', false);
        } else {
            imc = peso / (altura ** 2);
            respostaValida = true;
            classificacao = classificarIMC(imc);
            setResultado(`Seu IMC é ${imc.toFixed(2)} (${classificacao})`, true);
        }
    }

    function classificarIMC(imc) {
        if (imc < 18.5) return tabelaIMC[0];
        if (imc >= 18.5 && imc < 25) return tabelaIMC[1];
        if (imc >= 25 && imc < 30) return tabelaIMC[2];
        if (imc >= 30 && imc < 35) return tabelaIMC[3];
        if (imc >= 35 && imc < 40) return tabelaIMC[4];
        if (imc >= 40) return tabelaIMC[5];
        return 'Erro!';
    }

    function criaParagrafo() {
        const paragrafo = document.createElement('p');
        return paragrafo;
    }

    function setResultado(msg, respostaValida) {
        const resultado = document.querySelector('#resultado');
        resultado.innerHTML = '';
        const p = criaParagrafo();
        p.classList.add('paragrafo-resultado');
        p.innerHTML = msg;

        if (!respostaValida) {
            p.style.backgroundColor = "rgb(221, 119, 112)";
        }

        resultado.appendChild(p);
    }

    form.addEventListener('submit', recebeEventoForm);
}
calcularIMC();