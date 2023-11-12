package org.example;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;

public class Monitor {

    /**
     * el monitor debe controlar que hilo entra y que lea los archivos del directorio
     */

    private String palabraABuscar;
    private int palabrasEncontradas;
    private String RUTA_ARCHIVOS = "/home/jacobo/Documentos/GitHub/ejerciciosSocketsHilos/leerCantidadArchivos/src/main/resources/archivos";

    public synchronized void leerArchivo() {
        try {
            lectorArchivos();
            System.out.println("Encontro: " + palabrasEncontradas);
            palabrasEncontradas = 0;
            notify();


        } catch (IOException e) {
            System.out.println("error en el lector.");
        }
    }

    public void lectorArchivos() throws IOException {

        File carpeta = new File(RUTA_ARCHIVOS); // instancio la carpeta que voy a buscar

        if (carpeta.isDirectory()) { // me aseguro de que sea una carpeta
            File[] archivos = carpeta.listFiles(); // asigno los archivos de la carpeta en un array de archivos

            if (archivos != null) {   // si hay archivos entro a cada uno
                for (File a : archivos) {
                    leerContenido(a, palabraABuscar);    // llamo el metodo que lee las lineas que hay en el archivo
                }

            }
        } else {
            System.out.println("Ruta mala");
        }
    }

    private void leerContenido(File archivo, String palabra) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new FileReader(archivo)); // creo un lector
        String linea = "";
        while ((linea = bufferedReader.readLine()) != null) { // asigno y leo la linea siempre y cuando no este vacia

//            int indice = linea.indexOf(palabra); //devuelve -1 cuando no encuentra coincidencias
//
//            while (indice != -1) { // este while me garantiza cuantas veces se encuentra la palabra en la linea
//                palabrasEncontradas++;
//                indice = linea.indexOf(palabra, indice + 1);
//            }

            /*
             * lo anterior es para contar cuantas palabras en el archivo
             */
            if (linea.contains(palabra)) {
                palabrasEncontradas += 1;
            }
        }
    }

    public void setPalabraABuscar(String palabraABuscar) {
        this.palabraABuscar = palabraABuscar;
    }
}
