const pontuacaoUsuario = 1001;
const nivelUsuario = pontuacaoUsuario >= 1000 ? 'VIP' : 'Normal'; 
console.log(nivelUsuario);

const corUsuario = null;
const corPadrao = corUsuario || 'Preta'; // Se a cor do usuário for nula, a cor padrão será preta

const data = new Date(1999, 3, 20, 15, 14, 27, 123); // Ano, mês, dia, hora, minuto, segundo e milissegundo
data = new Date('1999-04-20 15:14:27'); // Ano, mês, dia, hora, minuto, segundo
//new Date() = data atual

const ano = data.getFullYear();
const dia = data.getDate(); 