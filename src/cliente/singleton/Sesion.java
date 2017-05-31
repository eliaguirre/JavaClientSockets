/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.singleton;

import cliente.Decorador.Componente;
import cliente.Decorador.Mensaje;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sesion extends java.util.Observable implements Runnable {

    public final static int ESTADO_CONECTADO = 1;
    public final static int ESTADO_DESCONECTADO = 0;
    public final static int ESTADO_CONECTANDO = 2;

    public final static String ESTADO_CAMBIADO = "ESTADO_CAMBIADO";
    public final static String MENSAJE_RECIBIDO = "MENSAJE_RECIBIDO";
    private static Sesion instance;
    private Socket socket;//SOCKET INSTANCE VARIABLE
    private String host;
    private int puerto;
    private int estado = 0;
    private String usuario;
    private ObjectOutputStream request;
    private ObjectInputStream response;

    private Sesion() {
    }

    public synchronized static Sesion getInstance() {
        if (instance == null) {
            instance = new Sesion();
        }
        return instance;
    }

    public int getEstado() {
        return estado;
    }

    public void desconectar() {
        if (socket != null) {
            if (!socket.isClosed()) {
                try {
                    socket.close();
                    estado = ESTADO_DESCONECTADO;
                    this.request = null;
                    this.response = null;
                    this.setChanged();
                    notifyObservers(ESTADO_CAMBIADO);
                } catch (IOException ex) {
                    Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public boolean connect(String usuario, String host, int puerto) {
        this.host = host;
        this.usuario = usuario;
        this.puerto = puerto;
        try {
            socket = new Socket(this.host, this.puerto);
            socket.setKeepAlive(true);
            this.request = new ObjectOutputStream(socket.getOutputStream());
            this.response = new ObjectInputStream(socket.getInputStream());
            estado = ESTADO_CONECTADO;
            setChanged();
            notifyObservers(ESTADO_CAMBIADO);

            this.sendMensaje(new Mensaje("LOGIN", "SERVIDOR", usuario));
            Thread hilo = new Thread(this);
            hilo.start();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void sendMensaje(Componente mensaje) {
        try {
            request.writeObject(mensaje);
            request.flush();
            // request.close();
        } catch (IOException ex) {
            Logger.getLogger(Sesion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void run() {
        try {
            while (true) {
                Object r = response.readObject();
                if (r != null) {
                    Componente m = (Componente) r;
                    setChanged();
                    notifyObservers(m);
                }
            }
        } catch (Exception e) {
            this.desconectar();
            e.printStackTrace();//MOST LIKELY WONT BE AN ERROR, GOOD PRACTICE TO CATCH THOUGH
        }
    }
}
