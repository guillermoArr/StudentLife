/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaalturas;

import tareaarbolesbb.*;
import java.util.Iterator;

/**
 *
 * @author memit
 */
public interface BinarySearchTreeADT <T extends Comparable<T>>{
  public boolean isEmpty();
  public int size();
  public boolean find(T elem);
  public Iterator<T> inOrden();
  public Iterator<T> preOrden();
  public Iterator<T> postOrden();
  public void add(T elem);
  public void borra(T elem);
  public int altura();
}
