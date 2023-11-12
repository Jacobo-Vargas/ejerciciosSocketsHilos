package org.example;

import javax.swing.*;

public class Main {

    private static String palabra;

    public static void main(String[] args) throws InterruptedException {

        long tac = System.currentTimeMillis();
        boolean alternarHiloUno = true;


        while(System.currentTimeMillis() - tac < 20000){
                HiloUno hiloUno;
                HiloDos hiloDos;
                if (alternarHiloUno) {
                    hiloUno = new HiloUno();
                    hiloUno.start();
                    hiloUno.join();
                    palabra = hiloUno.getPalabra();

                } else {
                    hiloDos = new HiloDos();
                    hiloDos.setPalabra(palabra);
                    hiloDos.start();
                    hiloDos.join();
                }
                alternarHiloUno = !alternarHiloUno;
        }
    }
}