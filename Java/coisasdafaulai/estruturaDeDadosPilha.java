import java.util.Scanner;
import java.util.Stack;

class Contatos {
    String nome;
    String telefone;

    public Contatos(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

}

public class estruturaDeDadosPilha {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Contatos> stackContatos = new Stack<>();
        int escolha;

        do {
            System.out.println("Teste de Pilha");
            System.out.println("Tamanho atual: " + stackContatos.size() + "\n");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Tirar contato");
            System.out.println("3. Checar contato no topo");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            escolha = sc.nextInt();
            sc.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String scNum = sc.nextLine();
                    if (scNum.length() > 50) {
                        System.out.println("Erro: Nome longo demais");
                        break;
                    }

                    System.out.print("Digite o telefone do contato: ");
                    String scTel = sc.nextLine();
                    if (scTel.length() > 20) {
                        System.out.println("Erro: Telefone longo demais");
                        break;
                    }

                    stackContatos.push(new Contatos(scNum, scTel));
                    System.out.println("Contato adicionado com sucesso!\n");
                    break;

                case 2:
                    if (!stackContatos.isEmpty()) {
                        System.out.println("Contato removido: " + stackContatos.pop() + "\n");
                    } else {
                        System.out.println("A pilha está vazia, não há contato para remover.\n");
                    }
                    break;

                case 3:
                    if (!stackContatos.isEmpty()) {
                        System.out.println("Contato no topo: " + stackContatos.peek() + "\n");
                    } else {
                        System.out.println("A pilha está vazia, não há contato no topo.\n");
                    }
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Número inválido\n");
            }
        } while (escolha != 4);

        sc.close();
    }
}
