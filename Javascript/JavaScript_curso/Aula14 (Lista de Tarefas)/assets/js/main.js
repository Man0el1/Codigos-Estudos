function main() {
    const inputTarefa = document.querySelector(".input-tarefa");
    const btnTarefa = document.querySelector(".btn-tarefa");
    const tarefas = document.querySelector(".tarefas");

    const criaElemento = (elemento) => document.createElement(`${elemento}`);

    const limpaInput = () => {
        inputTarefa.value = "";
        inputTarefa.focus();
    }

    const criaTarefa = (textoInput) => {
        const li = criaElemento('li');
        li.innerText = textoInput;
        li.innerText += " ";
        tarefas.appendChild(li);

        limpaInput();
        criaBotaoApagar(li);
        salvarTarefas();
    }

    const criaBotaoApagar = (li) => {
        const btn = criaElemento('button');
        btn.innerText = 'Apagar';
        btn.setAttribute('class', 'apagar');
        li.appendChild(btn);
    }

    const salvarTarefas = () => {
        const liTarefas = tarefas.querySelectorAll('li');
        let listaDeTarefas = [];

        for(let tarefa of liTarefas) {
            let tarefaTexto = tarefa.innerText;
            tarefaTexto = tarefaTexto.replace('Apagar','').trim();
            listaDeTarefas.push(tarefaTexto);
        }

        // Array => JSON salvo em localStorage no navegador
        const tarefasJSON = JSON.stringify(listaDeTarefas);
        localStorage.setItem('tarefas', tarefasJSON);

    }

    const adicionaTarefasSalvas = () => {
        // JSON => Array
        const tarefas = localStorage.getItem('tarefas');
        const listaDeTarefas = JSON.parse(tarefas);

        for(let tarefa of listaDeTarefas){
            criaTarefa(tarefa);
        }
    }

    inputTarefa.addEventListener('keypress', function (e) {
        if (e.keyCode === 13) {
            if (!inputTarefa.value) return;
            criaTarefa(inputTarefa.value);
        }
    })

    btnTarefa.addEventListener('click', function () {
        if (!inputTarefa.value) return;
        criaTarefa(inputTarefa.value);
    });

    document.addEventListener('click', function (e) {
        const el = e.target;
        if (el.classList.contains('apagar')) {
            el.parentElement.remove();
            salvarTarefas();
        }
    })

    adicionaTarefasSalvas();
}
main();