import java.util.Random;

public class pez extends serVivo {

    String tipo;

    public pez(int dia, int masaM, float probRepro, float probM, String tipo) {
        super(dia, masaM, probRepro, probM, tipo);
        this.tipo = tipo;
    }

    public int comerFocas() {
        float i;
        Random r = new Random();
        i = r.nextFloat();
        if (i <= 0.5) {
            return 1000000;
        } else {
            return 2000000;
        }
    }
    public String toString(){
        return "raza pez nacido en el dia "+this.dia+" con masa "+this.masaMuscular+", de raza en especifica "+this.tipo;
    }
}
