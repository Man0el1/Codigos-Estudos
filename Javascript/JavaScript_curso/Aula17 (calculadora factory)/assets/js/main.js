function criaCalculadora () {
    return {
        display: document.querySelector(".display"),

        inicia() {
            //this -> calculadora
            //this é necessario para chamar funções dentro do objeto calculadora
            this.cliqueBotoes();
            this.pressionaEnter();
        },

        clearDisplay() {
            this.display.value = '';
        },

        apagaCaractere(){
            this.display.value = this.display.value.slice(0, -1);
        },
        
        calcularConta(){
            let conta = this.display.value;
            try {
                conta = eval(conta);
                if(!conta){
                    alert("Conta Invalida");
                    return;
                }
                this.display.value = conta;
            } catch (e) {
                alert("Conta Invalida");
                return;
            }
        },

        cliqueBotoes(){
            document.addEventListener("click", function(e) {
                const botao = e.target;

                if(botao.classList.contains('btn-num')){
                    this.btnParaDisplay(botao.innerText);
                }
                
                if(botao.classList.contains("btn-clear")){
                    this.clearDisplay();
                }

                if(botao.classList.contains("btn-del")){
                    this.apagaCaractere();
                }

                if(botao.classList.contains("btn-eq")){
                    this.calcularConta();
                }

            }.bind(this));
            //arrow function não precisa de bind
        },

        pressionaEnter(){
            this.display.addEventListener('keyup', e => {
                if (e.keyCode === 13){
                    this.calcularConta();
                }
            });
        },

        btnParaDisplay(valor) {
            //this tambem é utilizado para chamar atributos
            this.display.value += valor;
        }

    };
}

const calculadora = criaCalculadora();
calculadora.inicia();