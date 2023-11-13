package org.example;

import java.util.Random;

public class ProductorUno extends Thread{

    Tuberia tuberia;
    String abecedario = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public ProductorUno(Tuberia t) {
        tuberia = t;
    }

    @Override
    public void run() {

        for (int i = 0; i < 15; i++) { // lanza 15 letras al azar
            char c = abecedario.charAt(escogerLetra());
            if(tuberia.getBuffer().contains(c)){
                i--;
            }else{
                tuberia.lanzar(c);
                System.out.println("Se lanzo: " + c);
            }
        }


    }

    public int escogerLetra(){
        Random random = new Random();
        return random.nextInt(26);
    }
}
