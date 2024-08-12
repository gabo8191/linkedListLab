package co.edu.uptc.structures;

import java.util.Iterator;

public class DoubleLinkedList<T> implements Iterable<T> {

  private DoubleNode<T> head;

  public DoubleLinkedList() {
    this.head = null;
  }

  public void add(T data) {
    DoubleNode<T> newNode = new DoubleNode<T>(data);

    if (isEmpty()) {
      this.head = newNode;
    } else {
      DoubleNode<T> current = this.head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
      newNode.setPrevious(current);
    }
  }

  public boolean exist(T data) {
    DoubleNode<T> current = this.head;
    while (current != null) {
      if (current.getData().equals(data)) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  public boolean isEmpty() {
    return this.head == null;
  }

  public String show() {
    return head != null ? head.toString() : "";
  }

  public boolean remove(T data) {
    if (isEmpty()) {
      return false;
    }
    if (this.head.getData().equals(data)) {
      this.head = this.head.getNext();
      return true;
    }
    DoubleNode<T> current = this.head;
    while (current.getNext() != null) {
      if (current.getNext().getData().equals(data)) {
        current.setNext(current.getNext().getNext());
        if (current.getNext() != null) {
          current.getNext().setPrevious(current);
        }
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  public int getSize() {
    int size = 0;
    DoubleNode<T> current = this.head;
    while (current != null) {
      size++;
      current = current.getNext();
    }
    return size;
  }

  public T get(int index) {
    DoubleNode<T> current = this.head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getData();
  }

  @Override
  public Iterator<T> iterator() {
    Iterator<T> iterator;

    iterator = new Iterator<T>() {

      DoubleNode<T> current = head;

      @Override
      public boolean hasNext() {
        return current != null;
      }

      @Override
      public T next() {
        T data = current.getData();
        current = current.getNext();
        return data;
      }
    };
    return iterator;
  }

  public String showInverted() {
    String result = "";
    DoubleNode<T> current = this.head;
    while (current.getNext() != null) {
      current = current.getNext();
    }
    while (current != null) {
      result += current.getData() + " - ";
      current = current.getPrevious();
    }
    return result;
  }

  @Override
  public String toString() {
    return show();
  }

}
