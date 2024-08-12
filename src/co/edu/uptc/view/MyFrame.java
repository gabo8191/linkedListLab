package co.edu.uptc.view;

import java.awt.Color;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MyFrame extends JFrame {
  private ButtonsPanel buttonsPanel;
  private CreateStorePanel createStorePanel;
  private CreateProductPanel createProductPanel;
  private SellProductPanel sellProductPanel;
  private SearchPanel searchPanel;
  private RemoveRangesDialog removeRangesDialog;

  public MyFrame(ActionListener listener) {
    this.setSize(600, 900);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    this.setTitle("Cadena de Tiendas");
    initComponents(listener);
    this.setVisible(true);
  }

  public void initComponents(ActionListener listener) {
    JPanel container = new JPanel();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    createStorePanel = new CreateStorePanel(listener);
    container.add(createStorePanel);

    createProductPanel = new CreateProductPanel(listener);
    createProductPanel.setBackground(Color.LIGHT_GRAY);
    container.add(createProductPanel);

    sellProductPanel = new SellProductPanel(listener);
    container.add(sellProductPanel);

    searchPanel = new SearchPanel(listener);
    searchPanel.setBackground(Color.LIGHT_GRAY);
    container.add(searchPanel);

    buttonsPanel = new ButtonsPanel(listener);
    container.add(buttonsPanel);

    this.setContentPane(container);
  }

  public void showStoresDialog(String stores) {
    JOptionPane.showMessageDialog(this, stores, "Tiendas", JOptionPane.INFORMATION_MESSAGE);
  }

  public void showProductsDialog(String products) {
    JOptionPane.showMessageDialog(this, products, "Productos", JOptionPane.INFORMATION_MESSAGE);
  }

  public String getStoreName() {
    return createStorePanel.getName();
  }

  public String getStoreAddress() {
    return createStorePanel.getAddress();
  }

  public void showStoreMessage(String message) {
    createStorePanel.showMessage(message);
  }

  public void clearStoreFields() {
    createStorePanel.clearFields();
  }

  public int getProductCode() {
    return createProductPanel.getCode();
  }

  public String getProductName() {
    return createProductPanel.getName();
  }

  public int getProductUnitValue() {
    return createProductPanel.getUnitValue();
  }

  public int getProductQuantity() {
    return createProductPanel.getQuantity();
  }

  public int getProductStoreId() {
    return createProductPanel.getStoreId();
  }

  public void showProductMessage(String message) {
    createProductPanel.showMessage(message);
  }

  public void clearProductFields() {
    createProductPanel.clearFields();
  }

  public int getSellProductCode() {
    return sellProductPanel.getCodeProduct();
  }

  public int getSellProductQuantity() {
    return sellProductPanel.getQuantity();
  }

  public int getSellProductStoreId() {
    return sellProductPanel.getStoreId();
  }

  public void showSellProductMessage(String message) {
    sellProductPanel.showMessage(message);
  }

  public void clearSellProductFields() {
    sellProductPanel.clearFields();
  }

  public void showSellMessage(String message) {
    sellProductPanel.showMessage(message);
  }

  public int getSearchProductCode() {
    return searchPanel.getCodeProduct();
  }

  public void showSearchMessage(String message) {
    searchPanel.showProduct(message);
  }

  public int getStoreId() {
    return searchPanel.getStoreId();
  }

  public void showTotal(String message) {
    searchPanel.showTotal(message);
  }

  public void showTotalDialog(String message) {
    JOptionPane.showMessageDialog(this, message, "Total", JOptionPane.INFORMATION_MESSAGE);
  }

  public int getStoreIdProducts() {
    return searchPanel.getStoreIdProducts();
  }

  public void showRemoveRangesDialog(ActionListener listener) {
    removeRangesDialog = new RemoveRangesDialog(listener);
  }

  public int getRemoveRangesStart() {
    return removeRangesDialog.getStart();
  }

  public int getRemoveRangesEnd() {
    return removeRangesDialog.getEnd();
  }

  public void showRemoveRangesMessage(String message) {
    removeRangesDialog.showMessage(message);
  }

  public void clearRemoveRangesFields() {
    removeRangesDialog.clearFields();
  }

}
