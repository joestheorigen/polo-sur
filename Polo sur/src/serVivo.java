import java.util.Random;

public class serVivo {

    int dia;
    int masaMuscular;
    float probReproducirse;
    float probMuerte;
    String raza;

    public serVivo(int dia, int masaM, float probRepro, float probM, String raza) {
        this.dia = dia;
        masaMuscular = masaM;
        probReproducirse = probRepro;
        probMuerte = probM;
        this.raza=raza;
    }

    public boolean muerteInesperada() {
        return Float.compare((float)Math.random(), probMuerte) <= 0;
    }

    public boolean reproducirse() {
        return Float.compare((float)Math.random(), probReproducirse) <= 0;
    }
}
