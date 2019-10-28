
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joest
 */
public class detallesView extends JFrame{
    JList detalles = new JList();
    public detallesView(){
        super("detalles");
    }
    public void crearLista(DefaultListModel<String> a){
        detalles.setModel(a);
    }
}
