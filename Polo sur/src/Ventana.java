
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Ventana extends JFrame implements ActionListener {

    JButton crear = new JButton("Crear nuevo polo");    
    JButton continuar = new JButton("Continuar");
    JButton pasarDia = new JButton("Pasar 1 dia");
    JButton pasar10Dias = new JButton("Pasar 10 dias");
    JButton detalles = new JButton("Detalles del dia actual");
    JButton calentar = new JButton("calentamiento global");
    JButton caza = new JButton("Caza furtiva");
    JButton salir = new JButton("Salir de la aplicacion");
    polo_Sur polo;
    boolean calentado, cazado;
    String archivoA = "C:/Users/Damian/Desktop/ArchivosP3IS2/animales";
    String archivoDP = "C:/Users/Damian/Desktop/ArchivosP3IS2/DiaTemperaturaCatastrofes.txt";
   
    public Ventana(String titulo) throws IOException, ClassNotFoundException {
        super(titulo);
        
        this.setLayout(new FlowLayout());

        crear.addActionListener(this);
        continuar.addActionListener(this);
        pasarDia.addActionListener(this);
        pasar10Dias.addActionListener(this);
        detalles.addActionListener(this);
        calentar.addActionListener(this);
        caza.addActionListener(this);
        salir.addActionListener(this);
        
        //OH NO, NO LO HE CONSEGUIDO
        crear.setIcon(new ImageIcon("C:/Users/Damian/Desktop/ArchivosP3IS2/polo_sur"));
        pasarDia.setIcon(new ImageIcon("C:/Users/Damian/Desktop/ArchivosP3IS2/polo_sur"));
        pasar10Dias.setIcon(new ImageIcon("C:/Users/Damian/Desktop/ArchivosP3IS2/polo_sur"));
        detalles.setIcon(new ImageIcon("C:/Users/Damian/Desktop/ArchivosP3IS2/polo_sur"));
        calentar.setIcon(new ImageIcon("C:/Users/Damian/Desktop/ArchivosP3IS2/polo_sur"));
        crear.setIconTextGap(ICONIFIED);
        
        crear.setActionCommand("crear");
        continuar.setActionCommand("continuar");
        pasarDia.setActionCommand("dia");
        pasar10Dias.setActionCommand("10 dias");
        detalles.setActionCommand("detalles");
        calentar.setActionCommand("calentar");
        caza.setActionCommand("cazar");
        salir.setActionCommand("salir");

        this.add(crear);
        this.add(continuar);
        this.add(pasarDia);
        this.add(pasar10Dias);
        this.add(detalles);
        this.add(calentar);
        this.add(caza);
        this.add(salir);

        this.setVisible(true);
        //this.setSize(300, 175);
        this.setSize(325, 200);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "crear":
                calentado = false;
                cazado = false;
                polo = new polo_Sur();
                JOptionPane.showMessageDialog(new JFrame(), "Polo sur creado con dia " + polo.dia);
                break;

            case "dia":
                calentado = false;
                cazado = false;
                if (polo != null) {
                    if (!polo.diaAdia()) {
                        JOptionPane.showMessageDialog(new JFrame(), "dia " + polo.dia);
                    } else {
                        System.exit(0);
                    }
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "10 dias":
                calentado = false;
                cazado = false;
                if (polo != null) {
                    if (!polo.pasar10dias()) {
                        JOptionPane.showMessageDialog(new JFrame(), "dia " + polo.dia);
                    } else {
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
                    aux.add("La temperatura es: " + polo.temperatura + " grados.");
                    if (calentado == true || cazado == true) {
                        aux.add(" ");
                        aux.add("Estos son los catastrofes que han ocurrido");
                        if (calentado == true) {
                            aux.add("Subio las temperaturas por el calentamiento global");
                        }
                        if (cazado == true) {
                            aux.add("Aparecieron unos cazadores furtivos");
                        }
                    }else{
                        aux.add(" ");
                        aux.add("No hubo ninguna catastrofe");
                    }
                    aux.add(" ");
                    aux.add("El numero de kyp es: " + polo.contarKYP() + "000000000");
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
                    cazado = true;
                    polo.cazaFurtiva();
                    JOptionPane.showMessageDialog(new JFrame(), "caza furtiva realizada ");
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;

            case "calentar":
                if (polo != null) {
                    calentado = true;
                    polo.calentamientoGlobal();
                    JOptionPane.showMessageDialog(new JFrame(), "Temperatura sube a " + polo.temperatura);
                } else {
                    JOptionPane.showMessageDialog(new JFrame(), "Aun no se creo el polo");
                }
                break;
            case "continuar":
        {
            try {
                //Comprobamos si los archivos estan vacios
                //si no estan vacios
                File archivoAnimales = new File(archivoA); //ponga aquí la ruta del archivo
                File archivoDatosPolo = new File(archivoDP); //ponga aquí la ruta del archivo
                if ((!archivoAnimales.exists())||(!archivoDatosPolo.exists())) {
                    JOptionPane.showMessageDialog(new JFrame(),"OH NO, NO EXISTE EL FICHERO DONDE SE GUARDAN LOS DATOS DEL POLO");
                    JOptionPane.showMessageDialog(new JFrame(),"Mire el archivo IMPORTANTE y siga sus instrucciones por favor");
                    break;
                }                
                JOptionPane.showMessageDialog(new JFrame(), "Continuamos el polo por donde nos quedamos");
                int nCatastrofes;
                calentado = false;                                              //lo inicializamos a false
                cazado = false;                                                 //lo inicializamos a false
                polo = new polo_Sur();                                          //creamos un polo para poder llamar a la funcion continuar
                nCatastrofes = polo.continuar(archivoA, archivoDP);                        //abrimos los ficheros y metemos sus valores en variables
                if(nCatastrofes == 1){
                    calentado = true;
                }
                else if(nCatastrofes == 2){
                    cazado = true;
                }
                else if(nCatastrofes == 3){
                    calentado = true;
                    cazado = true;
                }
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
            }
            break;
        }
    
            case "salir":
        {
            if (polo == null) {
                    JOptionPane.showMessageDialog(new JFrame(), "No hay polo por lo que no guardare sus datos");
                }          
            else{
            try {
                JOptionPane.showMessageDialog(new JFrame(), "Oh vaya, veo que tienes datos de un polo a medio, permitame guardarlos");
                polo.guardarDatos(calentado, cazado, archivoA, archivoDP);
                JOptionPane.showMessageDialog(new JFrame(), "Datos guardados satisfactoriamente");
            } catch (IOException ex) {
                Logger.getLogger(Ventana.class.getName()).log(Level.SEVERE, null, ex);
              }
            }
        }
                System.exit(0);
                break;
        }
    }
}
