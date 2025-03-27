// --- Splice (pode simular pop, shift, unshift...) ---

const nomes = ['Maria', 'João', 'Eduardo', 'Gabriel', 'Júlia'];

//nomes.splice(indice, delete, elem1, elem2, elem3..)
const removidos = nomes.splice(-3, 2);
console.log(nomes, removidos);

nomes.splice(1, 0, 'Luiz');
console.log(nomes);

// --- Concat (concatendando arrays) ---

const a1 = [1, 2, 3];
const a2 = [4, 5, 6];
//a3 = a1 + a2 --> [1,2,34,5,6]
const a3 = a1.concat(a2, [7, 8, 9], 'Luiz')
console.log(a3)

// --- Filter --- (filtra os elementos do Array)

const numeros = [5, 50, 80, 1, 2, 3, 5, 8, 7, 11, 15, 22, 27];
//filter(valor, indice, array)
const numerosFiltrados = numeros.filter((valor) => valor > 10);

console.log(numerosFiltrados)

// --- Map --- (modifica os elementos do Array)

//map(valor, indice, array)
const numerosVezes2 = numeros.map((valor) => valor * 2);

console.log(numerosVezes2);

// --- Reduce --- (reduz o array a um resultado de uma operação matemática)

//reduce(acumulador, valor, indice, array)
const total = numeros.reduce(function(acumulador, valor){
    acumulador += valor;
    console.log(acumulador, valor);
    return acumulador ;
}, 0); //<-- valor inicial do acumulador, se vazio, acumulador pega indice 0 e valor pega indice 1
console.log(total);

// --- Final ---

const numerosPares = numeros.filter((valor) => valor % 2 == 0);
const numerosDobrados = numerosPares.map((valor) => valor * 2);
const numeroFinal = numerosDobrados.reduce(function(acumulador, valor){
    acumulador += valor;
    return acumulador;
});
console.log(`Resultado final: ${numeroFinal}`)