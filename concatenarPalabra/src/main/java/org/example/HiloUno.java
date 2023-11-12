package org.example;


import javax.swing.*;

public class HiloUno extends Thread {

    String palabra;

    @Override
    public void run() {

        palabra = JOptionPane.showInputDialog("Digite la palabra");
        long tac = System.currentTimeMillis(); // contador de inicio7
        while (System.currentTimeMillis() - tac < 20) {
            palabra += palabra;
            System.out.println(palabra);
            System.out.println("--------------------------------------------");
        }
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
