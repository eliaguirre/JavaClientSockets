/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.Observer;

import cliente.singleton.Sesion;
import java.util.Observable;
import java.util.Observer;

/**
 *
 */
public class SessionChecker implements Observer {

    public SessionChecker() {
    }

    
    
    
    @Override
    public void update(Observable o, Object arg) {
        Sesion s = Sesion.getInstance();
        if (arg.equals(Sesion.ESTADO_CAMBIADO)) {
            switch (s.getEstado()) {
                case Sesion.ESTADO_CONECTADO:
                    System.out.println("Conectado");
                    break;
                case Sesion.ESTADO_DESCONECTADO:
                    System.out.println("Desconectado");
            }
        }
    }

}
