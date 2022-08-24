/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaordenamiento;

import java.util.Random;

/**
 *
 * @author memit
 */
public class TareaOrdenamiento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Ordena<Integer> sort=new Ordena<Integer>();
        int length = 10;
        Integer[] datos = new Integer[length];
        Integer[] datos2 = new Integer[length];
        Integer[] datos3 = new Integer[length];
        long inicio1, inicio2, inicio3, fin1, fin2, fin3;
        Random rand=new Random();
        for(int i=0;i<datos.length;i++){
            datos[i]=rand.nextInt(100);
            datos2[i]=datos[i];
            datos3[i]=datos[i];
        }
        Integer[] datos1 = { 60, 86, 70, 47, 68, 15, 2, -5, -47, 100, -200, 5, 489, 34, -75, 34, -65, 49, 138, 301, -853, 154, 0, 78,165,156,1548,95,0,549,7,6,64,81,-61,-91,500,461,-2,-23,-1,94,76,-48,-49,-47,35,-36,14,18};
        length = datos1.length;
        /*int x = rand.nextInt(length);
        System.out.println("x: "+ x);
        for (int i = 0; i <datos.length; i++){
            datos[i] = x;
            datos2[i]=datos[i];
            datos3[i]=datos[i];
            x -= 2;
        }*/
        System.out.println("MergeSort Recursivo\n");
        sort.imprime(datos1);
        inicio3 = System.nanoTime();
        sort.mergeSort(datos1);
        fin3 = System.nanoTime();
        sort.imprime(datos1);
        System.out.println("Tiempo de procesamiento 3= " + (fin3-inicio3) + " nS para " + length + " datos\n");
        /*
        System.out.println("Datos: ");
        sort.imprime(datos1);
        System.out.println("QuickSort:");
        inicio1 = System.nanoTime();
        sort.quickSort(datos1);
        fin1 = System.nanoTime();
        sort.imprime(datos1);
        System.out.println("Tiempo de procesamiento 1= " + (fin1-inicio1) + " nS para " + length + " datos\n");
        
        sort.imprime(datos1);
        System.out.println("MergeSort Iterativo\n");
        inicio2 = System.nanoTime();
        sort.mergeSortIt(datos1);
        fin2 = System.nanoTime();
        sort.imprime(datos1);
        System.out.println("Tiempo de procesamiento 2= " + (fin2-inicio2) + " nS para " + length + " datos\n");
        
        */
    }
}
