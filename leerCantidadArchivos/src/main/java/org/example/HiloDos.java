package org.example;

import javax.swing.*;
import java.io.IOException;

public class HiloDos extends Thread {
    private Monitor monitor;

    @Override
    public void run() {
        monitor.setPalabraABuscar(JOptionPane.showInputDialog("¿Que palabra desea buscar?"));
        monitor.leerArchivo();
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }
}
