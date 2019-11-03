import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

public class detallesView extends JFrame{
    JList detalles = new JList();
    public detallesView(){
        super("detalles");
    }
    public void crearLista(DefaultListModel<String> a){
        detalles.setModel(a);
    }
}
