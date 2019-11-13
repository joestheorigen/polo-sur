
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Panel extends JPanel implements ActionListener {

    JButton crear = new JButton(new ImageIcon("Imagenes/crearpolo.png"));
    JButton pasarDia = new JButton(new ImageIcon("Imagenes/pasardia.png"));
    JButton pasar10Dias = new JButton(new ImageIcon("Imagenes/pasar10dias.png"));
    JButton detalles = new JButton(new ImageIcon("Imagenes/detalles.png"));
    JButton calentar = new JButton(new ImageIcon("Imagenes/calentar.png"));
    JButton caza = new JButton(new ImageIcon("Imagenes/caza.png"));
    JButton terremoto = new JButton(new ImageIcon("Imagenes/terremoto.png"));
    JButton guerra = new JButton(new ImageIcon("Imagenes/guerra.png"));
    JButton salir = new JButton(new ImageIcon("Imagenes/puerta.png"));
    polo_Sur polo = new polo_Sur();

    public Panel() throws IOException, ClassNotFoundException {

        this.setLayout(new GridLayout(4, 3));

        cargarDatos();

        crear.addActionListener(this);
        pasarDia.addActionListener(this);
        pasar10Dias.addActionListener(this);
        detalles.addActionListener(this);
        calentar.addActionListener(this);
        caza.addActionListener(this);
        terremoto.addActionListener(this);
        guerra.addActionListener(this);
        salir.addActionListener(this);

        crear.setActionCommand("crear");
        pasarDia.setActionCommand("dia");
        pasar10Dias.setActionCommand("10 dias");
        detalles.setActionCommand("detalles");
        calentar.setActionCommand("calentar");
        caza.setActionCommand("cazar");
        terremoto.setActionCommand("terremoto");
        guerra.setActionCommand("guerra");
        salir.setActionCommand("salir");

        this.add(crear);
        this.add(pasarDia);
        this.add(pasar10Dias);
        this.add(detalles);
        this.add(calentar);
        this.add(caza);
        this.add(terremoto);
        this.add(guerra);
        this.add(salir);

        this.setVisible(true);
        this.setSize(1000, 200);
    }

    public void cargarDatos() throws FileNotFoundException, IOException, ClassNotFoundException {
        try {
            lista l = new lista(polo);
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream("Polo.bin"));
            l = (lista) entrada.readObject();
            entrada.close();
            polo.animales = l.animales;
            polo.calentado = l.calentado;
            polo.cazado = l.cazado;
            polo.dia = l.dia;
            polo.guerra = l.guerra;
            polo.temperatura = l.temperatura;
            polo.terremoto = l.terremoto;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Algun fallo hubo al cargar");
        }
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
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "10 dias":
                if (polo != null) {
                    polo.pasar10dias();
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
                    aux.add("La temperatura es: " + polo.temperatura + " grados.");
                    if (polo.calentado == true || polo.cazado == true || polo.terremoto == true || polo.guerra == true) {
                        aux.add(" ");
                        aux.add("Estos son los catastrofes que han ocurrido");
                        if (polo.calentado == true) {
                            aux.add("Subio las temperaturas por el calentamiento global");
                        }
                        if (polo.cazado == true) {
                            aux.add("Aparecieron unos cazadores furtivos");
                        }
                        if (polo.terremoto == true) {
                            aux.add("Ha ocurrido un terremoto");
                        }
                        if (polo.guerra == true) {
                            aux.add("Ha habido una guerra entre esquimales");
                        }
                    } else {
                        aux.add(" ");
                        aux.add("No hubo ninguna catastrofe");
                    }
                    aux.add(" ");
                    aux.add("El numero de kyp es: " + polo.contarKYP() + " millones");
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
                    aux.add("Raza pez con: " + polo.contarRaza("pez") + " peces. Luego hay 3 tipos que son:");
                    aux.add(" ");
                    aux.add("Raza Bacalao: " + polo.contarRazaPeces("bacalao"));
                    aux.addAll(polo.toStringPeces("bacalao"));
                    aux.add(" ");
                    aux.add("Raza Raya: " + polo.contarRazaPeces("raya"));
                    aux.addAll(polo.toStringPeces("raya"));
                    aux.add(" ");
                    aux.add("Raza meluza negra: " + polo.contarRazaPeces("merluza negra"));
                    aux.addAll(polo.toStringPeces("merluza negra"));

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

            case "terremoto":
                if (polo != null) {
                    polo.terremoto();
                    JOptionPane.showMessageDialog(new JFrame(), "Ha ocurrido un terremoto");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "guerra":
                if (polo != null) {
                    if (polo.contarRaza("esquimal") > 1) {
                        polo.guerra();
                        JOptionPane.showMessageDialog(new JFrame(), "Los esquimales han sufrido una guerra");
                    } else {
                        JOptionPane.showMessageDialog(new JFrame(), "No hay esquimales para una guerra");
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "salir":
                try {
                    lista l = new lista(polo);
                    ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream("Polo.bin"));
                    salida.writeObject(l);
                    salida.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(new JFrame(), "Algun fallo hubo al guardar");
                }
                System.exit(0);
                break;
        }
    }
}
