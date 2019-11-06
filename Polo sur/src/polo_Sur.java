
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
        n = (int) Math.floor(Math.random() * (27 - 22 + 1) + 22);          //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (54 - 40 + 1) + 40);
            animales.add(new oso(dia, masa, (float) (153.0 / 1000.0), (float) (95.0 / 1000.0)));
        }
    }

    public void crearMorsas() {
        int n, i, masa;                                                    //en n ira el numero de morsas que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (47 - 42 + 1) + 42);          //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (41 - 30 + 1) + 30);
            animales.add(new morsa(dia, masa, (float) (98.0 / 1000.0), (float) (95.0 / 1000.0)));
        }
    }

    public void crearFocas() {
        int n, i, masa;                                                    //en n ira el numero de focas que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (289 - 260 + 1) + 260);       //i es solo para explorar el for
        for (i = 0; i <= n; i++) {                                         //metemos el numero de esquimales iniciales en n
            masa = (int) Math.floor(Math.random() * (31 - 25 + 1) + 25);
            animales.add(new foca(dia, masa, (float) (100.0 / 1000.0), (float) (90.0 / 1000.0)));
        }
    }

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

    public void crearkyp() {
        int n;                                                  //en n ira el numero de kyp que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random() * (74 - 65 + 1) + 65);          //i es solo para explorar el for
        animales.add(new kyp(dia, 0, 0, 0, n));           //metemos el numero de esquimales iniciales en n
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
            animales.add(new kyp(dia, 0, 0, 0, 12));
        } else if (temperatura < 5.0 && temperatura >= 4.0) {
            animales.add(new kyp(dia, 0, 0, 0, 22));
        } else if (temperatura < 4.0 && temperatura >= 3.0) {
            animales.add(new kyp(dia, 0, 0, 0, 18));
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

    public void comer() {                                                   //cuando un animal come mueren otros animales
        Random r = new Random();                                            //creamos un random que va de 0.00 a 1.00 para ver cuanto comerá el animal
        float x;                                                            //la usamos para almacenar el numero random
        int j;                                                              //la usamos para recorrer los for
        boolean esperanza;                                                  // si es true es que ha podido comer y esta vivo,
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();     //si es false es que no ha podido comer y esta muerto
        for (serVivo i : aux) {                                             //gracias a aux podemos exploarar todos los animales
            switch (i.raza) {                                               //aqui miramos que raza va a alimentarse
                case "esquimal":                                            //si se alimenta el esquimal
                    x = r.nextFloat();   //primero vemos cuantos peces comera
                    if (x <= 0.33) {
                        for (j = 1; j <= 2; j++) {      //comera 2 peces
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }

                        }
                    } else if (x <= 0.66) {
                        for (j = 1; j <= 3; j++) {      //comera 3 peces
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else {
                        for (j = 1; j <= 4; j++) {      //comera 4 peces
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    }
                    x = r.nextFloat();  //ahora vemos cuantas focas comera
                    if (x > 0.50) {                     //hay un 50% de probabilidades de que coma una foca, si no no comera foca
                        esperanza = esComido("foca", i);
                        if (!esperanza) {
                            break;
                        }
                    }
                    break;
                case "oso":                                                 //si se alimenta el oso
                    x = r.nextFloat();   //primero vemos cuantas focas comera
                    if (x <= 0.50) {                    //Se comera una 
                        esperanza = esComido("foca", i);
                        if (!esperanza) {
                            break;
                        }
                    } else {
                        for (j = 1; j <= 2; j++) {      //se comera 2 focas
                            esperanza = esComido("foca", i);
                            if (!esperanza) {
                                break;
                            }
                        }
                    }
                    x = r.nextFloat();  //ahora vemos cuantos peces se come
                    if (x <= 0.16) {
                        for (j = 1; j <= 10; j++) {     //se comera 10 peces
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }

                    } else if (x <= 0.33) {
                        for (j = 1; j <= 11; j++) {     //se comera 11 peces
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else if (x <= 0.50) {
                        for (j = 1; j <= 12; j++) {     //se comera 12 peces
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else if (x <= 0.66) {
                        for (j = 1; j <= 13; j++) {     //se comera 13 peces
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else if (x <= 0.83) {
                        for (j = 1; j <= 14; j++) {     //se comera 14 peces
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else {
                        for (j = 1; j <= 15; j++) {     //se comera 15 peces
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    }
                    break;
                case "morsa":                                               //si se alimenta la morsa
                    x = r.nextFloat();   //primero vemos cuantas focas comera
                    if (x <= 0.50) {                    //Se comera una 
                        esperanza = esComido("foca", i);
                        if (!esperanza) {
                            break;
                        }
                    } else {
                        for (j = 1; j <= 2; j++) {      //se comera 2 focas
                            esperanza = esComido("foca", i);
                            if (!esperanza) {
                                break;
                            }
                        }
                    }
                    x = r.nextFloat();   //primero vemos cuantos osos comera
                    if ((x < 0.33)) {    //Se comera uno 
                        esperanza = esComido("oso", i);
                        if (!esperanza) {
                            break;
                        }
                    } else if (x < 0.66) {            //Se comera 2
                        for (j = 1; j <= 2; j++) {
                            esperanza = esComido("oso", i);
                            if (!esperanza) {
                                break;
                            }
                        }
                    }
                    break;
                case "foca":                                                //si se alimenta la foca
                    x = r.nextFloat();   //primero vemos cuantos peces comera
                    if (x <= 0.16) {                    //Se comera una 
                        for (j = 1; j <= 15; j++) {     //se come 15 pescados
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else if (x <= 0.33) {
                        for (j = 1; j <= 16; j++) {     //se come 16 pescados
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else if (x <= 0.50) {
                        for (j = 1; j <= 17; j++) {     //se come 17 pescados
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else if (x <= 0.66) {
                        for (j = 1; j <= 18; j++) {     //se come 18 pescados
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else if (x <= 0.83) {
                        for (j = 1; j <= 19; j++) {     //se come 19 pescados
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    } else {
                        for (j = 1; j <= 20; j++) {     //se come 20 pescados
                            esperanza = esComido("pez", i);
                            if (!esperanza) { //si es false es que ha muerto el depredador al no poder comer
                                break;     //si ha muerto el depredador sale del switch
                            }
                        }
                    }
                    break;
                case "bacalao":                                             //si se alimenta el bacalao
                    x = r.nextFloat();
                    if (x <= 50) {
                        esperanza = esComido("kyp", i);
                        if (!esperanza) {
                            break;
                        }
                    } else {
                        for (j = 1; j <= 2; j++) {
                            esperanza = esComido("kyp", i);
                            if (!esperanza) {
                                break;
                            }
                        }
                    }
                    break;
                case "raya":                                                //si se alimenta la raya
                    x = r.nextFloat();
                    if (x <= 50) {
                        esperanza = esComido("kyp", i);
                        if (!esperanza) {
                            break;
                        }
                    } else {
                        for (j = 1; j <= 2; j++) {
                            esperanza = esComido("kyp", i);
                            if (!esperanza) {
                                break;
                            }
                        }
                    }
                    break;
                case "merluza negra":                                       //si se alimenta la merluza negra
                    x = r.nextFloat();
                    if (x <= 50) {
                        esperanza = esComido("kyp", i);
                        if (!esperanza) {
                            break;
                        }
                    } else {
                        for (j = 1; j <= 2; j++) {
                            esperanza = esComido("kyp", i);
                            if (!esperanza) {
                                break;
                            }
                        }
                    }
                    break;
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

    public boolean esComido(String comido, serVivo depredador) {
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        int pesoMasPequeno = Integer.MAX_VALUE;
        serVivo masPequeno = new esquimal(0, 1000000, 0.0f, 0.0f);  //lo usaremos para comparar los pesos entre los animales, si un esquimal, era por darles uso
        boolean puedeComer = false; //al principio a fasle porque no sabemos si podra comer
        if (comido.equals("pez")) {          //como hay tres tipos de peces deberemos sacar el mas pequeno pero de entre todas las razas
            for (serVivo i : aux) {     //recorremos todos los animales
                if (i.raza.equals("bacalao")) {   //si es bacalao cuenta como pez
                    puedeComer = true;  //con que encuentre uno de la raza que quiere comer sera true que ha comido                    
                    if (i.masaMuscular < pesoMasPequeno) {  //cada vez que encontremos un animal del que queremos comer y sea mas pequeno que el mas pequeno hasta ahora
                        pesoMasPequeno = i.masaMuscular;    //nos lo quedamos como nuevo mas pequeno
                        masPequeno = i;                     //para luego comernoslos a no ser que encontremos otro mas pequeno
                    }
                } else if (i.raza.equals("raya")) {  //si es raya cuenta como pez
                    puedeComer = true;  //con que encuentre uno de la raza que quiere comer sera true que ha comido
                    if (i.masaMuscular < pesoMasPequeno) {  //cada vez que encontremos un animal del que queremos comer y sea mas pequeno que el mas pequeno hasta ahora
                        pesoMasPequeno = i.masaMuscular;    //nos lo quedamos como nuevo mas pequeno
                        masPequeno = i;                     //para luego comernoslos a no ser que encontremos otro mas pequeno
                    }
                } else if (i.raza.equals("merluza negra")) {  //si es merluza negra cuenta como pez
                    puedeComer = true;  //con que encuentre uno de la raza que quiere comer sera true que ha comido
                    if (i.masaMuscular < pesoMasPequeno) {  //cada vez que encontremos un animal del que queremos comer y sea mas pequeno que el mas pequeno hasta ahora
                        pesoMasPequeno = i.masaMuscular;    //nos lo quedamos como nuevo mas pequeno
                        masPequeno = i;                     //para luego comernoslos a no ser que encontremos otro mas pequeno
                    }
                }
            }
        } else if (comido.equals("kyp")) {
            boolean estoyComiendo;  //para comprobar si puede tomarse toda su racion de krill y plankton
            estoyComiendo = comeKyP(depredador);    //comer 1 es como comer 1000000 de Kyp
            if (!estoyComiendo) { //si en algun momento no queda Krill ni plankton y no puede comer todo lo que debia
                return false;   //el depredador muere
            }

            return true;
        } else {       //si no es pez ni plankton o krill lo que queremos comer
            for (serVivo i : aux) {     //recorremos todos los animales
                if (i.raza == comido) {   //si encontramos alguno de la raza que queremos comer
                    puedeComer = true;  //con que encuentre uno de la raza que quiere comer sera true que ha comido
                    if (i.masaMuscular < pesoMasPequeno) {  //cada vez que encontremos un animal del que queremos comer y sea mas pequeno que el mas pequeno hasta ahora
                        pesoMasPequeno = i.masaMuscular;    //nos lo quedamos como nuevo mas pequeno
                        masPequeno = i;                     //para luego comernoslos a no ser que encontremos otro mas pequeno
                    }
                }
            }
        }
        if (puedeComer) { //si ha podido comer
            animales.remove(masPequeno); //pues se come al mas pequeno
            return true;    //y el depredador puede vivir un poco mas
        }
        animales.remove(depredador);  //si no ha comido muere
        return false;  //y devuelve false
    }

    public boolean comeKyP(serVivo depredador) {
        ArrayList<serVivo> aux = (ArrayList<serVivo>) animales.clone();
        //gracias a los return solo se come uno si puede cada vez que se llama a esta funcion
        for (serVivo i : aux) {     //recorremos todos los animales
            if (i.raza.equals("kyp")) {
                ((kyp) i).num = ((kyp) i).num - 1000000;
                if (((kyp) i).num == 0) {
                    animales.remove(i);
                }
                return true;
            }
        }
        //si no encuentra mas krill o plankton es que no hay más para comerse, entonces el depredador que se queria alimentar muere
        animales.remove(depredador);
        return false;
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
        int j = 0;
        for (serVivo i : animales) {
            if (i.raza.equals(raza)) {
                j++;
            }
        }
        return j;
    }

    public int contarKYP() {
        int j = 0;
        for (serVivo i : animales) {
            if (i instanceof kyp) {
                j = j + ((kyp) i).num;
            }
        }
        return j;
    }
}
