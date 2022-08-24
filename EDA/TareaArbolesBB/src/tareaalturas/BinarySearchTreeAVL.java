/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalturas;

import tareaarbolesbb.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author memit
 */
public class BinarySearchTreeAVL<T extends Comparable<T>> implements BinarySearchTreeADT<T> {
    NodoBBB<T> raiz;
    int cont;

    public BinarySearchTreeAVL() {
        raiz = null;
        cont = 0;
    }

    public BinarySearchTreeAVL(T elem) {
        raiz = new NodoBBB(elem);
        cont = 1;
    }
    public T getRaiz(){
        return raiz.elem;
    }
    public boolean isEmpty() {
        return cont == 0;
    }

    public int size() {
        return cont;
    }
    
    public Iterator<T> preOrden() {
        ArrayList<T> lista = new ArrayList();
        preOrden(raiz, lista);
        return lista.iterator();
    }

    private void preOrden(NodoBBB<T> actual, ArrayList<T> lista) {
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

    private void inOrden(NodoBBB<T> actual, ArrayList<T> lista) {
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

    private void postOrden(NodoBBB<T> actual, ArrayList<T> lista) {
        if (actual == null) {
            return;
        }
        postOrden(actual.getIzq(), lista);
        postOrden(actual.getDer(), lista);
        lista.add(actual.getDato());//esto fue visitar
    }
    
    public boolean find(T elem) {
        return find(elem, raiz) != null;
    }

    private NodoBBB<T> find(T elem, NodoBBB<T> hoja) {
        if (hoja == null || hoja.elem.equals(elem)) {
            return hoja;
        }
        if (hoja.elem.compareTo(elem) > 0) {
            return find(elem, hoja.izq);
        } else {
            return find(elem, hoja.der);
        }
    }
    
    public int altura() {
        if (raiz == null) {
            return 0; //-1?
        }
        return altura(raiz); // ¿-1?
    }

    private int altura(NodoBBB<T> actual) {
        if (actual == null) {
            return 0;
        }
        else{
            switch(actual.getFe()){
                case -1:
                case -2:
                    return 1+altura(actual.getIzq());
                case 1:
                case 2:
                default:
                    return 1+altura(actual.getDer());
            }
        }
    }
 
    public void add(T elem) {
        NodoBBB<T> nuevo = new NodoBBB(elem);
        if (this.isEmpty()) {
            raiz = nuevo;
        } else {
            add(nuevo, raiz);
            balancearAdd(nuevo, nuevo.papa);
        }
        cont++;
    }

    private void add(NodoBBB<T> nuevo, NodoBBB<T> actual) {
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
    
    private NodoBBB<T> rotar(NodoBBB<T> actual) {
        NodoBBB<T> papa, alfa, beta, gamma, A, B, C, D;
        if (actual.getFe() == -2 && actual.getIzq().getFe() == 1) {//rotacion izq -der}
            alfa = actual;
            papa = alfa.getPapa();
            beta = alfa.getIzq();
            gamma = beta.getDer();
//            A = beta.getIzq();
            B = gamma.getIzq();
            C = gamma.getDer();
//            D = alfa.getDer();

//            beta.setIzq(A);
            beta.setDer(B);
            alfa.setIzq(C);
//            alfa.setDer(D);
            gamma.setIzq(beta);
            gamma.setDer(alfa);
            if (papa == null) {
                raiz = gamma;
                gamma.papa = null;
            } else {
                papa.cuelga(gamma);
            }

            if (gamma.getFe() == -1) {
                beta.setFe(0);
                alfa.setFe(1);
                gamma.setFe(-1);
            } else if (gamma.getFe() == 1) {
                beta.setFe(-1);
                alfa.setFe(0);
                gamma.setFe(1);
            } else {//es cero
                beta.setFe(0);
                alfa.setFe(0);
                gamma.setFe(0);
            }
            return gamma;
        } else if(actual.getFe() == -2 && actual.getIzq().getFe() <= 0){//rotacion izq-izq
            alfa = actual;
            papa = alfa.getPapa();
            beta = alfa.getIzq();
            gamma = beta.getIzq();
//            A = gamma.getIzq();
//            B = gamma.getDer();
            C = beta.getDer();
//            D = alfa.getDer();
            
//            gamma.setDer(B);
//            gamma.setIzq(A);
            alfa.setIzq(C);
//            alfa.setDer(D);
            beta.setIzq(gamma);
            beta.setDer(alfa);
            if (papa == null) {
                raiz = beta;
                beta.papa = null;
            } else {
                papa.cuelga(beta);
            }
            
            beta.setFe(0);
            alfa.setFe(0);
            //fe de gamma queda igual
            return beta;
        } else if (actual.getFe() == 2 && actual.getDer().getFe() == -1) { // rot der-izq
            alfa = actual;
            papa = alfa.getPapa();
            beta = alfa.getDer();
            gamma = beta.getIzq();
//            A = alfa.getIzq();
            B = gamma.getIzq();
            C = gamma.getDer();
//            D = beta.getDer();

            beta.setIzq(C);
//            beta.setDer(D);
            alfa.setDer(B);
//            alfa.setIzq(A);
            gamma.setIzq(alfa);
            gamma.setDer(beta);
            if (papa == null) {
                raiz = gamma;
                gamma.papa = null;
            } else {
                papa.cuelga(gamma);
            }
            
            if (gamma.getFe() == -1) {
                beta.setFe(1);
                alfa.setFe(0);
                gamma.setFe(-1);
            } else if (gamma.getFe() == 1) {
                beta.setFe(0);
                alfa.setFe(-1);
                gamma.setFe(1);
            } else {//es cero
                beta.setFe(0);
                alfa.setFe(0);
                gamma.setFe(0);
            }
            return gamma;
        } else if(actual.getFe() == 2 && actual.getDer().getFe() >=0){ //rotacion der-der
            alfa = actual;
            papa = alfa.getPapa();
            beta = alfa.getDer();
            gamma = beta.getDer();
//            A = alfa.getIzq();
            B = beta.getIzq();
//            C = gamma.getIzq();
//            D = gamma.getDer();
            
//            gamma.setDer(D);
//            gamma.setIzq(C);
//            alfa.setIzq(A);
            alfa.setDer(B);
            beta.setIzq(alfa);
            beta.setDer(gamma);
            if (papa == null) {
                raiz = beta;
                beta.papa = null;
            } else {
                papa.cuelga(beta);
            }
            
            beta.setFe(0);
            alfa.setFe(0);
            //fe de gamma queda igual
            return beta;
        }
        return actual;
    }
    
    private void balancearAdd(NodoBBB<T> actualHijo, NodoBBB<T> actual){
        if(actual.izq == actualHijo)
            actual.fe--;
        else
            actual.fe++;
        if(Math.abs(actual.getFe()) == 2){
            actual = rotar(actual);
        }
        if(actual==raiz || actual.fe==0)
            return;
        balancearAdd(actual, actual.papa);
    }
    
    public void borra (T elem){
        NodoBBB<T> actual = find(elem, raiz);
        if (actual == null)
            return;
        if (actual.der == null && actual.izq == null) {//caso hoja 
            actual= eliminaHoja(actual);
        } else if (actual.der == null) {//un solo hijo
            actual= eliminaConHijoIzq(actual);
        } else if (actual.izq == null) {
            actual= eliminaConHijoDer(actual);
        } else { //dos hijos
            actual= eliminaDosHijos(actual);
        }
        cont--;
        if (actual.papa != null)
            balanceaBorra(actual, actual.papa);
    }
    private void balanceaBorra(NodoBBB<T> actualHijo, NodoBBB<T> actual){
        int feAnterior = actual.fe;
        //no puede usarse actual.izq==actualHijo porque la primera vez ese enlace se borró
        if (actualHijo.elem.compareTo(actual.elem)<=0) //viene por izquierda
            actual.fe++;
        else //vengo de derecha
            actual.fe--;
        if(Math.abs(actual.fe) == 2)
            actual = rotar(actual);
        if(actual == raiz || feAnterior == 0)
            return;
        balanceaBorra(actual, actual.getPapa());
    }
    private NodoBBB<T> eliminaHoja(NodoBBB<T> actual) {
        if (actual == raiz) {
            raiz = null;
            return actual;
        }
        if (actual.papa.der == actual) {
            actual.papa.setDerNull();
        } else {
            actual.papa.setIzqNull();
        }
        return actual;
    }

    private NodoBBB<T> eliminaConHijoDer(NodoBBB<T> actual) {
        NodoBBB<T> hijo = actual.der;
        if (actual == raiz) {
            raiz = hijo;
            actual.setDerNull();
            raiz.papa=null;
        }
        else
            actual.papa.cuelga(hijo);
        return actual;
    }

    private NodoBBB<T> eliminaConHijoIzq(NodoBBB<T> actual) {
        NodoBBB<T> hijo = actual.izq;
        if (actual == raiz) {
            raiz = hijo;
            raiz.papa=null;
            actual.setIzqNull();
        }else
            actual.papa.cuelga(hijo);
        return actual;
    }

    private NodoBBB<T> eliminaDosHijos(NodoBBB<T> actual) {
        NodoBBB<T> sucInorden = actual.getDer();
        while (sucInorden.getIzq() != null) 
            sucInorden = sucInorden.getIzq();
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
        return sucInorden.der;
    }
}
