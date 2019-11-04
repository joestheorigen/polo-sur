import java.awt.Toolkit;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class detallesView extends JFrame{
    JList detalles = new JList();
    JScrollPane scroll = new JScrollPane();
    public detallesView(){
        super("detalles");
        
        this.getContentPane().add(scroll);
        
        scroll.setViewportView(detalles); 
        
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        this.setVisible(true);
    }
    public void crearLista(DefaultListModel<String> a){
        detalles.setModel(a);
    }
}
