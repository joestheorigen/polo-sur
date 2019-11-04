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
    JButton salir = new JButton("Salir de la aplicacion");
    polo_Sur polo;

    public Ventana(String titulo) {
        super(titulo);

        this.setLayout(new FlowLayout());

        crear.addActionListener(this);
        pasarDia.addActionListener(this);
        pasar10Dias.addActionListener(this);
        detalles.addActionListener(this);
        calentar.addActionListener(this);
        caza.addActionListener(this);
        salir.addActionListener(this);

        crear.setActionCommand("crear");
        pasarDia.setActionCommand("dia");
        pasar10Dias.setActionCommand("10 dias");
        detalles.setActionCommand("detalles");
        calentar.setActionCommand("calentar");
        caza.setActionCommand("cazar");
        salir.setActionCommand("salir");

        this.add(crear);
        this.add(pasarDia);
        this.add(pasar10Dias);
        this.add(detalles);
        this.add(calentar);
        this.add(caza);
        this.add(salir);

        this.setVisible(true);
        this.setSize(300, 175);
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
                    if(!polo.diaAdia()){
                        JOptionPane.showMessageDialog(new JFrame(), "dia " + polo.dia);
                    }else{
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "10 dias":
                if (polo != null) {
                    if(!polo.pasar10dias()){
                        JOptionPane.showMessageDialog(new JFrame(), "dia " + polo.dia);
                    }else{
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "detalles":
                if (polo != null) {
                    detallesView d = new detallesView();
                    DefaultListModel<String> m = new DefaultListModel<String>();
                    ArrayList<String> aux = new ArrayList<String>();

                    aux.add(" ");
                    aux.add("El dia es: " + polo.dia);
                    aux.add(" ");
                    aux.add("La temperatura es: "+polo.temperatura+" grados.");
                    aux.add(" ");
                    aux.add("El numero de kyp es: "+polo.contarKYP());
                    aux.add(" ");
                    aux.add("Raza Esquimal: " + polo.contarRaza("esquimal"));
                    aux.addAll(polo.toString("esquimal"));
                    aux.add(" ");
                    aux.add("Raza Oso: " + polo.contarRaza("oso"));
                    aux.addAll(polo.toString("oso"));
                    aux.add(" ");
                    aux.add("Raza Morsa: " + polo.contarRaza("morsa"));
                    aux.addAll(polo.toString("morsa"));
                    aux.add(" ");
                    aux.add("Raza Foca: " + polo.contarRaza("foca"));
                    aux.addAll(polo.toString("foca"));
                    aux.add(" ");
                    aux.add("Raza pez con: " + (polo.contarRaza("bacalao") + polo.contarRaza("bacalao")
                            + polo.contarRaza("bacalao")) + " peces. Luego hay 3 tipos que son:");
                    aux.add(" ");
                    aux.add("Raza Bacalao: " + polo.contarRaza("bacalao"));
                    aux.addAll(polo.toString("bacalao"));
                    aux.add(" ");
                    aux.add("Raza Raya: " + polo.contarRaza("raya"));
                    aux.addAll(polo.toString("raya"));
                    aux.add(" ");
                    aux.add("Raza meluza negra: " + polo.contarRaza("merluza negra"));
                    aux.addAll(polo.toString("merluza negra"));

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
                    JOptionPane.showMessageDialog(new JFrame(), "Temperatura sube a " + polo.temperatura);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;
            case "salir":
                System.exit(0);
                break;
        }
    }
}
