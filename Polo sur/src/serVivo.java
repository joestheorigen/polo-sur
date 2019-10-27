
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
public class serVivo {

    int dia;
    int masaMuscular;
    float probReproducirse;
    float probMuerte;
    int comidaNecesaria;
    String raza;
    Random random;

    public serVivo(int dia, int masaM, float probRepro, float probM, String raza) {
        this.dia = dia;
        masaMuscular = masaM;
        probReproducirse = probRepro;
        probMuerte = probM;
        this.raza=raza;
    }

    public boolean muerteInesperada() {
        if (random.nextFloat() <= probMuerte) {
            return true;
        } else {
            return false;
        }
    }

    public boolean reproducirse() {
        if (random.nextFloat() <= probReproducirse) {
            return true;
        } else {
            return false;
        }
    }
}
