/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalturas;

import tareaarbolesbb.*;
import java.util.*;

/**
 *
 * @author memit
 */
public class BinarySearchTree<T extends Comparable<T>> implements BinarySearchTreeADT<T> {

    NodoBB<T> raiz;
    int cont;

    public BinarySearchTree() {
        raiz = null;
        cont = 0;
    }

    public BinarySearchTree(T elem) {
        raiz = new NodoBB(elem);
        cont = 1;
    }

    public boolean isEmpty() {
        return cont == 0;
    }

    public int size() {
        return cont;
    }

    public boolean find(T elem) {
        return find(elem, raiz) != null;
    }

    private NodoBB<T> find(T elem, NodoBB<T> hoja) {
        if (hoja == null || hoja.elem.equals(elem)) {
            return hoja;
        }
        if (hoja.elem.compareTo(elem) > 0) {
            return find(elem, hoja.izq);
        } else {
            return find(elem, hoja.der);
        }
    }
    public Iterator<T> preOrden() {
        ArrayList<T> lista = new ArrayList();
        preOrden(raiz, lista);
        return lista.iterator();
    }

    private void preOrden(NodoBB<T> actual, ArrayList<T> lista) {
        if (actual == null) {
            return;
        }
        lista.add(actual.getDato());//esto fue visitar
        preOrden(actual.izq, lista);
        preOrden(actual.der, lista);

    }

    public Iterator<T> inOrden() {
        ArrayList<T> lista = new ArrayList();
        inOrden(raiz, lista);
        return lista.iterator();
    }

    private void inOrden(NodoBB<T> actual, ArrayList<T> lista) {
        if (actual == null) {
            return;
        }
        inOrden(actual.getIzq(), lista);
        lista.add(actual.getDato());//esto fue visitar
        inOrden(actual.der, lista);
    }

    public Iterator<T> postOrden() {
        ArrayList<T> lista = new ArrayList();
        postOrden(raiz, lista);
        return lista.iterator();
    }

    private void postOrden(NodoBB<T> actual, ArrayList<T> lista) {
        if (actual == null) {
            return;
        }
        postOrden(actual.getIzq(), lista);
        postOrden(actual.getDer(), lista);
        lista.add(actual.getDato());//esto fue visitar
    }

    public int altura() {
        if (raiz == null) {
            return 0; //-1?
        }
        return altura(raiz); // ¿-1?
    }

    private int altura(NodoBB<T> actual) {
        if (actual == null) {
            return 0;
        }
        return 1 + Math.max(altura(actual.izq), altura(actual.der));
    }

    public void add(T elem) {
        NodoBB<T> nuevo = new NodoBB(elem);
        if (this.isEmpty()) {
            raiz = nuevo;
        } else {
            add(nuevo, raiz);
        }
        cont++;
    }

    private  void add(NodoBB<T> nuevo, NodoBB<T> actual) {
        if (nuevo.getDato().compareTo(actual.getDato()) <= 0) {
            if (actual.izq == null) {
                actual.setIzq(nuevo);
            } else {
                add(nuevo, actual.izq);
            }
        } else {
            if (actual.der == null) {
                actual.setDer(nuevo);
            } else {
                add(nuevo, actual.der);
            }
        }
    }

    public void borra(T elem) {
        NodoBB<T> actual = find(elem, raiz);
        if (actual == null) {
            return;
        }
        if (actual.der == null && actual.izq == null) {//caso hoja 
            eliminaHoja(actual);
        } else if (actual.der == null) {//un solo hijo
            eliminaConHijoIzq(actual);
        } else if (actual.izq == null) {
            eliminaConHijoDer(actual);
        } else { //dos hijos
            eliminaDosHijos(actual);
        }
        cont--;
    }

    private NodoBB<T> eliminaHoja(NodoBB<T> actual) {
        if (actual == raiz) {
            raiz = null;
            return raiz;
        }
        if (actual.papa.der == actual) {
            actual.papa.setDerNull();
        } else {
            actual.papa.setIzqNull();
        }
        return actual;
    }

    private NodoBB<T> eliminaConHijoDer(NodoBB<T> actual) {
        NodoBB<T> hijo = actual.der;
        if (actual == raiz) {
            raiz = hijo;
            actual.setDerNull();
            raiz.papa=null;
        }
        else{
            actual.papa.cuelga(hijo);
        }
        return hijo;
    }

    private NodoBB<T> eliminaConHijoIzq(NodoBB<T> actual) {
        NodoBB<T> hijo = actual.izq;
        if (actual == raiz) {
            raiz = hijo;
            raiz.papa=null;
            actual.setIzqNull();
        }else{
            actual.papa.cuelga(hijo);
        }
        return hijo;
    }

    private NodoBB<T> eliminaDosHijos(NodoBB<T> actual) {
        NodoBB<T> sucInorden = actual.getDer();
        while (sucInorden.getIzq() != null) {
            sucInorden = sucInorden.getIzq();
        }
        actual.setDato(sucInorden.getDato());
        if (actual.getDer() == sucInorden) {//caso en que no avanza
            actual.der = sucInorden.der;
            if (actual.der != null) {
                actual.der.papa = actual;
            }
        } else {
            sucInorden.papa.izq = sucInorden.der;
            if (sucInorden.der != null) {
                sucInorden.der.papa = sucInorden.papa;
            }
        }
        return sucInorden;
    }

}
