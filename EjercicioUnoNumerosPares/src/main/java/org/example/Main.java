package org.example;

public class Main {
    /*
     * Implemente un programa en java que use hilos.
     * Un hilo imprime números pares del 1 al 100, y otro hilo imprime números impares del 1 al 100.
     * Cree dos instancias (hilo 1 e hilo 2) de cada uno y muestre la salida.
     *
     * Sincronizar los hilos de tal forma que cada uno imprima 5 valores,
     * se detenga inicie el otro hilo y así sucesivamente.
     */
    static Monitor monitor = new Monitor();

    public static void main(String[] args) {



        Thread hiloUno = new Thread(() -> {
            try {
                monitor.imprimirImpares();
            } catch (InterruptedException e) {
                System.out.println("Error.");
            }

        });

        Thread hiloDos = new Thread(() -> {
            try {
                monitor.imprimirPares();
            } catch (InterruptedException e) {
                System.out.println("Error.");
            }
        });

        hiloUno.start();
        hiloDos.start();


    }
}