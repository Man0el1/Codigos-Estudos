import static java.lang.System.*;

import java.util.Scanner;

public class javaOOatualizado {

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
            return this.saldo;
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

        public void setNome(String nome) {
            this.nome = nome;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public void setProfissao(String profissao) {
            this.profissao = profissao;
        }

        public String getProfissao() {
            return profissao;
        }
    }

    public static void main(String args[]) {
        Scanner teclado = new Scanner(in);
        conta primeiraConta = new conta(1337, 24226);
        cliente primeiroCliente = new cliente("Manoel", "222.222.222-22", "progamador");
        conta segundaConta = new conta(1933, 42126);
        cliente segundoCliente = new cliente("Enzo", "111.111.111-11", "cringe");
        segundaConta.saldo = 50;
        // primeirocliente.nome = "Manoel";
        // primeirocliente.cpf = "222.222.222.22"; //Não é necessario com um construtor
        // primeirocliente.profissao = "cozinheiro";
        primeiraConta.titular = primeiroCliente; // *titular da conta primeira* é associado ao *cliente um*
        segundaConta.titular = segundoCliente;
        conta contaAtual = primeiraConta;
        contaAtual.titular = primeiroCliente;
        boolean continuar = true;
        out.println();
        out.println("==========================");
        out.println("Sabstansdeur itaiu bdb");
        out.println("==========================");
        out.println();
        while (continuar) {
            out.println();
            out.println("Bem vindo " + contaAtual.titular.nome);
            out.println("1. Deposito");
            out.println("2. Saque");
            out.println("3. Transferencia");
            out.println("4. Verificar conta");
            out.println("5. Mudar informacao da conta");
            out.println("6. Mudar conta");
            out.println("7. Sair");
            out.print("Escolha a funcao: ");
            int num = teclado.nextInt();
            switch (num) {
                case 1: // deposito
                    out.print("Quantia para depositar: R$");
                    int dep = teclado.nextInt();
                    contaAtual.deposita(dep);
                    out.println("R$" + dep + " depositados!");
                    break;

                case 2: // saque
                    out.print("Quantia para sacar: R$");
                    int saq = teclado.nextInt();
                    boolean conseguiuRetirar = contaAtual.saque(saq);
                    if (conseguiuRetirar) {
                        out.println("R$" + saq + " sacados!");
                        break;
                    }
                    out.println("Erro: quantia insuficiente");
                    break;

                case 3: // transferencia
                    break;

                case 4: // verificar conteudo da conta
                    out.println("Saldo: " + contaAtual.saldo);
                    out.println("Agencia: " + contaAtual.agencia);
                    out.println("Numero: " + contaAtual.numero);
                    out.println("Nome: " + contaAtual.titular.nome);
                    out.println("Cpf: " + contaAtual.titular.cpf);
                    out.println("Profissao: " + contaAtual.titular.profissao);
                    break;

                case 5: // mudança de informação
                    out.println("O que deseja modificar?");
                    out.println("1. Nome");
                    out.println("2. Profissao");
                    out.println("3. Voltar");
                    out.print("Escolha a funcao: ");
                    int info = teclado.nextInt();
                    switch (info) {
                        case 1:
                            out.println("Qual o seu nome?: ");
                            String mud = teclado.nextLine();
                            contaAtual.titular.setNome(mud);
                            out.println("Modificado!");
                            break;
                        case 2:
                            out.println("Qual a sua profissao: ");
                            mud = teclado.nextLine();
                            contaAtual.titular.setProfissao(mud);
                            out.println("Modificado!");
                            break;
                        case 3:
                            break;
                        default:
                            out.println("Numero invalido, voltando...");
                            break;
                    }
                    break;

                case 6: // mudar conta
                    out.println();
                    out.println("Mudando de conta...");
                    if (contaAtual == primeiraConta) {
                        contaAtual = segundaConta;
                        contaAtual.titular = segundoCliente;
                    } else {
                        contaAtual = primeiraConta;
                        contaAtual.titular = primeiroCliente;
                    }
                    break;

                case 7: // sair
                    out.println();
                    out.println("Ate mais!");
                    continuar = false;
                    teclado.close();
                    break;

                default: // erro
                    out.println("Por favor insira um numero valido");
                    break;
            }
        }
    }
}