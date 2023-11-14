package org.example;

import java.util.Random;

public class ProductorDos extends Thread{

    Tuberia tuberia;
    String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";
    public ProductorDos(Tuberia t) {
        tuberia = t;
    }

    @Override
    public void run() {
        boolean bandera = true;
        while (bandera) {
            try {
                char c = caracteres.charAt(random());
                if(esConsonante(c)){ // si es consonante enviela al buffer
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

    private boolean esConsonante(char c) {
        return !(esVocal(c) && esNumero(c));// retorna true si es consonante
    }

    public boolean esVocal (char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public boolean esNumero(char c){
        return Character.isDigit(c);
    }

    public int random() {
        Random random = new Random();
        return random.nextInt(36);
    }
}
