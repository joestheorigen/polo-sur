
import java.io.Serializable;
import java.util.Random;

public class serVivo implements Serializable{

    int dia;
    int masaMuscular;
    float probReproducirse;
    float probMuerte;
    String raza;
    Random r;

    public serVivo(int dia, int masaM, float probRepro, float probM, String raza) { //crea un ser vivo
        this.dia = dia;
        masaMuscular = masaM;
        probReproducirse = probRepro;
        probMuerte = probM;
        this.raza=raza;
    }

    public boolean muerteInesperada() {                                         //devuelve true si toca muerte inesperada, en caso contrario devuelve false
        r = new Random();
        return Float.compare(r.nextFloat(), probMuerte) <= 0;
    }

    public boolean reproducirse() {                                             //devuelve true si le ha tocado reproducirse, en caso contrario devuelve false
        r = new Random();
        return Float.compare(r.nextFloat(), probReproducirse) <= 0;
    }
}
