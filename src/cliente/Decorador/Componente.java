/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.Decorador;

import java.io.Serializable;

/**
 *
 * @author 
 */
public abstract class Componente implements Serializable {

    protected String contenido;

    public String getContenido() {
        return contenido;
    }
}
