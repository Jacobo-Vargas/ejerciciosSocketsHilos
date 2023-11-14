package org.example;

import java.util.Random;

public class ProductorUno extends Thread {

    Tuberia tuberia;
    String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";
    public ProductorUno(Tuberia t) {
        tuberia = t;
    }

    @Override
    public void run() {
        boolean bandera = true;
        while (bandera) {
            try {
                char c = caracteres.charAt(random());
                if(esVocal(c)){ // si es vocal enviela al buffer
                    if(tuberia.lanzar(c)){ // si lanzar retorna true detiene la ejecucion del while
                        System.out.println("Se lanzo vocal: " + c);
                        bandera = false;
                    }
                    sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public boolean esVocal (char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int random() {
        Random random = new Random();
        return random.nextInt(37);
    }

}