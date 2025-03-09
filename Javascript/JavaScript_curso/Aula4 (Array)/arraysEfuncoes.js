const alunos = ['Luiz','Maria','Joao']; 
// arrays são mutaveis independente do tipo de dado (primitivos como numbers, strings, etc.. não são)

alunos.push('Fabio'); // Adiciona um elemento no final do array
alunos.unshift('Lucas'); // Adiciona um elemento no inicio do array

console.log(alunos);

const removido = alunos.pop(); // Remove o último elemento do array
const removido2 = alunos.shift(); // Remove o primeiro elemento do array
delete alunos[1]; // Deleta o elemento sem alterar o indice

console.log(alunos);
console.log(typeof alunos);
console.log(alunos instanceof Array);

function saudacao(x){
    console.log(`Olá ${x}!`);
}
saudacao('Lucas');

//criando objeto
console.log('-------------------');
const pessoa = {
    nome: 'Lucas',
    sobrenome: 'Santos',
    idade: 19,
    
    fala(){
        console.log(`A minha idade atual é ${this.idade}`);
    },
};
console.log(pessoa.nome);
pessoa.fala();

function criaPessoa(nome, sobrenome, idade){
    return {
        nome: nome,
        sobrenome: sobrenome,
        idade: idade,
    }
}
const pessoa1 = criaPessoa('Enzo', 'Lyrio', 20);