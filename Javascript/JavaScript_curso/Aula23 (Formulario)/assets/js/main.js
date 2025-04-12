class ValidaFormulario {
    constructor() {
        this.formulario = document.querySelector('.formulario');
        this.eventos();
    }

    eventos() {
        this.formulario.addEventListener('submit', event => {
            this.handleSubmit(event);
        });
    }

    handleSubmit(event) {
        event.preventDefault();
        const camposValidos = this.camposSaoValidos();
        const senhasValidas = this.senhasSaoValidas();

        if (camposValidos && senhasValidas) {
            alert('Formulario enviado!');
            this.formulario.submit();
        }
    }

    camposSaoValidos() {
        let valid = true;

        for (let errorText of this.formulario.querySelectorAll('.error-text')) {
            errorText.remove();
        }

        for (let campo of this.formulario.querySelectorAll('.validar')) {
            let label = campo.previousElementSibling.innerText;

            // Criar erro para valores nulos
            if (!campo.value) {
                this.criaErro(campo, `Campo "${label}" não pode estar em branco.`)
                valid = false
            }

            if (campo.classList.contains('cpf')) {
                if (!this.validaCPF(campo)) valid = false;
            }

            if (campo.classList.contains('usuario')) {
                if (!this.validaUsuario(campo)) valid = false;
            }
        }
        return valid;
    }

    senhasSaoValidas(){
        let valid = true;

        const senha = this.formulario.querySelector('.senha');
        const repetirSenha = this.formulario.querySelector('.repetir-senha');

        if (senha.value !== repetirSenha.value) {
            this.criaErro(repetirSenha, 'Senha e Repetir senha precisam ser iguais');
            valid = false;
        }

        if (senha.value.length < 6 || senha.value.length > 12) {
            this.criaErro(senha, 'Senha deve ter entre 6 a 12 caracteres');
            valid = false;
        }
        return valid;
    }

    validaCPF(campo) {
        const cpf = new Cpf(campo.value);

        if (!cpf.validarCpf()) {
            this.criaErro(campo, 'CPF Invalido.');
            return false;
        }
        return true;
    }

    validaUsuario(campo) {
        const usuario = campo.value;
        let value = true;

        if (!usuario.match(/^[A-Za-z0-9]*$/)) {
            this.criaErro(campo, 'Proibido uso de caracteres especiais');
            value = false;
        }

        if (usuario.length < 3 || usuario.length > 12) {
            this.criaErro(campo, 'Usuario deve ter entre 3 a 12 caracteres');
            value = false;
        }

        return value;
    }

    criaErro(campo, msg) {
        const div = document.createElement('div');
        div.classList.add('error-text');
        div.innerHTML = msg;
        campo.insertAdjacentElement('afterend', div);
    }
}

const valida = new ValidaFormulario();