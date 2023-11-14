package org.example;

import java.util.Random;

public class ProductorTres extends Thread{

    Tuberia tuberia;
    String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";
    public ProductorTres(Tuberia t) {
        tuberia = t;
    }

    @Override
    public void run() {
        boolean bandera = true;
        while (bandera) {
            try {
                char c = caracteres.charAt(random());
                if(esNumero(c)){ // si es numero enviela al buffer
                    if(tuberia.lanzar(c)){ // si lanzar retorna true detiene la ejecucion del while
                        bandera = false;
                    }
                    sleep(500);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean esNumero(char c){
        return Character.isDigit(c);
    }

    public int random() {
        Random random = new Random();
        return random.nextInt(36);
    }
}
