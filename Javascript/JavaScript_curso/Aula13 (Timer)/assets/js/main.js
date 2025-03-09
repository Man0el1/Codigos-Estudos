function modificarRelogio() {
    const relogio = document.querySelector('.relogio');
    const iniciar = document.querySelector('.iniciar');
    const pausar = document.querySelector('.pausar');
    const zerar = document.querySelector('.zerar');
    let segundos = 0;
    let timer;
    let ativo = false;

    function criarHorarioDosSegundos(segundos) {
        const data = new Date(segundos * 1000);
        return data.toLocaleTimeString('pt-BR', {
            hour12: false,
            timeZone: 'GMT'
        });
    };

    const pararTimer = () => { clearInterval(timer); ativo = false };

    const mudarCorPausa = () => relogio.classList.add('pausado');
    const mudarCorAtivo = () => relogio.classList.remove('pausado');

    iniciar.addEventListener('click', function (event) {
        if (!ativo) {
            timer = setInterval(() => {
                segundos++;
                relogio.innerHTML = criarHorarioDosSegundos(segundos);
            }, 1000)
            mudarCorAtivo();
            ativo = true
        }
    });

    pausar.addEventListener('click', function (event) {
        pararTimer();
        mudarCorPausa();
    });

    zerar.addEventListener('click', function (event) {
        pararTimer();
        segundos = 0;
        relogio.innerHTML = criarHorarioDosSegundos(segundos);
        mudarCorAtivo();
    });
}
modificarRelogio();