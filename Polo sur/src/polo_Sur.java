
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Damian
 */
public class polo_Sur {

    ArrayList<serVivo> animales = new ArrayList<serVivo>();
    double temperatura;
    int dia;
    boolean calentado;
    boolean cazado;
    boolean terremoto;
    boolean guerra;

    /**
     *
     */
    public polo_Sur() {
        dia = 1;
        temperatura = 4;
        crearEsquimales();
        crearOsos();
        crearMorsas();
        crearFocas();
        crearPeces();
        crearkyp();
        cazado = false;
        calentado = false;
        terremoto = false;
        guerra = false;
    }

    /**
     *
     * @return
     */
    public boolean diaAdia() {
        dia++;
        cazado = false;
        calentado = false;
        terremoto = false;
        guerra = false;
        cambiarTemperatura();
        comer();
        reproducir();
        muerteInesperada();
        if (mundoMuerto()) {
            JOptionPane.showMessageDialog(new JFrame(), "El mundo esta muerto en el dia " + dia);
            return true;
        }
        return false;
    }

    /**
     *
     * @return
     */
    public boolean pasar10dias() {
        for (int i = 0; i < 10; i++) {
            dia++;
            cazado = false;
            calentado = false;
            terremoto = false;
            guerra = false;
            cambiarTemperatura();
            comer();
            reproducir();
            muerteInesperada();
            if (mundoMuerto()) {
                JOptionPane.showMessageDialog(new JFrame(), "El mundo esta muerto en el dia " + dia);
                return true;
            }
        }
        return false;
    }

    /**
     *
     */
    public void crearEsquimales() {
        int n, i, masa;                                                    //en n ira el numero de esquimales que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (14 - 12 + 1) + 12);          //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (48 - 35 + 1) + 35);
            animales.add(new esquimal(dia, masa, (float) (32.0 / 1000.0), (float) (24.0 / 1000.0)));
        }
    }

    /**
     *
     */
    public void crearOsos() {
        int n, i, masa;                                                    //en n ira el numero de oso que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (27 - 22 + 1) + 22);          //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (54 - 40 + 1) + 40);
            animales.add(new oso(dia, masa, (float) (153.0 / 1000.0), (float) (95.0 / 1000.0)));
        }
    }

    /**
     *
     */
    public void crearMorsas() {
        int n, i, masa;                                                    //en n ira el numero de morsas que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (47 - 42 + 1) + 42);          //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (41 - 30 + 1) + 30);
            animales.add(new morsa(dia, masa, (float) (98.0 / 1000.0), (float) (95.0 / 1000.0)));
        }
    }

    /**
     *
     */
    public void crearFocas() {
        int n, i, masa;                                                    //en n ira el numero de focas que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (289 - 260 + 1) + 260);       //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (31 - 25 + 1) + 25);
            animales.add(new foca(dia, masa, (float) (100.0 / 1000.0), (float) (90.0 / 1000.0)));
        }
    }

    /**
     *
     */
    public void crearPeces() {
        Random r = new Random();
        float aux;                                                         //en aux tendremos el numero aleatorio para elegir el tipo de pez
        int n, i, masa;                                                    //en n ira el numero de peces que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (7999 - 7000 + 1) + 7000);    //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            aux = r.nextFloat();
            masa = (int) Math.floor(Math.random() * (69 - 55 + 1) + 55);
            if (aux <= 0.33) {
                animales.add(new pez(dia, masa, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), "bacalao"));
            } else if (aux <= 0.66) {
                animales.add(new pez(dia, masa, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), "raya"));
            } else {
                animales.add(new pez(dia, masa, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), "merluza negra"));
            }
        }
    }

    /**
     *
     */
    public void crearkyp() {
        int n;                                                  //en n ira el numero de kyp que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (74 - 65 + 1) + 65);          //i es solo para explorar el for
        animales.add(new kyp(dia, 0, 0, 0, n));           //metemos el numero de esquimales iniciales en n
    }

    /**
     *
     */
    public void calentamientoGlobal() {
        calentado = true;
        temperatura = temperatura + 2;
    }

    /**
     *
     */
    public void cazaFurtiva() {
        Random r = new Random();
        cazado = true;
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            if (i instanceof oso && r.nextFloat() <= 0.15) {
                animales.remove(i);
            } else if (i instanceof morsa && r.nextFloat() <= 0.20) {
                animales.remove(i);
            }
        }
    }

    public void terremoto() {
        Random r = new Random();
        terremoto = true;
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            if (i instanceof oso && r.nextFloat() <= 0.30) {
                animales.remove(i);
            } else if (i instanceof morsa && r.nextFloat() <= 0.40) {
                animales.remove(i);
            } else if (i instanceof foca && r.nextFloat() <= 0.35) {
                animales.remove(i);
            } else if (i instanceof pez && r.nextFloat() <= 0.10) {
                animales.remove(i);
            } else if (i instanceof esquimal && r.nextFloat() <= 0.32) {
                animales.remove(i);
            } else if (i instanceof kyp && r.nextFloat() <= 0.70) {
                animales.remove(i);
            }
        }
    }

    public void guerra() {
        Random r = new Random();
        guerra = true;
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            if (i instanceof esquimal && r.nextFloat() <= 0.50) {
                animales.remove(i);
            }
        }
    }

    /**
     *
     */
    public void reproducir() {
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            switch (i.raza) {
                case "esquimal":
                    if (i.reproducirse()) {
                        animales.add(new esquimal(dia, i.masaMuscular, (float) (32.0 / 1000.0), (float) (24.0 / 1000.0)));
                    }
                    break;
                case "oso":
                    if (i.reproducirse()) {
                        animales.add(new oso(dia, i.masaMuscular, (float) (153.0 / 1000.0), (float) (95.0 / 1000.0)));
                    }
                    break;
                case "morsa":
                    if (i.reproducirse()) {
                        animales.add(new morsa(dia, i.masaMuscular, (float) (98.0 / 1000.0), (float) (95.0 / 1000.0)));
                    }
                    break;
                case "foca":
                    if (i.reproducirse()) {
                        animales.add(new foca(dia, i.masaMuscular, (float) (100.0 / 1000.0), (float) (90.0 / 1000.0)));
                    }
                    break;
                case "pez":
                    if (i.reproducirse()) {
                        animales.add(new pez(dia, i.masaMuscular, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), ((pez) i).tipo));
                    }
                    break;
            }
        }
        reproducirKYP();
    }

    /**
     *
     */
    public void reproducirKYP() {
        if (temperatura < 5.5 && temperatura >= 5.0) {
            animales.add(new kyp(dia, 0, 0, 0, 12));
        } else if (temperatura < 5.0 && temperatura >= 4.0) {
            animales.add(new kyp(dia, 0, 0, 0, 22));
        } else if (temperatura < 4.0 && temperatura >= 3.0) {
            animales.add(new kyp(dia, 0, 0, 0, 18));
        }
    }

    /**
     *
     */
    public void muerteInesperada() {
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            switch (i.raza) {
                case "esquimal":
                    if (i.muerteInesperada()) {
                        animales.remove(i);
                    }
                    break;
                case "oso":
                    if (i.muerteInesperada()) {
                        animales.remove(i);
                    }
                    break;
                case "morsa":
                    if (i.muerteInesperada()) {
                        animales.remove(i);
                    }
                    break;
                case "foca":
                    if (i.muerteInesperada()) {
                        animales.remove(i);
                    }
                    break;
                case "pez":
                    if (i.muerteInesperada()) {
                        animales.remove(i);
                    }
                    break;
            }
        }
    }

    /**
     *
     */
    public void cambiarTemperatura() {
        Random r = new Random();
        if (temperatura >= 5.0) {
            if (r.nextFloat() <= 0.45) {
                temperatura = temperatura + 0.2;
            } else {
                temperatura = temperatura - 0.2;
            }
        } else if (temperatura <= 3.0) {
            if (r.nextFloat() <= 0.45) {
                temperatura = temperatura - 0.2;
            } else {
                temperatura = temperatura + 0.2;
            }
        } else {
            if (r.nextFloat() <= 0.3) {
                temperatura = temperatura - 0.2;
            } else if (r.nextFloat() <= 0.95) {
                temperatura = temperatura + 0.2;
            }
        }
    }

    /**
     *
     */
    public void comer() {
        int cantidad;
        int j;
        boolean esperanza;
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            switch (i.raza) {
                case "esquimal":
                    cantidad = ((esquimal) i).comerPeces();
                    for (j = 1; j <= cantidad; j++) {
                        esperanza = esComido("pez", i);
                        if (!esperanza) {
                            break;
                        }
                    }

                    cantidad = ((esquimal) i).comerFocas();
                    for (j = 1; j <= cantidad; j++) {
                        esperanza = esComido("foca", i);
                        if (!esperanza) {
                            break;
                        }
                    }
                    break;
                case "oso":
                    cantidad = ((oso) i).comerFocas();
                    for (j = 1; j <= cantidad; j++) {
                        esperanza = esComido("foca", i);
                        if (!esperanza) {
                            break;
                        }
                    }
                    cantidad = ((oso) i).comerPeces();
                    for (j = 1; j <= cantidad; j++) {
                        esperanza = esComido("pez", i);
                        if (!esperanza) {
                            break;
                        }
                    }
                    break;
                case "morsa":
                    cantidad = ((morsa) i).comerFocas();
                    for (j = 1; j <= cantidad; j++) {
                        esperanza = esComido("foca", i);
                        if (!esperanza) {
                            break;
                        }
                    }
                    cantidad = ((morsa) i).comerOsos();
                    for (j = 1; j <= cantidad; j++) {
                        esperanza = esComido("oso", i);
                        if (!esperanza) {
                            break;
                        }
                    }
                    break;
                case "foca":
                    cantidad = ((foca) i).comerPeces();
                    for (j = 1; j <= cantidad; j++) {
                        esperanza = esComido("pez", i);
                        if (!esperanza) {
                            break;
                        }
                    }
                    break;
                case "pez":
                    cantidad = ((pez) i).comerKrillPlankton();
                    for (j = 1; j <= cantidad; j++) {
                        esperanza = esComido("kyp", i);
                        if (!esperanza) {
                            break;
                        }
                    }
                    break;
            }
        }
    }

    /**
     *
     * @return
     */
    public boolean mundoMuerto() {
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            switch (i.raza) {
                case "kyp":

                    break;
                default:
                    return false;
            }
        }
        return true;
    }

    /**
     *
     * @param comido
     * @param depredador
     * @return
     */
    public boolean esComido(String comido, serVivo depredador) {
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        serVivo masPequeno = new esquimal(0, Integer.MAX_VALUE, 0.0f, 0.0f);
        boolean puedeComer = false;
        if (comido.equals("pez")) {
            for (serVivo i : aux) {
                if (i instanceof pez) {
                    if (((pez) i).tipo.equals("bacalao")) {
                        puedeComer = true;
                        if (i.masaMuscular < masPequeno.masaMuscular) {
                            masPequeno = i;
                        }
                    } else if (((pez) i).tipo.equals("raya")) {
                        puedeComer = true;
                        if (i.masaMuscular < masPequeno.masaMuscular) {
                            masPequeno = i;
                        }
                    } else if (((pez) i).tipo.equals("merluza negra")) {
                        puedeComer = true;
                        if (i.masaMuscular < masPequeno.masaMuscular) {
                            masPequeno = i;
                        }
                    }
                }
            }
        } else if (comido.equals("kyp")) {
            boolean estoyComiendo;
            estoyComiendo = comeKyP(depredador);
            if (!estoyComiendo) {
                return false;
            }

            return true;
        } else {
            for (serVivo i : aux) {
                if (i.raza == comido) {
                    puedeComer = true;
                    if (i.masaMuscular < masPequeno.masaMuscular) {
                        masPequeno = i;
                    }
                }
            }
        }
        if (puedeComer) {
            animales.remove(masPequeno);
            return true;
        }
        animales.remove(depredador);
        return false;
    }

    /**
     *
     * @param depredador
     * @return
     */
    public boolean comeKyP(serVivo depredador) {
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            if (i.raza.equals("kyp")) {
                ((kyp) i).num = ((kyp) i).num - 1000000;
                if (((kyp) i).num == 0) {
                    animales.remove(i);
                }
                return true;
            }
        }
        animales.remove(depredador);
        return false;
    }

    /**
     *
     * @param raza
     * @return
     */
    public ArrayList<String> toString(String raza) {
        ArrayList<String> f = new ArrayList<String>();
        for (serVivo i : animales) {
            if (i.raza.equals(raza)) {
                f.add(i.toString());
            }
        }
        return f;
    }

    /**
     *
     * @param raza
     * @return
     */
    public int contarRaza(String raza) {
        int j = 0;
        for (serVivo i : animales) {
            if (i.raza.equals(raza)) {
                j++;
            }
        }
        return j;
    }

    /**
     *
     * @return
     */
    public int contarKYP() {
        int j = 0;
        for (serVivo i : animales) {
            if (i instanceof kyp) {
                j = j + ((kyp) i).num;
            }
        }
        return j;
    }

    public int contarRazaPeces(String tipo) {
        int j = 0;
        for (serVivo i : animales) {
            if (i instanceof pez) {
                if (((pez) i).tipo.equals(tipo)) {
                    j++;
                }
            }
        }
        return j;
    }

    public ArrayList<String> toStringPeces(String tipo) {
        ArrayList<String> f = new ArrayList<String>();
        for (serVivo i : animales) {
            if (i instanceof pez) {
                if (((pez) i).tipo.equals(tipo)) {
                    f.add(i.toString());
                }
            }
        }
        return f;
    }
}
