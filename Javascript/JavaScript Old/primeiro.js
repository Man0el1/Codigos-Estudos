//"node primeiro.js" no novo terminal para funcionar
var roupa = "Camiseta";
roupa = "moletom";
console.log(roupa);

var nome = 'Link';
var idade = 21;

if (nome === 'Luigi' || idade < 21) {
  console.log('Olá, mundo!');
} else if (nome !== 'Link' && idade === 22 ) {
  console.log('Eu sou o Link!');
} else if (nome === 'Luigi' || idade !== 21) {
  console.log('Olá, mundo! Eu sou o Link!');
} else if (nome === 'Link' && idade === '21' ) {
  console.log("Hello, world! I'm Link!");
} else if (nome === 'Link' && idade === 21 ) {
  console.log('Eu sou o Link e tenho 21 anos!');
}
