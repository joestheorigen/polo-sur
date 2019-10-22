
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author joest
 */
public class polo_Sur {
    
    ArrayList<serVivo> animales = new ArrayList<serVivo>();
    public void creaNuestroPolo(){
        
    }
    public void creaEsquimal(int min, int max){
        int n, i;                                               //en n ira el numero de esquimales que abra al principio, i es solo para explorar el for
        n = (int) Math.floor(Math.random()*(max-min+1)+min);    //metemos el numero de esquimales iniciales en n
        for(i=0;i<=n ;i++){
            //HAY QUE CREAR EL ESQUIMAL
            //Y DESPUÉS LO METEMOS EN ANIMALES
        }
    }
}
