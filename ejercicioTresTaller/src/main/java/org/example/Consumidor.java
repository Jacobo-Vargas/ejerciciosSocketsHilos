package org.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Consumidor extends Thread {

    String palabra = "uniquindio2023";
    ArrayList<Character> sobrantes = new ArrayList<>();

    char[] palabraArmada = new char[14];
    Tuberia tuberia;

    public Consumidor(Tuberia t) {
        tuberia = t;
    }

    @Override
    public void run() {
        boolean bandera = true;
        while (bandera) {
            try {
                char c = tuberia.recoger();
                char c1 = tuberia.recoger();
                System.out.println("Se recogío: " + c + " y " + c1);
                if(verificarLetra(c)){// se verifica si la letra esta contenida en la palabra que se desea armar
                    armarPalabra(c); // se asigna la letra a la posicion correspondiente
                    System.out.println(Arrays.toString(palabraArmada));
                }else{
                    sobrantes.add(c); // si no hace parte se guarda en un array
                }
                if(verificarPalabra()){
                    bandera = false;
                    System.out.println("Se armó la palabra.");
                }

                sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean verificarLetra(char c){
        return palabra.contains(c + ""); // retorna true si hace parte
    }

    public void armarPalabra(char c){ // metodo que ubica la letra en el espacio que le corresponde
        for (int i = 0; i < 14 ; i++) {
            if (c == palabra.charAt(i)) {
                palabraArmada[i] = c;
            }
        }
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
