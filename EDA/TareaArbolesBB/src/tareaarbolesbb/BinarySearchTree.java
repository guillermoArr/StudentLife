/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaarbolesbb;

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
    private void cuentaBusca(T elem, Object[] res){
        NodoBB<T> hoja = raiz;
        int contAux = 2;
        while(hoja!=null && !hoja.elem.equals(elem)){
             contAux+=3;   
            if (hoja.elem.compareTo(elem) > 0)
                hoja=hoja.izq;
             else 
                hoja=hoja.der;
        }
        if(hoja==null)
            contAux--;
        res[0]=hoja;
        res[1]= contAux;
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

    public int longCaminoMayor() {
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

    public int add(T elem) {
        NodoBB<T> nuevo = new NodoBB(elem);
        int contComps = 1;
        if (this.isEmpty()) {
            raiz = nuevo;
        } else {
            contComps += add(nuevo, raiz, 0);
        }
        cont++;
        return contComps;
    }

    private int add(NodoBB<T> nuevo, NodoBB<T> actual, int contComps) {
        contComps++;
        if (nuevo.getDato().compareTo(actual.getDato()) <= 0) {
            contComps++;
            if (actual.izq == null) {
                actual.setIzq(nuevo);
            } else {
                return contComps + add(nuevo, actual.izq, 0);
            }
        } else {
            contComps++;
            if (actual.der == null) {
                actual.setDer(nuevo);
            } else {
                return contComps + add(nuevo, actual.der, 0);
            }
        }
        return contComps;
    }

    public int borra(T elem) {
        Object[] res = new Object[2];
        cuentaBusca(elem, res);
        NodoBB<T> actual = (NodoBB<T>)res[0];
        int contAux=1+(Integer)res[1];
        if (actual == null) {
            return contAux;
        }
        contAux+=3;
        if (actual.der == null && actual.izq == null) {//caso hoja 
            contAux--;
            contAux+= eliminaHoja(actual);
        } else if (actual.der == null) {//un solo hijo
            contAux+= eliminaConHijoIzq(actual);
        } else if (actual.izq == null) {
            contAux+= eliminaConHijoDer(actual);
        } else { //dos hijos
            contAux+= eliminaDosHijos(actual);
        }
        cont--;
        return contAux;
    }

    private int eliminaHoja(NodoBB<T> actual) {
        if (actual == raiz) {
            raiz = null;
            return 1;
        }
        if (actual.papa.der == actual) {
            actual.papa.setDerNull();
        } else {
            actual.papa.setIzqNull();
        }
        return 2;
    }

    private int eliminaConHijoDer(NodoBB<T> actual) {
        NodoBB<T> hijo = actual.der;
        if (actual == raiz) {
            raiz = hijo;
            actual.setDerNull();
            raiz.papa=null;
            return 1;
        }
        else{
            actual.papa.cuelga(hijo);
            return 2;
        }
    }

    private int eliminaConHijoIzq(NodoBB<T> actual) {
        NodoBB<T> hijo = actual.izq;
        if (actual == raiz) {
            raiz = hijo;
            raiz.papa=null;
            actual.setIzqNull();
            return 1;
        }else{
            actual.papa.cuelga(hijo);
            return 2;
        }
    }

    private int eliminaDosHijos(NodoBB<T> actual) {
        NodoBB<T> sucInorden = actual.getDer();
        int contAux=1;
        while (sucInorden.getIzq() != null) {
            contAux++;
            sucInorden = sucInorden.getIzq();
        }
        actual.setDato(sucInorden.getDato());
        contAux++;
        if (actual.getDer() == sucInorden) {//caso en que no avanza
            actual.der = sucInorden.der;
            contAux++;
            if (actual.der != null) {
                actual.der.papa = actual;
            }
        } else {
            sucInorden.papa.izq = sucInorden.der;
            contAux++;
            if (sucInorden.der != null) {
                sucInorden.der.papa = sucInorden.papa;
            }
        }
        return contAux;
    }

}
