
import javax.swing.JOptionPane;
class Main{
    public static void main(String args[]){
        String usuário;
        int senha;
        do{
            usuário = JOptionPane.showInputDialog("Insira o nome do usuário");
        }while (usuário.isEmpty());
        do{
            senha = Integer.parseInt(JOptionPane.showInputDialog("Insira a senha"));
        }while (senha == 0);
        if ((usuário.equals("Manoel") && senha == 123456) || usuário.equals("Izbel") && senha == 654321){
            JOptionPane.showMessageDialog(null, "Bem vindo " + usuário);
        }else{
            JOptionPane.showMessageDialog(null, "Acesso negado");
        }
    }
}