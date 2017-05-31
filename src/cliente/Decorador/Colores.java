/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.Decorador;


/**
 *
 * @author Fermyn
 */
public class Colores extends Decorador {

    String color;

    public Colores(Componente elemento, String color) {
        super(elemento);
        this.color = color;
    }

    @Override
    public String getContenido() {
        return "<font color=\"" + color + "\">" + elemento.getContenido() + "</font>"; //To change body of generated methods, choose Tools | Templates.
    }

}
