package org.example;

public class Consumidor extends Thread{

    Tuberia tuberia;

    public Consumidor(Tuberia t) {
        tuberia = t;
    }

    @Override
    public void run() {

        for (int i = 0; i < 13; i++) { // se repite 15 veces para
            char  c = tuberia.recoger(); // recoge un caracter
            char c1 = tuberia.recoger();
            System.out.println("se recogío: " + c+" y "+ c1);
            try {
                sleep(1000);// lo duerme una cantidad de milisegundos al azar
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
