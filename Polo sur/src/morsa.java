import java.util.Random;

public class morsa extends serVivo {

    public morsa(int dia, int masaM, float probRepro, float probM) {
        super(dia, masaM, probRepro, probM, "morsa");
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

    public int comerOsos() {        //lo hemos nerfeado porque comian mucho oso
        float i;
        Random r = new Random();
        i = r.nextFloat();
        if (i <= 0.80) {
            return 0;
        } else if (i <= 0.95) {
            return 1;
        } else {
            return 2;
        }
    }
    public String toString(){
        return "Morsa nacido en el dia "+this.dia+" con masa "+this.masaMuscular;
    }
}
