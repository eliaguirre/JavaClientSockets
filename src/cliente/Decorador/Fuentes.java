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
public class Fuentes extends Decorador {

    String font;
    int size;

    public Fuentes(Componente elemento, String font_family, int size) {
        super(elemento);
        font = font_family;
        this.size = size;
    }

    @Override
    public String getContenido() {
        return "<font size=\"" + size + "\"  face=\"" + font + "\"   >" + elemento.getContenido() + "</font>"; //To change body of generated methods, choose Tools | Templates.
    }

}
