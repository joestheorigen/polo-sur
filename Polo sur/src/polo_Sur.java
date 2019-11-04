
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class polo_Sur {

    ArrayList<serVivo> animales = new ArrayList<serVivo>();
    double temperatura;
    int dia;

    public polo_Sur() {
        dia = 1;
        temperatura = 4;
        crearEsquimales();
        crearOsos();
        crearMorsas();
        crearFocas();
        crearPeces();
        crearkyp();
    }

    public boolean diaAdia() {
        dia++;
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

public boolean pasar10dias() {
    for (int i = 0; i < 10; i++) {
        dia++;
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
        
    public void crearEsquimales() {
        int n, i, masa;                                                    //en n ira el numero de esquimales que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (14 - 12 + 1) + 12);          //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (48 - 35 + 1) + 35);
            animales.add(new esquimal(dia, masa, (float) (32.0 / 1000.0), (float) (24.0 / 1000.0)));
        }
    }

    public void crearOsos() {
        int n, i, masa;                                                    //en n ira el numero de oso que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (28 - 22 + 1) + 22);          //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (55 - 40 + 1) + 40);
            animales.add(new oso(dia, masa, (float) (153.0 / 1000.0), (float) (95.0 / 1000.0)));
        }
    }

    public void crearMorsas() {
        int n, i, masa;                                                    //en n ira el numero de morsas que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (48 - 42 + 1) + 42);          //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (42 - 30 + 1) + 30);
            animales.add(new morsa(dia, masa, (float) (98.0 / 1000.0), (float) (95.0 / 1000.0)));
        }
    }

    public void crearFocas() {
        int n, i, masa;                                                    //en n ira el numero de focas que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (290 - 260 + 1) + 260);       //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (32 - 25 + 1) + 25);
            animales.add(new foca(dia, masa, (float) (100.0 / 1000.0), (float) (90.0 / 1000.0)));
        }
    }

    public void crearPeces() {
        Random r = new Random();
        float aux;                                                         //en aux tendremos el numero aleatorio para elegir el tipo de pez
        int n, i, masa;                                                    //en n ira el numero de peces que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (8000 - 7000 + 1) + 7000);    //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            aux = r.nextFloat();
            masa = (int) Math.floor(Math.random() * (70 - 55 + 1) + 55);
            if (aux <= 0.33) {
                animales.add(new pez(dia, masa, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), "bacalao"));
            } else if (aux <= 0.66) {
                animales.add(new pez(dia, masa, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), "raya"));
            } else {
                animales.add(new pez(dia, masa, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), "merluza negra"));
            }
        }
    }

    public void crearkyp() {
        int n;                                                  //en n ira el numero de kyp que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (75 - 65 + 1) + 65);          //i es solo para explorar el for
        n = n * 1000000000;                                          //metemos el numero de esquimales iniciales en n
        animales.add(new kyp(dia, 0, 0, 0, n));
    }

    public void calentamientoGlobal() {
        temperatura = temperatura + 2;
    }

    public void cazaFurtiva() {
        Random r = new Random();
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            if (i instanceof oso && r.nextFloat() <= 0.15) {
                animales.remove(i);
            } else if (i instanceof morsa && r.nextFloat() <= 0.20) {
                animales.remove(i);
            }
        }
    }

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
                case "bacalao":
                    if (i.reproducirse()) {
                        animales.add(new pez(dia, i.masaMuscular, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), "bacalao"));
                    }
                    break;
                case "raya":
                    if (i.reproducirse()) {
                        animales.add(new pez(dia, i.masaMuscular, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), "raya"));
                    }
                    break;
                case "merluza negra":
                    if (i.reproducirse()) {
                        animales.add(new pez(dia, i.masaMuscular, (float) (185.0 / 1000.0), (float) (163.0 / 1000.0), "merluza negra"));
                    }
                    break;
            }
        }
        reproducirKYP();
    }

    public void reproducirKYP() {
        if (temperatura < 5.5 && temperatura >= 5.0) {
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
        } else if (temperatura < 5.0 && temperatura >= 4.0) {
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
        } else if (temperatura < 4.0 && temperatura >= 3.0) {
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
            animales.add(new kyp(dia, 0, 0, 0, 2000000000));
        }
    }

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
                case "bacalao":
                    if (i.muerteInesperada()) {
                        animales.remove(i);
                    }
                    break;
                case "raya":
                    if (i.muerteInesperada()) {
                        animales.remove(i);
                    }
                    break;
                case "merluza negra":
                    if (i.muerteInesperada()) {
                        animales.remove(i);
                    }
                    break;
            }
        }
    }

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

    //IMPLEMENTAR METODO
    public void comer() {
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        for (serVivo i : aux) {
            if (animales.contains(i)) {
                switch (i.raza) {
                    case "esquimal":

                        break;
                    case "oso":

                        break;
                    case "morsa":

                        break;
                    case "foca":

                        break;
                    case "bacalao":

                        break;
                    case "raya":

                        break;
                    case "merluza negra":

                        break;
                }
            }
        }
    }

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

    public ArrayList<String> toString(String raza) {
        ArrayList<String> f = new ArrayList<String>();
        for (serVivo i : animales) {
            if (i.raza.equals(raza)) {
                f.add(i.toString());
            }
        }
        return f;
    }
    
    public int contarRaza(String raza) {
        int j=0;
        for (serVivo i : animales) {
            if (i.raza.equals(raza)) {
                j++;
            }
        }
        return j;
    }
    
    public int contarKYP() {
        int j=0;
        for (serVivo i : animales) {
            if (i instanceof kyp) {
                j=j+((kyp) i).num;
            }
        }
        return j;
    }
}
