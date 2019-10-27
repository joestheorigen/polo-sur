
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
public class morsa extends serVivo{
    public morsa(int dia, int masaM, float probRepro, float probM){
        super(dia,masaM,probRepro,probM,"morsa");
    }
    
    public int comerFocas(){
        float i;
        Random r = new Random();
        i=r.nextFloat();
            if(i<=0.5){
                return 1;
            }else{
                return 2;
            }
    }
    
    public int comerOsos(){
        float i;
        Random r = new Random();
        i=r.nextFloat();
            if(i<=0.33){
                return 0;
            }else if(i<=0.66){
                return 1;
            }else{
                return 2;
            }
    }
}
