package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SearchPanel extends JPanel {
  private JLabel lblTitleProdcutByCode, lblTitleTotalByStore, lblTitleProductsByStore;
  private JLabel lblCodeProduct, lblStoreId, lblStoreProductId;
  private JTextArea txtCodeProduct, txtStoreId, txtStoreIdProducts;
  private JButton btnSearchProduct, btnSearchTotal, btnSearchProducts;
  private JLabel lblProduct, lblTotal;

  public SearchPanel(ActionListener listener) {
    initComponents(listener);
  }

  public void initComponents(ActionListener listener) {
    this.setLayout(new GridLayout(9, 2, 5, 5));
    lblTitleProdcutByCode = new JLabel("Buscar Producto por Código");
    lblTitleProdcutByCode.setFont(new Font("Arial", Font.BOLD, 15));
    lblTitleProdcutByCode.setHorizontalAlignment(JLabel.CENTER);
    this.add(lblTitleProdcutByCode);

    JLabel space = new JLabel("");
    this.add(space);

    lblCodeProduct = new JLabel("Código Producto");
    this.add(lblCodeProduct);

    txtCodeProduct = new JTextArea();
    this.add(txtCodeProduct);

    btnSearchProduct = new JButton("Buscar");
    btnSearchProduct.addActionListener(listener);
    btnSearchProduct.setActionCommand("SHOW_PRODUCT_BY_CODE");
    this.add(btnSearchProduct);

    lblProduct = new JLabel("");
    this.add(lblProduct);

    lblTitleTotalByStore = new JLabel("Buscar Total por Tienda");
    lblTitleTotalByStore.setFont(new Font("Arial", Font.BOLD, 15));
    lblTitleTotalByStore.setHorizontalAlignment(JLabel.CENTER);
    this.add(lblTitleTotalByStore);

    space = new JLabel("");
    this.add(space);

    lblStoreId = new JLabel("Id Tienda");
    this.add(lblStoreId);

    txtStoreId = new JTextArea();
    this.add(txtStoreId);

    btnSearchTotal = new JButton("Buscar");
    btnSearchTotal.addActionListener(listener);
    btnSearchTotal.setActionCommand("SHOW_TOTAL_VALUE_BY_STORE");
    this.add(btnSearchTotal);

    lblTotal = new JLabel("");
    this.add(lblTotal);

    lblTitleProductsByStore = new JLabel("Buscar Productos por Tienda");
    lblTitleProductsByStore.setFont(new Font("Arial", Font.BOLD, 15));
    lblTitleProductsByStore.setHorizontalAlignment(JLabel.CENTER);
    this.add(lblTitleProductsByStore);

    space = new JLabel("");
    this.add(space);

    lblStoreProductId = new JLabel("Id Tienda");
    this.add(lblStoreProductId);

    txtStoreIdProducts = new JTextArea();
    this.add(txtStoreIdProducts);

    btnSearchProducts = new JButton("Buscar");
    btnSearchProducts.addActionListener(listener);
    btnSearchProducts.setActionCommand("SHOW_PRODUCTS_BY_STORE");
    this.add(btnSearchProducts);

  }

  public int getStoreIdProducts() {
    return Integer.parseInt(txtStoreIdProducts.getText());
  }

  public int getCodeProduct() {
    return Integer.parseInt(txtCodeProduct.getText());
  }

  public int getStoreId() {
    return Integer.parseInt(txtStoreId.getText());
  }

  public void showProduct(String message) {
    lblProduct.setText(message);
  }

  public void showTotal(String message) {
    lblTotal.setText(message);
  }

  public void clearFields() {
    txtCodeProduct.setText("");
    txtStoreId.setText("");
  }

}
