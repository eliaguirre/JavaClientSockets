/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.Observer;

import cliente.Cliente;
import cliente.Decorador.Mensaje;
import cliente.*;
import cliente.Decorador.Componente;
import cliente.fachada.Linea;
import java.awt.Component;
import java.util.Observable;
import java.util.Observer;

/**
 *
 */
public class MensajeRecibido implements Observer {

    Cliente cliente;

    public MensajeRecibido(Cliente c) {
        this.cliente = c;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Recibiendo");
        if (arg instanceof Linea) {
            Linea mensaje = (Linea) arg;
            System.out.println("Recibiendo");
            cliente.fachada.lienzo.addLine(mensaje);
        }
        if (arg instanceof Mensaje) {
            Mensaje mensaje = (Mensaje) arg;
            if (mensaje.getAccion() == "clear") {
                cliente.fachada.lienzo.clear();
            }
        }
    }
//
//    public String men(Mensaje mensaje) {
//        return mensaje.to + ": " + mensaje.getContenido();
//    }

}
