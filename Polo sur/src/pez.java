
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
public class pez extends serVivo{
    String tipo;
    public pez(int dia, int masaM, float probRepro, float probM, String tipo){
        super(dia,masaM,probRepro,probM,tipo);
        this.tipo=tipo;
    }
    
    public int comerFocas(){
        float i;
        Random r = new Random();
        i=r.nextFloat();
            if(i<=0.5){
                return 1000000;
            }else{
                return 2000000;
            }
    }
}
