
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
public class foca extends serVivo{
    public foca(int dia, int masaM, float probRepro, float probM){
        super(dia,masaM,probRepro,probM,"foca");
    }
    
    public int comerPeces(){
        float i;
        Random r = new Random();
        i=r.nextFloat();
            if(i<=0.09){
                return 15;
            }else if(i<=0.18){
                return 16;
            }else if(i<=0.27){
                return 17;
            }else if(i<=0.36){
                return 18;
            }else if(i<=0.45){
                return 19;
            }else if(i<=0.54){
                return 20;
            }else if(i<=0.63){
                return 21;
            }else if(i<=0.72){
                return 22;
            }else if(i<=0.81){
                return 23;
            }else if(i<=0.9){
                return 24;
            }else{
                return 25;
            }
    }
}