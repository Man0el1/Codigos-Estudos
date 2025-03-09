import static java.lang.System.*;

public class javaOO {

    static class conta {
        private double saldo; // apenas pode modificado ou lido na propria classe, permitindo que o unico
                              // jeito de modificar-lo é com metodos saque, etc..
        private int agencia; // porem não pode ler coisas como out.print(primeiraConta.saldo), pra isso que
                             // entra o get e set (primeiraConta.getSaldo())
        private int numero;
        private cliente titular;
        private static int total; // static, total de contas é um atributo da classe e não uma conta em sí

        public conta(int agencia, int numero) { // construtor, java sempre constroi secretamente, pode determinar
                                                // atributos para o proprio class facilmente
            this.agencia = agencia;
            this.numero = numero;
            System.out.println("estou criando uma conta de numero " + this.numero);
            conta.total++;
        }

        // ********************************//
        void deposita(double valor) {
            this.saldo += valor;
        }

        public boolean saque(double valor) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                return true;
            } else {
                return false;
            }
        }

        public boolean transfere(double valor, conta destino) {
            if (this.saldo >= valor) {
                this.saldo -= valor;
                destino.deposita(valor);
                return true;
            } else {
                return false;
            }
        }

        // ********************************// ctrl+espaço facilita. ex: digitei setAgen
        // e ctrl+espaço ja fez inteiro
        public double getSaldo() {
            return this.numero;
        }

        public void setAgencia(int agencia) {
            this.agencia = agencia;
        }

        public int getAgencia() {
            return agencia;
        }

        public void setNumero(int numero) {
            if (numero > 0) {
                this.numero = numero;
            } else {
                out.println("(Erro: Numero da conta não pode ser 0 ou negativo)");
                return;
            }
        }

        public int getNumero() {
            return this.numero;
        }

        public void setTitular(cliente titular) {
            this.titular = titular;
        }

        public cliente getTitular() {
            return this.titular;
        }

        public static int getTotal() {
            return conta.total;
        }

    }

    public static class cliente {
        private String nome;
        private String cpf;
        private String profissao;

        public cliente(String nome, String cpf, String profissao) {
            this.nome = nome;
            this.cpf = cpf;
            this.profissao = profissao;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public String getProfissao() {
            return profissao;
        }

        public void setProfissao(String profissao) {
            this.profissao = profissao;
        }
    }

    public static void main(String args[]) {
        conta primeiraConta = new conta(1337, 24226);
        cliente primeirocliente = new cliente("Manoel", "222.222.222.222", "cozinheiro");
        // primeirocliente.nome = "Manoel";
        // primeirocliente.cpf = "222.222.222.22"; //Não é necessario com um construtor
        // primeirocliente.profissao = "cozinheiro";
        primeiraConta.titular = primeirocliente; // conta e cliente, cliente um é definido e depois o *titular da conta
                                                 // primeira* é associado ao *cliente um*

        out.println();
        out.println("==========================");
        out.println("Conta tem classe titular dentro");
        out.println("==========================");
        out.println();
        out.println(primeiraConta.titular.nome);
        out.println(primeiraConta.titular);

        out.println();
        out.println("==========================");
        out.println("mudança de titular com metodos conjuntos");
        out.println("==========================");
        out.println();
        out.println(primeiraConta.getTitular().getNome());
        primeiraConta.getTitular().setProfissao("programador"); // gettitular pega o nome do titular pra ser utilizado
                                                                // no codigo adentro
        out.println(primeiraConta.getTitular().getProfissao());

        conta segundaConta = new conta(1933, 42126);
        segundaConta.saldo = 50;
        segundaConta.deposita(50);

        primeiraConta.saldo = 300;
        boolean conseguiuRetirar = primeiraConta.saque(240);
        out.println();
        out.println("==========================");
        out.println("saque e retirada das contas");
        out.println("==========================");
        out.println();
        if (conseguiuRetirar) {
            out.println("Primeira conta tem " + primeiraConta.saldo);
        } else {
            out.println("não foi possivel o saque da conta por falta de saldo");
        }
        out.println("Segunda conta tem " + segundaConta.saldo);
        out.println();
        out.println("==========================");
        out.println("transferencia de 50 reais");
        out.println("==========================");
        out.println();
        primeiraConta.transfere(50, segundaConta);
        out.println("Primeira conta tem " + primeiraConta.saldo);
        out.println("Segunda conta tem " + segundaConta.saldo);
    }
}