package co.edu.uptc.presenter;

import co.edu.uptc.model.Product;
import co.edu.uptc.model.Store;
import co.edu.uptc.model.StoreChain;
import co.edu.uptc.view.MyFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class Presenter implements ActionListener {

  private MyFrame view;
  private StoreChain storeChain;

  public Presenter() {
    view = new MyFrame(this);
    dataSet();
  }

  public void dataSet() {
    storeChain = new StoreChain();
    Store store0 = new Store("Tienda 1", "Calle 1", 1);
    store0.addProduct(new Product(1, "Producto 1", 1000, 10));
    store0.addProduct(new Product(2, "Producto 2", 2000, 20));
    store0.addProduct(new Product(3, "Producto 3", 3000, 30));
    storeChain.addStore(store0);

    Store store1 = new Store("Tienda 2", "Calle 2", 2);
    store1.addProduct(new Product(4, "Producto 4", 4000, 40));
    store1.addProduct(new Product(5, "Producto 5", 5000, 50));
    store1.addProduct(new Product(6, "Producto 6", 6000, 60));
    storeChain.addStore(store1);

    Store store2 = new Store("Tienda 3", "Calle 3", 3);
    store2.addProduct(new Product(7, "Producto 7", 7000, 70));
    store2.addProduct(new Product(8, "Producto 8", 8000, 80));
    store2.addProduct(new Product(9, "Producto 9", 9000, 90));
    storeChain.addStore(store2);

    Store store3 = new Store("Tienda 4", "Calle 4", 4);
    store3.addProduct(new Product(100, "Producto 10", 10000, 100));
    store3.addProduct(new Product(114, "Producto 11", 11000, 110));
    store3.addProduct(new Product(12, "Producto 12", 12000, 120));
    storeChain.addStore(store3);

    Store store4 = new Store("Tienda 5", "Calle 5", 5);
    store4.addProduct(new Product(23, "Producto 13", 13000, 98));
    store4.addProduct(new Product(54, "Producto 14", 14000, 87));
    store4.addProduct(new Product(65, "Producto 15", 15000, 76));
    storeChain.addStore(store4);
  }

  public static void main(String[] args) {
    new Presenter();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    String command = e.getActionCommand();
    switch (command) {
      case "SHOW_STORES":
        handleShowStores();
        break;
      case "SHOW_PRODUCTS":
        handleShowProducts();
        break;
      case "SHOW_PRODUCT_BY_CODE":
        handleShowProductByCode();
        break;
      case "SHOW_QUANTITY_PRODUCTS_DIFFERENT":
        handleShowQuantityProductsDifferent();
        break;
      case "SHOW_TOTAL_VALUE_BY_STORE":
        handleShowTotalValueByStore();
        break;
      case "SHOW_TOTAL_VALUE_BY_CHAIN":
        handleShowTotalValueByChain();
        break;
      case "CREATE_STORE":
        handleCreateStore();
        break;
      case "CREATE_PRODUCT":
        handleCreateProduct();
        break;
      case "SELL_PRODUCT":
        handleSellProduct();
        break;
      case "SHOW_PRODUCTS_BY_STORE":
        handleShowProductsByStore();
        break;
      case "DELETE_RANGE":
        handleDeleteRange();
        break;
      case "REMOVE_RANGE":
        handleRemoveRanges();
        break;
      default:
        break;
    }
  }

  private void handleDeleteRange() {
    view.showRemoveRangesDialog(this);
  }

  private void handleRemoveRanges() {
    int start = view.getRemoveRangesStart();
    int end = view.getRemoveRangesEnd();
    storeChain.removeProductsByRange(start, end);
    view.clearRemoveRangesFields();
    view.showRemoveRangesMessage("Rango eliminado correctamente");
  }

  private void handleShowProductsByStore() {
    int storeId = view.getStoreIdProducts();
    Store store = storeChain.searchStore(storeId);
    if (store == null) {
      view.showProductsDialog("La tienda no existe");
      return;
    }
    view.showProductsDialog(store.getProducts().toString());
  }

  private void handleCreateProduct() {
    int code = view.getProductCode();
    String name = view.getProductName();
    long unitValue = view.getProductUnitValue();
    int quantity = view.getProductQuantity();
    int storeId = view.getProductStoreId();
    Store store = storeChain.searchStore(storeId);

    if (store == null) {
      view.showProductMessage("La tienda no existe");
      return;
    }
    boolean productFound = false;
    for (int i = 0; i < store.getProducts().getSize(); i++) {
      if (store.getProducts().get(i).getCode() == code) {
        view.showProductMessage("El producto ya existe");
        productFound = true;
        break;
      }
    }

    if (!productFound) {
      boolean added = store.addProduct(new Product(code, name, unitValue, quantity));
      view.showProductMessage(added ? "Producto creado correctamente" : "El producto ya existe");
    } else {
      view.showProductMessage("El producto ya existe");
    }
  }

  private void handleCreateStore() {
    String name = view.getStoreName();
    String address = view.getStoreAddress();
    if (name.isEmpty() || address.isEmpty()) {
      view.showStoreMessage("El nombre y la dirección son obligatorios");
      return;
    }
    storeChain.addStore(new Store(name, address, storeChain.getStores().getSize() + 1));
    view.showStoreMessage("Tienda creada correctamente");
  }

  public void handleSellProduct() {
    int code = view.getSellProductCode();
    int quantity = view.getSellProductQuantity();
    int storeId = view.getSellProductStoreId();
    Store store = storeChain.searchStore(storeId);
    if (store == null) {
      view.showSellMessage("La tienda no existe");
      return;
    }
    if (store.searchProduct(code) != null && quantity > 0) {
      if (store.searchProduct(code).getQuantity() >= quantity) {
        store.searchProduct(code).setQuantity(store.searchProduct(code).getQuantity() - quantity);
        view.showSellMessage("Venta realizada correctamente");
      } else {
        view.showSellMessage("La cantidad a vender es mayor a la cantidad en inventario");
      }
    } else {
      view.showSellMessage("El producto no existe");
    }
  }

  private void handleShowTotalValueByChain() {
    view.showTotalDialog("El valor total del inventario de la cadena es: "
        + NumberFormat.getCurrencyInstance().format(storeChain.totalInventoryValue()));
  }

  private void handleShowTotalValueByStore() {
    int storeId = view.getStoreId();
    Store store = storeChain.searchStore(storeId);
    if (store == null) {
      view.showTotalDialog("La tienda no existe");
      return;
    }
    view.showTotalDialog("El valor total del inventario de la tienda es: "
        + NumberFormat.getCurrencyInstance().format(store.totalInventoryValue()));
  }

  private void handleShowQuantityProductsDifferent() {
    String products = "";
    for (int i = 0; i < storeChain.getStores().getSize(); i++) {
      products += storeChain.getStores().get(i).getName() + "\n";
      products += storeChain.getStores().get(i).differentProducts() + "\n";
      products += storeChain.getStores().get(i).getProducts() + "\n";
    }
    products += "Total de productos diferentes: " + storeChain.differentProducts();
    view.showProductsDialog(products);
  }

  private void handleShowProductByCode() {
    int code = view.getSearchProductCode();
    String products = "";
    for (int i = 0; i < storeChain.getStores().getSize(); i++) {
      if (storeChain.getStores().get(i).searchProduct(code) != null) {
        products += storeChain.getStores().get(i).getName() + "\n";
        products += storeChain.getStores().get(i).searchProduct(code) + "\n";
      } else {
        products += "El producto no existe en la tienda " + storeChain.getStores().get(i).getName() + "\n";
      }
    }
    view.showProductsDialog(products);
  }

  private void handleShowProducts() {
    String products = "";
    for (int i = 0; i < storeChain.getStores().getSize(); i++) {
      products += storeChain.getStores().get(i).getName() + "\n";
      products += storeChain.getStores().get(i).getProducts() + "\n";
    }

    view.showProductsDialog(products);

  }

  private void handleShowStores() {
    view.showStoresDialog(storeChain.toString());
  }

}
