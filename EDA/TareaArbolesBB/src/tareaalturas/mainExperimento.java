/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalturas;

import java.util.*;

/**
 *
 * @author memit
 */
public class mainExperimento {
    /**
     * @param args the command line arguments
     */
    public static void creaArbolRandom(BinarySearchTreeADT<Double> arbol, int n){
        Double elem;
        Random rand = new Random();
        for(int i = 1; i<=n; i++){
            elem = rand.nextInt(100000) + rand.nextDouble();
            arbol.add(elem);
        }
    }
    public static void main(String[] args) {
        //PRUEBAS
        BinarySearchTreeADT<Double> arbol = new BinarySearchTree();
        BinarySearchTreeADT<Double> arbolAVL = new BinarySearchTreeAVL();
//        for(int i = 1; i<10; i++){
//            arbol.add((double)i);
//            arbolAVL.add((double)i);
//        }
//        System.out.println("PostOrden Normal");
//        Iterator<Double> it = arbol.postOrden();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        System.out.println("PostOrden Balanceado");
//        Iterator<Double> itB = arbolAVL.postOrden();
//        while(itB.hasNext()){
//            System.out.println(itB.next());
//        }
//        //funciona bien hasta 6 datos, después marca stackOverFlow
//        System.out.println("Num datos: "+arbol.size()+" Altura: "+arbol.altura());
//        System.out.println("Num datos: "+arbolAVL.size()+" Altura: "+arbolAVL.altura());
        
        long sumaAr, sumaArBal, prom1, prom2;
        int altura1, altura2;
        ArrayList<Integer> listaAr = new ArrayList();
        ArrayList<Integer> listaArBal = new ArrayList();
        for(int n = 1; n<10000000; n*=5){
            sumaAr = 0;
            sumaArBal = 0;
            
            for(int j = 1; j<=30; j++){
                arbol = new BinarySearchTree();
                arbolAVL = new BinarySearchTreeAVL();
                creaArbolRandom(arbol, n);
                creaArbolRandom(arbolAVL, n);
                altura1=arbol.altura();
                altura2=arbolAVL.altura();
                listaAr.add(altura1);
                listaArBal.add(altura2);
                sumaAr+=altura1;
                sumaArBal+=altura2;
            }
            prom1 = sumaAr/30;
            prom2 = sumaArBal/30;
            System.out.println("\nPromedio de Alturas para arboles de "+n+" elementos:");
            System.out.println("\tNormal: "+prom1+"\nDatos: "+listaAr.toString());
            System.out.println("\tBalanceado: "+prom2+"\nDatos: "+listaArBal.toString());
            listaAr.clear();
            listaArBal.clear();
        }
    }
}
