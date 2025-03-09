function mostrarData() {

    const data = new Date();
    const ano = data.getFullYear();
    const mes = pegarMes();
    const dia = data.getDate();
    const diaSemana = pegarDia();
    const hora = pegarHora();
    const minuto = pegarMinuto();

    const div = document.querySelector('#data');
    const headline = document.createElement('h1');
    headline.innerHTML =`${diaSemana}, ${dia} de ${mes} de ${ano} ${hora}:${minuto}`;
    div.appendChild(headline);

    function pegarMes() {
        const mes = data.getMonth();
        const meses = ['Janeiro', 'Fevereiro', 'Março', 'Abril', 'Maio', 'Junho', 'Julho',
            'Agosto', 'Setembro', 'Outubro', 'Novembro', 'Dezembro'];
        return meses[mes];
    
    }
    
    function pegarDia() {
        const dia = data.getDay();
        const dias = ['Domingo', 'Segunda-Feira', 'Terça-Feira', 'Quarta-Feira',
            'Quinta-Feira', 'Sexta-Feira', 'Sábado-Feira'];
        return dias[dia];
    }
    
    function pegarHora() {
        return data.getHours() >= 10 ? data.getHours() : `0${data.getHours()}`;
    }
    function pegarMinuto() {
        return data.getMinutes() >= 10 ? data.getMinutes() : `0${data.getMinutes()}`;
    }
}

mostrarData();