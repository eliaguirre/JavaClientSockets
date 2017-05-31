/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.Decorador;

/**
 *
 */
public abstract class Decorador extends Componente {

    protected Componente elemento;

    public Decorador(Componente elemento) {
        this.elemento = elemento;
    }

    public Componente getComponente() {
        return elemento;
    }

}
