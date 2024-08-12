package co.edu.uptc.structures;

public class DoubleNode<T> {
  private T data;
  private DoubleNode<T> next;
  private DoubleNode<T> previous;

  public DoubleNode(T data) {
    this.data = data;
    this.next = null;
    this.previous = null;
  }

  public T getData() {
    return data;
  }

  public DoubleNode<T> getNext() {
    return next;
  }

  public void setNext(DoubleNode<T> next) {
    this.next = next;
  }

  public DoubleNode<T> getPrevious() {
    return previous;
  }

  public void setPrevious(DoubleNode<T> previous) {
    this.previous = previous;
  }

  @Override
  public String toString() {

    return String.format("%s <=> %s", data, next);
  }

}
