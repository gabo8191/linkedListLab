package co.edu.uptc.model;

import co.edu.uptc.structures.SimpleLinkedList;

public class StoreChain {
  private SimpleLinkedList<Store> stores;

  public StoreChain() {
    this.stores = new SimpleLinkedList<>();
  }

  public SimpleLinkedList<Store> getStores() {
    return stores;
  }

  public void addStore(Store store) {

    stores.add(store);
  }

  public boolean removeStore(Store store) {
    return stores.remove(store);
  }

  public Store searchStore(int id) {
    Store store = null;
    for (int i = 0; i < stores.getSize(); i++) {
      if (stores.get(i).getId() == id) {
        store = stores.get(i);
      }
    }
    return store;
  }

  public int differentProducts() {
    int total = 0;
    for (int i = 0; i < stores.getSize(); i++) {
      total += stores.get(i).differentProducts();
    }
    return total;
  }

  public Store searchStore(String name) {
    Store store = null;
    for (int i = 0; i < stores.getSize(); i++) {
      if (stores.get(i).getName().equals(name)) {
        store = stores.get(i);
      }
    }
    return store;
  }

  public long totalInventoryValue() {
    long total = 0;
    for (int i = 0; i < stores.getSize(); i++) {
      total += stores.get(i).totalInventoryValue();
    }
    return total;
  }

  public void removeProductsByRange(int start, int end) {
    for (int i = 0; i < stores.getSize(); i++) {
      stores.get(i).removeProductsByRange(start, end);
    }
  }

  @Override
  public String toString() {
    return String.format("%s", stores);
  }

}
