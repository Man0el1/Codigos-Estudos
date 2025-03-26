//Factory function
function criaPessoa(nome, sobrenome, altura, peso){
    return {
        nome,
        sobrenome,
        fala: function(assunto) {
            return `${this.nome} ${this.sobrenome} esta ${assunto}`;
        },
        altura,
        peso,
        imc() {
            const indice = this.peso / (this.altura ** 2);
            return indice.toFixed(2);
        }
    }
}

const p1 = criaPessoa('Luiz', 'Otavio', 1.7, 80);
const p2 = criaPessoa('Maria', 'Joaquina', 1.6, 46);
console.log(p2.fala("Falando sobre JavaScript"));
//console.log(p2.imc())

//Constructor function
function criaPessoa(nome, sobrenome, altura, peso){
    return {
        nome,
        sobrenome,

        get nomeCompleto() {
            return`${this.nome} ${this.sobrenome}`
        },

        set nomeCompleto(valor) {
            valor = valor.split(' ');
            this.nome = valor.shift();
            this.sobrenome = valor.join(' ');
            
        },

        fala: function(assunto = "fazendo nada") {
            return `${nomeCompleto} esta ${assunto}`;
        },

        altura,
        peso,

        get imc() { //imc metodo -> getter
            const indice = this.peso / (this.altura ** 2);
            return indice.toFixed(2);
        }
    }
}

p1 = criaPessoa('Luiz', 'Otavio', 1.7, 80);
p1.nomeCompleto = "Maria Oliveira Silva";
console.log(p1.nomeCompleto);
console.log(p1.imc); //imc() -> imc || p1.imc = 49 não funciona
console.log(p1.fala);