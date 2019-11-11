import java.util.Random;

public class oso extends serVivo {

    public oso(int dia, int masaM, float probRepro, float probM) {
        super(dia, masaM, probRepro, probM, "oso");
    }

    public int comerFocas() {
        float i;
        Random r = new Random();
        i = r.nextFloat();
        if (i <= 0.5) {
            return 1;
        } else {
            return 2;
        }
    }

    public int comerPeces() {
        float i;
        Random r = new Random();
        i = r.nextFloat();
        if (i <= 0.80) {
            return 10;
        } else if (i <= 0.85) {
            return 11;
        } else if (i <= 0.90) {
            return 12;
        } else if (i <= 0.92) {
            return 13;
        } else if (i <= 0.95) {
            return 14;
        } else {
            return 15;
        }
    }
    public String toString(){
        return "Oso polar nacido en el dia "+this.dia+" con masa "+this.masaMuscular;
    }
}
