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
            if(tuberia.getBuffer().contains(c)){ // verifica que la letra ya no este en el buffer de ser asi invalida ese ciclo y lo reinicia
                i--;
            }else{
                tuberia.lanzar(c); // lanzo un caracter
                System.out.println("Se lanzo: " + c);
                try {
                    sleep((int) (Math.random() *100 ));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }

    public int escogerLetra(){ // me da un numero al azar de 1 a 26
        Random random = new Random();
        return random.nextInt(26);
    }
}
