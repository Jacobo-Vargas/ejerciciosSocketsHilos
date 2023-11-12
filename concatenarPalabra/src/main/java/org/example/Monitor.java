package org.example;


import javax.swing.*;

public class Monitor {
    String palabra;
    long tac;

    public Monitor() {
        palabra = JOptionPane.showInputDialog("Digite la palabra.");
        tac = System.currentTimeMillis();
    }

    public synchronized void ejecutarHilos() throws InterruptedException {

        while (System.currentTimeMillis() - tac < 1000) {
            notifyAll();
        }

    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public long getTac() {
        return tac;
    }

    public void setTac(long tac) {
        this.tac = tac;
    }
}
