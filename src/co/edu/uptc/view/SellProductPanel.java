package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class SellProductPanel extends JPanel {
  private JLabel lblTitle, lblCodeProduct, lblQuantity, lblStoreId, lblMessage;
  private JTextArea txtCodeProduct, txtQuantity, txtStoreId;
  private JButton btnSell;

  public SellProductPanel(ActionListener listener) {
    initComponents(listener);
  }

  public void initComponents(ActionListener listener) {
    this.setLayout(new GridLayout(5, 2, 5, 5));
    lblTitle = new JLabel("Vender Producto");
    lblTitle.setHorizontalAlignment(JLabel.CENTER);
    lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
    this.add(lblTitle);

    JLabel space = new JLabel("");
    this.add(space);

    lblCodeProduct = new JLabel("Código Producto");
    this.add(lblCodeProduct);

    txtCodeProduct = new JTextArea();
    this.add(txtCodeProduct);

    lblQuantity = new JLabel("Cantidad");
    this.add(lblQuantity);

    txtQuantity = new JTextArea();
    this.add(txtQuantity);

    lblStoreId = new JLabel("Id Tienda");
    this.add(lblStoreId);

    txtStoreId = new JTextArea();
    this.add(txtStoreId);

    btnSell = new JButton("Vender");
    btnSell.addActionListener(listener);
    btnSell.setActionCommand("SELL_PRODUCT");
    this.add(btnSell);

    lblMessage = new JLabel("");
    this.add(lblMessage);
  }

  public int getCodeProduct() {
    return Integer.parseInt(txtCodeProduct.getText());
  }

  public int getQuantity() {
    return Integer.parseInt(txtQuantity.getText());
  }

  public int getStoreId() {
    return Integer.parseInt(txtStoreId.getText());
  }

  public void showMessage(String message) {
    lblMessage.setText(message);
  }

  public void clearFields() {
    txtCodeProduct.setText("");
    txtQuantity.setText("");
    txtStoreId.setText("");
  }

}
