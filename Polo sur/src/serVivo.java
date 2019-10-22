/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalDate;

/**
 *
 * @author joest
 */
public class serVivo {

    LocalDate fechaNacimiento;
    double masaMuscular;
    double probReproducirse;
    double probMuerte;
    int comidaNecesaria;
    double random;

    public serVivo(LocalDate fechaN, double masaM, double probRepro, double probM, int comidaN) {
        fechaNacimiento = fechaN;
        masaMuscular = masaM;
        probReproducirse = probRepro;
        probMuerte = probM;
        comidaNecesaria = comidaN;

    }

    public boolean muerteInesperada() {
        random = Math.random() * 1000;
        if (random <= probMuerte) {
            return true;
        } else {
            return false;
        }
    }

    public boolean reproducirse() {
        random = Math.random() * 1000;
        if (random <= probReproducirse) {
            return true;
        } else {
            return false;
        }
    }

}
