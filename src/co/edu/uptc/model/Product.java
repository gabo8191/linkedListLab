package co.edu.uptc.model;

public class Product {

  private int code;
  private String name;
  private long unitValue;
  private int quantity;

  public Product(int code, String name, long unitValue, int quantity) {
    this.code = code;
    this.name = name;
    this.unitValue = unitValue;
    this.quantity = quantity;
  }

  public int getCode() {
    return code;
  }

  public String getName() {
    return name;
  }

  public long getUnitValue() {
    return unitValue;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public String toString() {
    return String.format("Código: %d, Nombre: %s, Valor Unitario: %d, Cantidad: %d", code, name, unitValue, quantity);

  }
}
