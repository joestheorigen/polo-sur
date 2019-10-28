
import java.util.Random;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author joest
 */
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
        return "raza esquimal nacido en el dia "+this.dia+" con masa "+this.masaMuscular;
    }
}
