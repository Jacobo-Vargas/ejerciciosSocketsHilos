package org.example;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Monitor monitor = new Monitor();

        HiloUno hiloUno = new HiloUno();
        HiloDos hiloDos = new HiloDos();

        hiloUno.setMonitor(monitor);
        hiloDos.setMonitor(monitor);

        System.out.println("Ejecutando los hilos...");
        hiloUno.start();
        hiloDos.start();
        System.out.println("Esperando a que terminen...");
        hiloUno.join();
        hiloDos.join();
    }
}