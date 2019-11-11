import java.util.Random;

public class foca extends serVivo {

    public foca(int dia, int masaM, float probRepro, float probM) {
        super(dia, masaM, probRepro, probM, "foca");
    }

    public int comerPeces() {
        float i;
        Random r = new Random();
        i = r.nextFloat();
        if (i <= 0.80) {
            return 15;
        } else if (i <= 0.85) {
            return 16;
        } else if (i <= 0.90) {
            return 17;
        } else if (i <= 0.93) {
            return 18;
        } else if (i <= 0.94) {
            return 19;
        } else if (i <= 0.95) {
            return 20;
        } else if (i <= 0.96) {
            return 21;
        } else if (i <= 0.97) {
            return 22;
        } else if (i <= 0.98) {
            return 23;
        } else if (i <= 0.99) {
            return 24;
        } else {
            return 25;
        }
    }
    public String toString(){
        return "Foca nacido en el dia "+this.dia+" con masa "+this.masaMuscular;
    }
}
