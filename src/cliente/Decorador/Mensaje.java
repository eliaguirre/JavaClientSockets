/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.Decorador;

import java.io.Serializable;

public class Mensaje extends Componente  {

    public String to;
    private String accion;

    public Mensaje(String to, String msj) {
        this("chat", to, msj);
    }

    public Mensaje(String accion, String to, String msj) {
        this.accion = accion;
        this.to = to;
        super.contenido = msj;
        
    }


    public String getAccion() {
        return accion;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "to=" + to + ", accion=" + accion + ", contenido=" + contenido + "}";
    }

}
