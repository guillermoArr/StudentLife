/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaarbolesbb;

import java.util.*;

/**
 *
 * @author Guillermo Arredondo
 */
public class TareaArbolesBB {
    public static void arbolBalanceado(int n, int semilla /*0*/, BinarySearchTreeADT<Integer> arbol, int i/*2*/){
        if(i-1<=n){
            arbol.add(semilla);
            arbolBalanceado(n,semilla+(int)Math.pow(2, n-i),arbol,i+1);
            arbolBalanceado(n,semilla-(int)Math.pow(2,n-i),arbol,i+1);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BinarySearchTreeADT<Integer> arbol = new BinarySearchTree();
        Random rand = new Random();
        int nuevo, n0=4;
        /*arbolBalanceado(n0,(int)Math.pow(2,n0 -1),arbol,2);
        Iterator<Integer> it = arbol.inOrden();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        /*System.out.println("Vacio: " + arbol.isEmpty());
        arbol.add(1);
        for(int i = 0; i<10; i++){
            nuevo = rand.nextInt(50);
            System.out.print(nuevo+" ");
            arbol.add(nuevo);
        }
        nuevo = 34;
        arbol.add(nuevo);
        System.out.println("Vacio?: " + arbol.isEmpty());
        System.out.println("Tamaño: "+ arbol.size());
        System.out.println("Está el dato 34? " + arbol.find(nuevo));
        System.out.println("Inorden");
        Iterator<Integer> it = arbol.inOrden();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("Preorden");
        it = arbol.preOrden();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("PostOrden");
        it = arbol.postOrden();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("hasta ahora todo funciona perfecto");
        arbol.borra(nuevo);
        System.out.println("Tamaño: "+ arbol.size());
        System.out.println("Inorden");
        it = arbol.inOrden();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        System.out.println("Pruebas unitarias de métodos funcionan adecuadamente");
        
        System.out.println("Pruebas para experimento");
        System.out.println("Insertar: "+arbol.add(50));
        System.out.println("Borrar: "+arbol.borra(1));
        */
        ////////////////////////////////////////////////////////////////////////
        System.out.println("Inica Experimento");
        ArrayList<Integer> cantDatos= new ArrayList();
        ArrayList<Integer> numComps=new ArrayList();
        int contCompsInsert, contCompsBorra,k;
        for (int tipo = 1; tipo <= 3; tipo++) {
            switch (tipo) {
                case 1:
                    System.out.println("Caso aleatorio o medio");
                    for (int n = 10; n <= 10000000; n *= 10) {
                        cantDatos.add(n);
                        contCompsInsert = 0;
                        contCompsBorra = 0;
                        for (int i = 0; i < n; i++) {
                            nuevo = rand.nextInt(n * 5);
                            arbol.add(nuevo);
                        }
                        nuevo = rand.nextInt(n * 7);
                        numComps.add(arbol.add(nuevo));
                        System.out.println("Tamaño: " + arbol.size());
                        System.out.println("Está el dato " + nuevo + " " + arbol.find(nuevo));
                        numComps.add(arbol.borra(nuevo));
                        System.out.println("Tamaño: " + arbol.size()); 
                        arbol = new BinarySearchTree();
                    }
                    for (int j = 0; j < cantDatos.size(); j++) {
                        k = 2 * j + 1;
                        System.out.println("Cantidad: " + cantDatos.get(j));
                        System.out.print("\nComparaciones de insertar: " + numComps.get(k - 1));
                        System.out.println("\tComparaciones de borrar: " + numComps.get(k));
                    }
                    cantDatos.clear();
                    numComps.clear();
                        break;
                case 2: 
                    System.out.println("Caso ordenado como lista");
                    for (int n = 10; n <= 10000; n *= 10) {
                        contCompsInsert = 0;
                        contCompsBorra = 0;
                        for (int i = 0; i < n; i++) {
                            arbol.add(i);
                        }
                        for(int caso=1; caso<=3; caso++){
                            switch(caso){
                                case 1: 
                                    System.out.println("En el MENOR");
                                    nuevo=-8;
                                    break;
                                case 2:
                                    System.out.println("Aleatorio en medio");
                                    nuevo=rand.nextInt(n-1);
                                    break;
                                default:
                                    System.out.println("En el MAYOR");
                                    nuevo=n+4;
                                    break;
                            }
                            contCompsInsert = arbol.add(nuevo);
                            System.out.println("Tamaño: " + arbol.size());
                            System.out.println("Está el dato " + nuevo + " " + arbol.find(nuevo));
                            contCompsBorra = arbol.borra(nuevo);;
                            System.out.println("Tamaño: " + arbol.size());
                            System.out.println("Cantidad: " + n);
                            System.out.print("\nComparaciones de insertar: " + contCompsInsert);
                            System.out.println("\tComparaciones de borrar: " + contCompsBorra);
                        }
                        arbol = new BinarySearchTree();
                    }
                    cantDatos.clear();
                    numComps.clear();
                        break;
                default: 
                    System.out.println("Arbol diseñado y equilibrado *no por fuerza lleno*");
                    for (int n = 10; n <= 10000000; n *= 10) {
                        cantDatos.add(n);
                        contCompsInsert = 0;
                        contCompsBorra = 0;
                        arbolBalanceado((int)Math.floor(Math.log(n+1)/Math.log(2)),(int)Math.pow(2, Math.log(n+1)/Math.log(2)),arbol, 2);
                        nuevo = rand.nextInt(n*3);
                        numComps.add(arbol.add(nuevo));
                        System.out.println("Tamaño: " + arbol.size());
                        System.out.println("Está el dato " + nuevo + " " + arbol.find(nuevo));
                        numComps.add(arbol.borra(nuevo));
                        System.out.println("Tamaño: " + arbol.size());
                        arbol = new BinarySearchTree();
                    }
                    for (int j = 0; j < cantDatos.size(); j++) {
                        k = 2 * j + 1;
                        System.out.println("Cantidad: " + cantDatos.get(j));
                        System.out.print("\nComparaciones de insertar: " + numComps.get(k - 1));
                        System.out.println("\tComparaciones de borrar: " + numComps.get(k));
                    }
                    cantDatos.clear();
                    numComps.clear();
                    break;
            }
    //            System.out.println("Inorden");
    //            it = arbol.inOrden();
    //            while (it.hasNext()) {
    //                System.out.println(it.next());
    //            }
    //            System.out.println("Inorden");
    //            it = arbol.inOrden();
    //            while(it.hasNext()){
    //                System.out.println(it.next());
    //            }
        }         
    }
    
}
