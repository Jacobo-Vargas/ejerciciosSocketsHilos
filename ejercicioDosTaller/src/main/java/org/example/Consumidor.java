package org.example;

public class Consumidor extends Thread{

    Tuberia tuberia;

    public Consumidor(Tuberia t) {
        tuberia = t;
    }

    @Override
    public void run() {

        for (int i = 0; i < 15; i++) {
            char  c = tuberia.recoger();
            System.out.println("se recogío: " + c);
            try {
                sleep((int) (Math.random()*200));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
