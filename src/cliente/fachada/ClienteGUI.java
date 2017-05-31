/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.fachada;

import cliente.Cliente;
import cliente.Decorador.Colores;
import cliente.Decorador.Componente;
import cliente.Decorador.Decorador;
import cliente.Decorador.Fuentes;
import cliente.Decorador.Mensaje;
import cliente.Observer.MensajeRecibido;
import cliente.Observer.SessionChecker;
import cliente.singleton.Sesion;
import javax.swing.JOptionPane;
import sun.security.pkcs11.wrapper.Functions;

/**
 *
 * @author
 */
// esta es la clase fachada q permite majear toda la parte de GUI desde metodos mas simples
public class ClienteGUI {

    private Sesion sesion;
    private Cliente cliente;

    private String fuente;
    private String color;
    private String nombre;
    private int size;
    public Lienzo lienzo;

    public ClienteGUI(Cliente c) {
        sesion = Sesion.getInstance();
        cliente = c;
        // sesion.addObserver(new SessionChecker(cliente));
        sesion.addObserver(new MensajeRecibido(cliente));
        lienzo = new Lienzo(sesion);
    }

    public void iniciar() {
        nombre = "" + (int) (Math.random() * 1000 + 10);
        String ip = JOptionPane.showInputDialog("Ingresa la ip a conectar");
        sesion.connect(nombre, ip, 6579);
        cliente.setTitle("usuario: id/" + nombre);
    }

    public void sendMensaje(String msj) {
        Componente m;
        if (nombre.equalsIgnoreCase("juan")) {
            m = new Mensaje("Jhon", msj);
        } else {
            m = new Mensaje("Juan", msj);
        }
        if (fuente != null) {
            m = new Fuentes(m, fuente, size);
        }
        if (color != null) {
            m = new Colores(m, color);
        }
        System.out.println(m);
        sesion.sendMensaje(m);
    }

    public void sendMensaje(Mensaje m) {
        sesion.sendMensaje(m);
    }

    public String getNombre() {
        return nombre;
    }

}
