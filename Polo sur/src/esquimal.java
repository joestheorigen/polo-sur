import java.util.Random;

public class esquimal extends serVivo{
    public esquimal(int dia, int masaM, float probRepro, float probM){
        super(dia,masaM,probRepro,probM,"esquimal");
    }
    
    public int comerPeces(){
        float i;
        Random r = new Random();
        i=r.nextFloat();
            if(i<=0.33){
                return 2;
            }else if(i<=0.66){
                return 3;
            }else{
                return 4;
            }
    }
    
    public int comerFocas(){
        float i;
        Random r = new Random();
        i=r.nextFloat();
            if(i<=0.5){
                return 0;
            }else{
                return 1;
            }
    }
    public String toString(){
        return "Esquimal nacido en el dia "+this.dia+" con masa "+this.masaMuscular;
    }
}
