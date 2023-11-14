package org.example;

public class Main {

    public static void main(String[] args) {

        Tuberia t = new Tuberia();
        ProductorUno productorUno = new ProductorUno(t);
        ProductorDos productorDos = new ProductorDos(t);
        ProductorTres productorTres = new ProductorTres(t);
        Consumidor consumidor = new Consumidor(t);

        productorUno.start();
        productorDos.start();
        productorTres.start();
        consumidor.start();
    }
}
