function main() {
    opcoes = document.querySelector(".opcoesDados");
    conta = document.querySelector(".conta");
    resultado = document.querySelector(".resultadoFinal");
    lados = [4, 6, 8, 10, 12, 20, 100];

    const criarDados = () => {
        for (let lado of lados) {
            const div = document.createElement('div');

            for (let i = 1; i <= 5; i++) {
                const btn = document.createElement('button');
                btn.id = `${i}d${lado}`;
                
                btn.addEventListener('click', function(){
                    calcularResultado(String(btn.id));
                });

                if (i === 1) {
                    btn.innerHTML = `d${lado}`;
                } else {
                    btn.innerHTML = `${i}`;
                }

                div.appendChild(btn);
            }
            opcoes.appendChild(div);
        }
    }

    const calcularResultado = (id) => {
        let total = 0;
        idArray = id.split("d");
        console.log(idArray)
        numDeDados = Number(idArray[0]);
        tipoDeDado = Number(idArray[1]);
        console.log(tipoDeDado);
        conta.innerHTML = ""

        for(let i = 1; i <= numDeDados; i++){
            num = Math.floor(Math.random() * tipoDeDado) + 1;
            total += num;
            conta.innerHTML += `${num}`
            if (i !== numDeDados){
                conta.innerHTML += " + ";
            } else {
                conta.innerHTML += " =";
            }
        }

        resultado.innerHTML = total;
    }

    criarDados();
}
main();