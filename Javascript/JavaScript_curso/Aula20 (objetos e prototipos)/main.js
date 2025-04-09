function Produto1(nome, preco, estoque) {
    this.nome = nome;
    this.preco = preco;
    let estoquePrivado = estoque;

    Object.defineProperty(this, 'estoque', { // Ou defineProperties()
        enumerable: true, // Mostra a chave (ex: objeto.keys aparece a chave)
        //value: estoque, // Valor (com set e gets n precisam de value e writable)
        //writable: false, // Pode alterar a propriedade
        configurable: false, // Pode alterar defineProperty ou deletar estoque de um objeto 
        get: function () {
            return estoquePrivado;
        },
        set: function (valor) {
            if (typeof valor !== 'number') {
                throw new TypeError('Bad Value');
            }
            estoquePrivado = valor
        },
    });

}

const p1 = new Produto1('Camisa', 20, 3);
console.log(p1.nome);
p1.estoque = 4;
console.log(p1.estoque);

// ---------- Prototipo -----------

function Pessoa(nome, sobrenome) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    //this.nomeCompleto = () => this.nome + ' Original ' + this.sobrenome;
}

Pessoa.prototype.estouAqui = function() {
    return this.nome + ' ' + this.sobrenome;
}

//instancia
const pessoa1 = new Pessoa('Luiz', 'O');
const data = new Date();

console.dir(pessoa1);
console.dir(data);

// ---------- Heranca -----------

function Produto(nome, preco) {
    this.nome = nome;
    this.preco = preco;
}
Produto.prototype.aumento = function(quantia) {
    this.preco += quantia;
};
Produto.prototype.desconto = function(quantia) {
    this.preco -= quantia;
};

function Camiseta(nome, preco, cor){
    this.cor = cor;
    Produto.call(this, nome, preco);
}
Camiseta.prototype = Object.create(Produto.prototype);
// Cada prototipo tem que ter seu proprio construtor, senão fica com o mesmo do pai (Produto)
// Se não colocar, o construtor da camiseta é o do Produto (herança)
Camiseta.prototype.constructor = Camiseta;

const regata = new Camiseta('regata', 7.5, 'Preta');
regata.aumento(20);
console.log(regata);
