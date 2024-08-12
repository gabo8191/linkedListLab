package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CreateProductPanel extends JPanel {

  private JLabel lblTitle, lblCode, lblName, lblUnitValue, lblQuantity, lblStoreId, lblMessage;
  private JTextArea txtCode, txtName, txtUnitValue, txtQuantity, txtStoreId;
  private JButton btnCreate;

  public CreateProductPanel(ActionListener listener) {
    initComponents(listener);
  }

  public void initComponents(ActionListener listener) {
    this.setLayout(new GridLayout(7, 2, 5, 5));
    lblTitle = new JLabel("Crear Producto");
    lblTitle.setHorizontalAlignment(JLabel.CENTER);
    lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
    this.add(lblTitle);

    JLabel space = new JLabel("");
    this.add(space);

    lblCode = new JLabel("Código");
    this.add(lblCode);

    txtCode = new JTextArea();
    this.add(txtCode);

    lblName = new JLabel("Nombre");
    this.add(lblName);

    txtName = new JTextArea();
    this.add(txtName);

    lblUnitValue = new JLabel("Valor Unitario");
    this.add(lblUnitValue);

    txtUnitValue = new JTextArea();
    this.add(txtUnitValue);

    lblQuantity = new JLabel("Cantidad");
    this.add(lblQuantity);

    txtQuantity = new JTextArea();
    this.add(txtQuantity);

    lblStoreId = new JLabel("Id Tienda");
    this.add(lblStoreId);

    txtStoreId = new JTextArea();
    this.add(txtStoreId);

    btnCreate = new JButton("Crear");
    btnCreate.addActionListener(listener);
    btnCreate.setActionCommand("CREATE_PRODUCT");
    this.add(btnCreate);

    lblMessage = new JLabel("");
    this.add(lblMessage);

  }

  public int getCode() {
    return Integer.parseInt(txtCode.getText());
  }

  public String getName() {
    return txtName.getText();
  }

  public int getUnitValue() {
    return Integer.parseInt(txtUnitValue.getText());
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
    txtCode.setText("");
    txtName.setText("");
    txtUnitValue.setText("");
    txtQuantity.setText("");
    txtStoreId.setText("");
  }

}
