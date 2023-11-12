package org.example;

public class Monitor {

    private int numeroPar;
    private int numeroImpar;

    private int impresiones;

    public Monitor() {
        numeroPar = 2;
        numeroImpar = 1;
    }

    synchronized void imprimirPares() throws InterruptedException {

        while (numeroPar <= 100) {
            while(impresiones < 5){
                if (numeroPar % 2 != 0) {
                    numeroPar += 1;
                    System.out.println(numeroPar);
                }else {
                    System.out.println(numeroPar);
                    numeroPar += 2;
                }
                impresiones++;
            }
            impresiones = 0;
            wait(500);
            notify();
        }
    }

    synchronized void imprimirImpares() throws InterruptedException {
        while (numeroImpar < 100) {
            while(impresiones < 5){
                if (numeroImpar % 2 != 0) {
                    System.out.println(numeroImpar);
                    numeroImpar += 2;
                }
                impresiones++;
            }
            impresiones = 0;
            wait(500);
            notify();
        }
    }
}