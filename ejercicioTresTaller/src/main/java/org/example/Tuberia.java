package org.example;

import java.util.ArrayList;

public class Tuberia {

    char[] buffer = new char[12];

    ArrayList<String> sobrantes = new ArrayList<>();

    String palabra = "uniquindio2023";
    char[] palabraArmada = new char[14];

    int posicion = 0;
    boolean lleno = false;
    boolean vacio = true;


    public synchronized boolean lanzar(char c) {
        while (lleno) { // si el bufer esta lleno que espere el hilo que esta lanzando
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }

        buffer[posicion] = c; // agrego el caracter entrante al buffer
        posicion++; // se aumenta la posicion del buffer

        if (posicion == 12) { // si el buffer se llena se deja lleno en true
            lleno = true;
        }
        vacio = false; // se cambio vacio a falso para que pueda empezar a recoger
        notify();

        return verificarPalabra();// retorna true si la palabra es completa
    }


    public synchronized char recoger() {
        while (vacio) { // si el bufer esta vacio se para el hilo
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Error");
            }
        }
        posicion--; // se decrementa ya que se va a recoger
        if(posicion == 0){ // si la posicion es 0 quiere decir que ya recogio
            vacio = true;
        }
        lleno = false;
        notify();
        return buffer[posicion]; // retorna el que se va a recoger
    }


    public boolean verificarPalabra() { // metodo para verificar si la palabra ya esta completa
        int verificacion = 0;
        for (int i = 0; i < 14; i++) {
            if (palabraArmada[i] == palabra.charAt(i)) {
                verificacion++;
            }
        }
        return verificacion == 14; // retorna true si es igual a 14
    }
}
