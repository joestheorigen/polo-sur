import java.util.Random;

public class pez extends serVivo {

    public pez(int dia, int masaM, float probRepro, float probM, String tipo) {
        super(dia, masaM, probRepro, probM, tipo);
    }

    public int comerKrillPlankton() {
        float i;
        Random r = new Random();
        i = r.nextFloat();
        if (i <= 0.5) {
            return 1;   //seria como comer 1000000
            //return 1000000;
        } else {
            return 2;   //seria como comer 2000000
            //return 2000000;
        }
    }
    public String toString(){
        return "Pez nacido en el dia "+this.dia+" con masa "+this.masaMuscular+", de raza en especifica "+this.raza;
    }
}
