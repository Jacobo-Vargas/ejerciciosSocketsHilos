package org.example;

import java.util.ArrayList;

public class Tuberia {

    private ArrayList<Character> buffer = new ArrayList<>(); // aqui se almacena las lanzadas

    int siguiente = 0;
//     este me ayuda a controlar tanto el lanzamiento como la recogida
//     es decir cuaando sea igual a 15 indica que el buffer esta lleno
//     cuando es 0 indica que esta vacío

    boolean estaVacio = true;
    boolean estaLleno = false;

    public synchronized char recoger() {

        while(estaVacio){ // en caso de estar vacio el buffer pone en espera al hiloActual es decir al consumidor
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }

        siguiente --;// cuando el buffer no esta vacío empieza a descontar lo que va recogiendo, asi cuando este en cero cambia la bandera
        if(siguiente == 0){
            estaVacio = true;
            estaLleno = false;
            notify(); // notifico a algun hilo que este esperando
        }

        return buffer.get(siguiente);

    }

    public synchronized void lanzar(char c){
        while(estaLleno){ // en caso de estar lleno el buffer se pone en espera el hilo actual
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }

        buffer.add(c); // de no estar lleno almacena un caracter en el buffer
        siguiente++; // suma uno a la cuenta para ir teniendo control de cuantos estan en buffer
        if(siguiente == 26){ // cuando existan 15 almacenados cambia las banderas de estado para garantizar que se empiezen a recoger
            estaLleno = true;
            estaVacio = false;
            try {
                wait(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            notify();// se notifica al hilo que este esperando
        }
    }

    public synchronized void lanzar2(char c){
        while(estaLleno){ // en caso de estar lleno el buffer se pone en espera el hilo actual
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }

        buffer.add(c); // de no estar lleno almacena un caracter en el buffer
        siguiente++; // suma uno a la cuenta para ir teniendo control de cuantos estan en buffer
        if(siguiente == 11){ // cuando existan 15 almacenados cambia las banderas de estado para garantizar que se empiezen a recoger
            estaLleno = true;
            estaVacio = false;
            notify();// se notifica al hilo que este esperando
        }



    }

    public ArrayList<Character> getBuffer() {
        return buffer;
    }

    public void setBuffer(ArrayList<Character> buffer) {
        this.buffer = buffer;
    }
}
