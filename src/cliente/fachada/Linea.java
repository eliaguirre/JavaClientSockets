/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente.fachada;

import cliente.Decorador.Componente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author felix
 */
public class Linea extends Componente implements Serializable, List<Punto> {

    private ArrayList<Punto> puntos = new ArrayList<>();

    @Override
    public int size() {
        return puntos.size();
    }

    @Override
    public boolean isEmpty() {

        return puntos.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return false;

    }

    @Override
    public Iterator<Punto> iterator() {
        return puntos.iterator();
    }

    @Override
    public Object[] toArray() {
        return null;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Punto e) {
        return puntos.add(e);
    }

    @Override
    public boolean remove(Object o) {

        return puntos.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Punto> c) {

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Punto> c) {

        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {

        return false;
    }

    @Override
    public void clear() {
        puntos.clear();
    }

    @Override
    public Punto get(int index) {
        return puntos.get(index);
    }

    @Override
    public Punto set(int index, Punto element) {
        return null;
    }

    @Override
    public void add(int index, Punto element) {
    }

    @Override
    public Punto remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int lastIndexOf(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<Punto> listIterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ListIterator<Punto> listIterator(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Punto> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
