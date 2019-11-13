
import java.io.Serializable;
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
public class lista implements Serializable{
    ArrayList animales = new ArrayList();
    double temperatura;
    int dia;
    boolean calentado;
    boolean cazado;
    boolean terremoto;
    boolean guerra;
    
    public lista(polo_Sur p){
        animales=p.animales;
        temperatura=p.temperatura;
        dia=p.dia;
        calentado=p.calentado;
        cazado=p.cazado;
        terremoto=p.terremoto;
        guerra=p.guerra;
    }
}
