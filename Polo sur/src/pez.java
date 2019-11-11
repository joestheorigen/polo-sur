import java.util.Random;

public class pez extends serVivo {
    
    String tipo;
    public pez(int dia, int masaM, float probRepro, float probM, String tipo) {
        super(dia, masaM, probRepro, probM, "pez");
        this.tipo=tipo;
    }

    public int comerKrillPlankton() {
        float i;
        Random r = new Random();
        i = r.nextFloat();
        if (i <= 0.5) {
            return 1;
        } else {
            return 2;
        }
    }
    public String toString(){
        return "Pez nacido en el dia "+this.dia+" con masa "+this.masaMuscular+", de raza en especifica "+this.tipo;
    }
}
