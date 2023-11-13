package org.example;

import java.util.ArrayList;

public class Tuberia {

    private ArrayList<Character> buffer = new ArrayList<>();

    int siguiente = 0;

    boolean estaVacio = true;
    boolean estaLleno = false;

    public synchronized char recoger(){

        while(estaVacio){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
        siguiente --;

        if(siguiente == 0){
            estaVacio = true;
            estaLleno = false;

        }
        notify();
        return buffer.get(siguiente);

    }

    public synchronized void lanzar(char c){
        while(estaLleno){
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }

        buffer.add(c);
        siguiente++;
        if(siguiente == 15){
            estaLleno = true;
            estaVacio = false;
        }
        notify();


    }

    public ArrayList<Character> getBuffer() {
        return buffer;
    }

    public void setBuffer(ArrayList<Character> buffer) {
        this.buffer = buffer;
    }
}
