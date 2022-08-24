/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaarbolesbb;

/**
 *
 * @author memit
 */
public class NodoBBB <T extends Comparable <T>>{
    NodoBBB<T> izq, der, papa;
    T elem;
    int fe;
    
    public NodoBBB(T elem) {
        this.elem = elem;
        papa = null;
        izq = null;
        der = null;
        fe = 0;
    }

    public void cuelga(NodoBBB<T> hijo) {
        if (hijo.elem.compareTo(elem) <= 0) 
            izq = hijo;
         else 
            der = hijo;
        hijo.papa = this;            
    }
    public NodoBBB<T> getIzq() {
        return izq;
    }

    public NodoBBB<T> getDer() {
        return der;
    }

    public NodoBBB<T> getPapa() {
        return papa;
    }
    
    public int getFe(){
        return fe;
    }
    
    public void setFe(int fe){
        this.fe = fe;
    }
    public void setDer(NodoBBB<T> hijo) {
        this.der=hijo;
        hijo.papa=this;
    }

    public void setIzq(NodoBBB<T> hijo) {
        this.izq=hijo;
        hijo.papa=this;
    }

    public void setDato(T elemento) {
        this.elem = elemento;
    }

    public T getDato() {
        return elem;
    }
    public void setDerNull() {
        der = null;
    }

    public void setIzqNull() {
        izq = null;
    }
    
    public void incrementaFe(){
      fe++;
    }
  
    public void decrementaFe(){
      fe--;
    }
    
}
