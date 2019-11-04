
import java.util.Random;

public class serVivo {

    int dia;
    int masaMuscular;
    float probReproducirse;
    float probMuerte;
    String raza;
    Random r;

    public serVivo(int dia, int masaM, float probRepro, float probM, String raza) {
        this.dia = dia;
        masaMuscular = masaM;
        probReproducirse = probRepro;
        probMuerte = probM;
        this.raza=raza;
    }

    public boolean muerteInesperada() {
        r = new Random();
        return Float.compare(r.nextFloat(), probMuerte) <= 0;
    }

    public boolean reproducirse() {
        r = new Random();
        return Float.compare(r.nextFloat(), probReproducirse) <= 0;
    }
}
