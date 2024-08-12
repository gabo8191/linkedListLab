package co.edu.uptc.structures;

import java.util.Iterator;

public class SimpleLinkedList<T> implements Iterable<T> {

  private Node<T> head;

  public SimpleLinkedList() {
    this.head = null;
  }

  public void add(T data) {
    Node<T> newNode = new Node<T>(data);
    if (isEmpty()) {
      this.head = newNode;
    } else {
      Node<T> current = this.head;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newNode);
    }
  }

  public boolean exist(T data) {
    Node<T> current = this.head;
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
    return head.toString();
  }

  public boolean remove(T data) {
    if (isEmpty()) {
      return false;
    }
    if (this.head.getData().equals(data)) {
      this.head = this.head.getNext();
      return true;
    }
    Node<T> current = this.head;
    while (current.getNext() != null) {
      if (current.getNext().getData().equals(data)) {
        current.setNext(current.getNext().getNext());
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  public int getSize() {
    int size = 0;
    Node<T> current = this.head;
    while (current != null) {
      size++;
      current = current.getNext();
    }
    return size;
  }

  public T get(int index) {
    if (index < 0 || index >= getSize()) {
      return null;
    }
    Node<T> current = this.head;
    for (int i = 0; i < index; i++) {
      current = current.getNext();
    }
    return current.getData();
  }

  @Override
  public Iterator<T> iterator() {
    return new Iterator<T>() {
      private Node<T> current = head;

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
  }

  @Override
  public String toString() {
    return head.toString();
  }

}
