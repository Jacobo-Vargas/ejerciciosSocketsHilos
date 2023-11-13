package org.example;

public class Main {

    public static void main(String[] args) {

        Tuberia t = new Tuberia();
        ProductorUno productorUno = new ProductorUno(t);
      //  ProductorUno productorDos = new ProductorUno(t);
        Consumidor consumidor = new Consumidor(t);

        productorUno.start();
       // productorDos.start();
        consumidor.start();
    }
}
