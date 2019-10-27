
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
public class oso extends serVivo{
    public oso(int dia, int masaM, float probRepro, float probM){
        super(dia,masaM,probRepro,probM,"oso");
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
    
    public int comerPeces(){
        float i;
        Random r = new Random();
        i=r.nextFloat();
            if(i<=0.16){
                return 10;
            }else if(i<=0.33){
                return 11;
            }else if(i<=0.5){
                return 12;
            }else if(i<=0.67){
                return 13;
            }else if(i<=0.83){
                return 14;
            }else{
                return 15;
            }
    }
    
}
