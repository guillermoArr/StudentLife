/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaordenamiento;

/**
 *
 * @author Guillermo Arredondo Renero
 */
public class Ordena <T extends Comparable<T>>{
    //quickSort
  public void quickSort(T[] datos){
    quickSort(0, datos.length, datos);
  }
  private void quickSort(int inf, int sup, T[] datos){ 
    if(sup-inf<=1)
        return;
    int pivote = particion(inf, sup-1, datos); // num operaciones: 6n=n
    quickSort(inf,pivote,datos); // se llama n/2
    quickSort(pivote+1,sup, datos);  // se llama n/2
  }
  private int particion(int inf, int sup, T[] datos){
    T temp;
    while(inf < sup){ //num operaciones dentro de while: 6
      int aux = inf+1;
      if(datos[inf].compareTo(datos[aux])>0){
        temp = datos[aux];
        datos[aux] = datos[inf];
        datos[inf] = temp;
        inf++;
      }
      else{
        temp = datos[sup];
        datos[sup] = datos[aux];
        datos[aux] = temp;
        sup--;
      }
    }
    return inf;
  }
  //mergeSort Iterativo
  public void mergeSortIt(T[] datos){
    int min = 0, max = datos.length-1;
    int size = max-min;

    for(int step = 1; step<=size; step = 2*step)
      for(int inicio = 0; inicio < max; inicio += 2*step){
        int pivote = inicio + step-1;
        int fin = Integer.min(inicio + 2*step - 1, max); // 1 operacion
        mezcla(datos, inicio, pivote, fin); // 2n+4 aprox
      }
  }
  //mergeSort Recursivo
  public void mergeSort(T[] datos){
    mergeSort(datos, 0, datos.length-1);
  }
  private void mergeSort(T[] datos, int min, int max){
    if(min == max)
      return;
    int pivote = (min+max)/2;
    mergeSort(datos, min, pivote);
    mergeSort(datos, pivote+1, max); 
    mezcla(datos, min, pivote, max);
  }
  // mezcla
  private void mezcla(T[] datos, int inicio, int mitad, int fin){
    T[] temp = (T[]) new Comparable[fin-inicio+1];
    int der = mitad+1, izq = inicio;
    for(int i = 0; i<temp.length; i++){
      if(der<=fin)
        if(izq<=mitad){
          if(datos[izq].compareTo(datos[der])<0){
            temp[i]=datos[izq++];
          }
          else{
            temp[i]=datos[der++];
          }
        }
        else
          temp[i]=datos[der++];
      else
        temp[i]=datos[izq++];
    }
    for(int i=0; i<temp.length; i++){
      datos[inicio+i]=temp[i];
    }
  }
  //imprime
  public void imprime(T[] datos) {
    for (int i = 0; i < datos.length; i++)
      System.out.print(datos[i] + " ");
    System.out.println();
  }       
}
