/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalturas;

import tareaarbolesbb.*;

/**
 *
 * @author memit
 */
public class NodoBB<T extends Comparable<T>> {

    NodoBB<T> izq;

    NodoBB<T> der, papa;
    T elem;

    public NodoBB(T elem) {
        this.elem = elem;
        papa = null;
        izq = null;
        der = null;
    }

    public void cuelga(NodoBB<T> hijo) {
        if (hijo.elem.compareTo(elem) <= 0) 
            izq = hijo;
         else 
            der = hijo;
        hijo.papa = this;            
    }
    public NodoBB<T> getIzq() {
        return izq;
    }

    public NodoBB<T> getDer() {
        return der;
    }

    public NodoBB<T> getPapa() {
        return papa;
    }

    void setDer(NodoBB<T> hijo) {
        this.der=hijo;
        if(hijo!=null)
            hijo.papa=this;
    }

    void setIzq(NodoBB<T> hijo) {
        this.izq=hijo;
        if(hijo!=null)
            hijo.papa=this;
    }

    public void setDato(T elemento) {
        this.elem = elemento;
    }

    public T getDato() {
        return elem;
    }
    void setDerNull() {
        der = null;
    }

    void setIzqNull() {
        izq = null;
    }
}
