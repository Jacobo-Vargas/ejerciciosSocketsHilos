package org.example;

public class HiloDos extends Thread {

    String palabra;

    @Override
    public void run() {

        palabra = "";
        System.out.println(palabra);
        System.out.println("Se borró");

    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
