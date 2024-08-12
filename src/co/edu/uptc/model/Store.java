package co.edu.uptc.model;

import co.edu.uptc.structures.DoubleLinkedList;

public class Store {
  private DoubleLinkedList<Product> products;
  private String name;
  private String adress;
  private int id;

  public Store(String name, String adress, int id) {
    this.products = new DoubleLinkedList<>();
    this.name = name;
    this.adress = adress;
    this.id = id;
  }

  public boolean addProduct(Product product) {
    if (products.exist(product)) {
      return false;
    } else {
      products.add(product);
      return true;
    }
  }

  public boolean removeProduct(Product product) {
    return products.remove(product);
  }

  public Product searchProduct(int code) {
    Product product = null;
    for (int i = 0; i < products.getSize(); i++) {
      if (products.get(i).getCode() == code) {
        product = products.get(i);
      }
    }
    return product;
  }

  public Product searchProduct(String name) {
    Product product = null;
    for (int i = 0; i < products.getSize(); i++) {
      if (products.get(i).getName().equals(name)) {
        product = products.get(i);
      }
    }
    return product;
  }

  public long totalInventoryValue() {
    long total = 0;
    for (int i = 0; i < products.getSize(); i++) {
      total += products.get(i).getUnitValue() * products.get(i).getQuantity();
    }
    return total;
  }

  public int differentProducts() {
    return products.getSize();
  }

  public boolean sellProduct(int code, int quantity) {
    Product product = searchProduct(code);
    if (product != null) {
      if (product.getQuantity() >= quantity) {
        product.setQuantity(product.getQuantity() - quantity);
        return true;
      }
    }
    return false;
  }

  public void removeProductsByRange(int start, int end) {
    for (int i = 0; i < products.getSize(); i++) {
      if (products.get(i).getCode() >= start && products.get(i).getCode() <= end) {
        products.remove(products.get(i));
        i--;
      }
    }
  }

  public DoubleLinkedList<Product> getProducts() {
    return products;
  }

  public String getName() {
    return name;
  }

  public String getAdress() {
    return adress;
  }

  public int getId() {
    return id;
  }

  public String invert() {
    return products.showInverted();
  }

  public String showProducts() {
    return products.toString();
  }

  @Override
  public String toString() {
    return String.format("Nombre: %s, Dirección: %s, Id: %d", name, adress, id);
  }
}
