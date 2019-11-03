
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class polo_Sur {

    ArrayList<serVivo> animales = new ArrayList<serVivo>();
    double temperatura;
    int dia;

    public polo_Sur() {
        dia = 0;
        temperatura = 4;
        crearEsquimales();
        crearOsos();
        crearMorsas();
        crearFocas();
        crearPeces();
        crearkyp();
    }
    
    public void diaAdia() {
        dia++;
        cambiarTemperatura();
        comer();
        reproducir();
        muerteInesperada();
    }

    public void pasar10dias() {
        for (int i = 0; i < 10; i++) {
            dia++;
            cambiarTemperatura();
            comer();
            reproducir();
            muerteInesperada();
            if (mundoMuerto()) {
                JOptionPane.showMessageDialog(new JFrame(), "El mundo esta muerto en el dia" + dia);
            }
        }
    }

    public void crearEsquimales() {
        int n, i, masa;                                            //en n ira el numero de esquimales que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (14 - 12 + 1) + 12);          //i es solo para explorar el for
        masa = (int) Math.floor(Math.random() * (48 - 35 + 1) + 35);         //metemos el numero de esquimales iniciales en n
        for (i = 0; i <= n; i++) {
            animales.add(new esquimal(dia, masa, 32 / 1000, 24 / 1000));
        }
    }

    public void crearOsos() {
        int n, i, masa;                                            //en n ira el numero de oso que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (28 - 22 + 1) + 22);          //i es solo para explorar el for
        masa = (int) Math.floor(Math.random() * (55 - 40 + 1) + 40);         //metemos el numero de esquimales iniciales en n
        for (i = 0; i <= n; i++) {
            animales.add(new oso(dia, masa, 153 / 1000, 95 / 1000));
        }
    }

    public void crearMorsas() {
        int n, i, masa;                                            //en n ira el numero de morsas que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (48 - 42 + 1) + 42);          //i es solo para explorar el for
        masa = (int) Math.floor(Math.random() * (42 - 30 + 1) + 30);         //metemos el numero de esquimales iniciales en n
        for (i = 0; i <= n; i++) {
            animales.add(new morsa(dia, masa, 98 / 1000, 95 / 1000));
        }
    }

    public void crearFocas() {
        int n, i, masa;                                            //en n ira el numero de focas que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (290 - 260 + 1) + 260);       //i es solo para explorar el for
        masa = (int) Math.floor(Math.random() * (32 - 25 + 1) + 25);         //metemos el numero de esquimales iniciales en n
        for (i = 0; i <= n; i++) {
            animales.add(new foca(dia, masa, 100 / 1000, 90 / 1000));
        }
    }

    public void crearPeces() {
        Random r = new Random();
        float aux;                                                 //en aux tendremos el numero aleatorio para elegir el tipo de pez
        int n, i, masa;                                            //en n ira el numero de peces que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (8000 - 7000 + 1) + 7000);    //i es solo para explorar el for
        masa = (int) Math.floor(Math.random() * (70 - 55 + 1) + 55);         //metemos el numero de esquimales iniciales en n
        for (i = 0; i <= n; i++) {
            aux = r.nextFloat();
            if (aux <= 0.33) {
                animales.add(new pez(dia, masa, 185 / 1000, 163 / 1000, "bacalao"));
            } else if (aux <= 0.66) {
                animales.add(new pez(dia, masa, 185 / 1000, 163 / 1000, "raya"));
            } else {
                animales.add(new pez(dia, masa, 185 / 1000, 163 / 1000, "merluza negra"));
            }
        }
    }

    public void crearkyp() {
        int n, i;                                                  //en n ira el numero de kyp que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (75 - 65 + 1) + 65);          //i es solo para explorar el for
        n = n * 1000000000;                                          //metemos el numero de esquimales iniciales en n
        animales.add(new kyp(dia, 0, 0, 0, n));
    }

    public void calentamientoGlobal() {
        temperatura = temperatura+2;
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
                        animales.add(new esquimal(dia, i.masaMuscular, 32 / 1000, 24 / 1000));
                    }
                    break;
                case "oso":
                    if (i.reproducirse()) {
                        animales.add(new oso(dia, i.masaMuscular, 153 / 1000, 95 / 1000));
                    }
                    break;
                case "morsa":
                    if (i.reproducirse()) {
                        animales.add(new morsa(dia, i.masaMuscular, 98 / 1000, 95 / 1000));
                    }
                    break;
                case "foca":
                    if (i.reproducirse()) {
                        animales.add(new foca(dia, i.masaMuscular, 100 / 1000, 90 / 1000));
                    }
                    break;
                case "bacalao":
                    if (i.reproducirse()) {
                        animales.add(new pez(dia, i.masaMuscular, 185 / 1000, 163 / 1000, "bacalao"));
                    }
                    break;
                case "raya":
                    if (i.reproducirse()) {
                        animales.add(new pez(dia, i.masaMuscular, 185 / 1000, 163 / 1000, "raya"));
                    }
                    break;
                case "merluza negra":
                    if (i.reproducirse()) {
                        animales.add(new pez(dia, i.masaMuscular, 185 / 1000, 163 / 1000, "merluza negra"));
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
                case "kypl":

                    break;
                default:
                    return false;
            }
        }
        return true;
    }
}
