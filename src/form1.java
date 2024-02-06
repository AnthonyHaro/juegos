import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class form1 {
    private JTextField nombretext;
    private JTextField generotext;
    private JTextField preciotext;
    private JTextField tipotxt;
    private JButton insertarButton;
    private JButton borrarButton;
    JPanel play;

    public form1() {
        insertarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Videojuegos videojuego= new Videojuegos();
                String nombre=nombretext.getText();
                String tipo=tipotxt.getText();
                String genero=generotext.getText();
                videojuego.ingresar(nombre,genero,Double.parseDouble(preciotext.getText()),tipo);
            }
        });
        borrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombretext.setText("");
                generotext.setText("");
                preciotext.setText("");
                tipotxt.setText("");
            }
        });
    }
}
