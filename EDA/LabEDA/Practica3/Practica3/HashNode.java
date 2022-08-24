public class HashNode<T> {
  T elem;
  HashNode<T> next; 

  HashNode(T elem){
    this.elem = elem;
    next = null;
  }
  public T getElem(){
    return elem;
  }
  public HashNode<T> getNext(){
    return next;
  }
  public void setNext(HashNode<T> next){
    this.next = next;
  }
  public void setElem(T elem){
    this.elem = elem;
  }
}