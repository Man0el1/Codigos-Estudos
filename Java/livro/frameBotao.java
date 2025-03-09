
import java.awt.FlowLayout;
import javax.swing.*;
//import javax.swing.JFrame;
//import javax.swing.JButton; etc..

public class frameBotao extends JFrame{
    public frameBotao(){
        setTitle("Não clique no botão");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        add(new JButton("Panico!"));
        setSize(600, 600);
        setVisible(true);
    }
}
class mostrarFrame{
    public static void main(String args[]){
        new frameBotao();
    }
}