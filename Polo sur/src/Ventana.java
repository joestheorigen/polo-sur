
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame implements ActionListener {

    JButton crear = new JButton("Crear nuevo polo");
    JButton pasarDia = new JButton("Pasar 1 dia");
    JButton pasar10Dias = new JButton("Pasar 10 dias");
    JButton detalles = new JButton("Detalles del dia actual");
    JButton calentar = new JButton("calentamiento global");
    JButton caza = new JButton("Caza furtiva");
    polo_Sur polo = null;

    public Ventana(String titulo) {
        super(titulo);

        this.setLayout(new FlowLayout());

        crear.addActionListener(this);
        pasarDia.addActionListener(this);
        pasar10Dias.addActionListener(this);
        detalles.addActionListener(this);
        calentar.addActionListener(this);
        caza.addActionListener(this);

        crear.setActionCommand("crear");
        pasarDia.setActionCommand("dia");
        pasar10Dias.setActionCommand("10 dias");
        detalles.setActionCommand("detalles");
        calentar.setActionCommand("calentar");
        caza.setActionCommand("cazar");

        this.add(crear);
        this.add(pasarDia);
        this.add(pasar10Dias);
        this.add(detalles);
        this.add(calentar);
        this.add(caza);

        this.setVisible(true);
        this.setSize(300, 150);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "crear":
                polo = new polo_Sur();
                JOptionPane.showMessageDialog(new JFrame(), "Polo sur creado con dia " + polo.dia);
                break;

            case "dia":
                if (polo != null) {
                    polo.diaAdia();
                    JOptionPane.showMessageDialog(new JFrame(), "dia " + polo.dia);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "10 dias":
                if (polo != null) {
                    polo.pasar10dias();
                    JOptionPane.showMessageDialog(new JFrame(), "dia " + polo.dia);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "detalles":
                if (polo != null) {
                    detallesView d = new detallesView();
                    DefaultListModel<String> m = new DefaultListModel<String>();
                    ArrayList<String> aux = new ArrayList<String>();
                    //POR IMPLEMENTAR EN polo_Sur (con meter en el array el to String de cada clase sobra)
                    //LOS METODOS DEVUELVEN EL toString DE CADA RAZA Y AÑADEN EN aux
                    //metodo donde se añaden peces(tipo raya)
                    //metodo donde se añaden peces(tipo bacalao)
                    //metodo donde se añaden peces(tipo no me acuerdo pero solo resta uno)
                    //metodo donde se añaden focas.
                    //metodo donde se añaden morsas.
                    //metodo donde se añaden osos.
                    //metodo donde se añaden esquimales.
                    aux.add("el dia es " + polo.dia);
                    for (String i : aux) {
                        m.addElement(i);
                    }
                    d.crearLista(m);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "cazar":
                if (polo != null) {
                    polo.cazaFurtiva();
                    JOptionPane.showMessageDialog(new JFrame(), "caza furtiva realizada ");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "calentar":
                if (polo != null) {
                    polo.calentamientoGlobal();
                    JOptionPane.showMessageDialog(new JFrame(), "Temperatura sube a "+polo.temperatura);
                    break;
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
        }
    }
}
