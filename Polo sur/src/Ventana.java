
import java.awt.FlowLayout;
import java.io.IOException;
import javax.swing.JFrame;

public class Ventana extends JFrame {

    public Ventana(String titulo) throws IOException, ClassNotFoundException {
        super(titulo);

        this.setLayout(new FlowLayout());
        
        this.add(new Panel());

        this.setVisible(true);
        this.setSize(1000, 500);
    }
}
