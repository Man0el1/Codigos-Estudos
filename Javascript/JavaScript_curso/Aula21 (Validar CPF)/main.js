// 705.484.450-52 070.987.720-03
/*
7x  0x 5x 4x 8x 4x 4x 5x 0x
10  9  8  7  6  5  4  3  2
70  0  40 28 48 20 16 15 0 = 237

11 - (237 % 11) = 5 (Primeiro dígito)
Se o número digito for maior que 9, consideramos 0.

7x  0x 5x 4x 8x 4x 4x 5x 0x 5x
11 10  9  8  7  6  5  4  3  2
77  0  45 32 56 24 20 20 0  10 = 284

11 - (284 % 11) = 2 (Primeiro dígito)
Se o número digito for maior que 9, consideramos 0.
*/

function Cpf(cpfEnv) {
    this.cpfOriginal = cpfEnv;

    Object.defineProperty(this, 'cpfLimpo', {
        enumerable: true,
        get: function () {
            return cpfEnv.replace(/\D+/g, '');
        }
    });
}

Cpf.prototype.validarCpf = function () {
    if (this.cpfLimpo.length !== 11 || typeof this.cpfLimpo === 'undefined') return false;

    const cpfParcial = Array.from(this.cpfLimpo).slice(0, -2);
    const cpfDigitos = Array.from(this.cpfLimpo).slice(-2);

    const primeiroDigito = this.validarDigito(cpfParcial.map(Number), Number(cpfDigitos[0]));
    if (!primeiroDigito) return false;

    cpfParcial.push(cpfDigitos[0]);
    const segundoDigito = this.validarDigito(cpfParcial.map(Number), Number(cpfDigitos[1]));
    if (!segundoDigito) return false;
    return true;
}

Cpf.prototype.validarDigito = function (cpfParcial, digito) {
    const regressor = cpfParcial.length + 1;
    const numTotal = this.somarParcial(cpfParcial, regressor);

    let digitoCalculado = 11 - (numTotal % 11);
    if (digitoCalculado > 9) digitoCalculado = 0;

    return digitoCalculado === digito;
}

Cpf.prototype.somarParcial = function (cpfParcial, regressor) {
    let cpfMultiplicado = [];

    for (let num of cpfParcial) {
        cpfMultiplicado.push(num * regressor--);
    }
    return cpfMultiplicado.reduce(function (acumulador, valor) {
        return acumulador + valor;
    }, 0);
}

const cpf1 = new Cpf("705.484.450-52");
console.log(`O CPF ${cpf1.cpfOriginal} é ${cpf1.validarCpf() ? 'valido' : 'invalido'}`);