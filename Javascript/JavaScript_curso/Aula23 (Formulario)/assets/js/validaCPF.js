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