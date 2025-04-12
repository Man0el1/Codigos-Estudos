class Pessoa {
    constructor(nome, sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }
    // Nao e necessario prototipos para o metodo, pois o JS ja faz isso automaticamente
    falar = () => console.log(`${this.nome} esta falando`);
}

const p1 = new Pessoa('Luiz', 'Miranda');

//--------------------------

const _velocidade = Symbol('velocidade')
class Carro {
    constructor(nome){
        this.nome = nome;
        this[_velocidade] = 0;
    }

    set velocidade(valor){
        if(typeof valor !== 'number') return;
        if(valor >= 100 || valor <= 0) return;
        this[_velocidade] = valor;
    }

    get velocidade(){
        return this[_velocidade];
    }

    acelerar = () => {
        if (this[_velocidade] >= 100) return;
        this[_velocidade]++;
    }

    parar = () => {
        if (this[_velocidade] <= 0) return;
        this[_velocidade]--;
    }
    
}

const c1 = new Carro('Fusca');

c1.velocidade = 85
c1.velocidade = 120
console.log(c1.velocidade)

//--------------------------

class DispositivoEletronico {
    constructor(nome){
        this.nome = nome;
        this.ligado = false;
    }

    ligar = () => {
        if(this.ligado) return;
        this.ligado = true;
    }

    desligar = () => {
        if(!this.ligado) return;
        this.ligado = false;
    }

}

class Smartphone extends DispositivoEletronico {
    constructor(nome, cor){
        super(nome);
        this.cor = cor;
    }
}

const s1 = new Smartphone('Iphone', 'Preto');
s1.ligar();
console.log(s1);