package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CreateStorePanel extends JPanel {
  private JLabel lblTitle, lblName, lblAddress, lblMessage;
  private JTextArea txtName, txtAddress;
  private JButton btnCreate;

  public CreateStorePanel(ActionListener listener) {
    initComponents(listener);
  }

  public void initComponents(ActionListener listener) {
    this.setLayout(new GridLayout(4, 2, 5, 5));

    lblTitle = new JLabel("Crear Tienda");
    lblTitle.setHorizontalAlignment(JLabel.CENTER);
    lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
    this.add(lblTitle);

    JLabel space = new JLabel("");
    this.add(space);

    lblName = new JLabel("Nombre");
    this.add(lblName);

    txtName = new JTextArea();
    this.add(txtName);

    lblAddress = new JLabel("Dirección");
    this.add(lblAddress);

    txtAddress = new JTextArea();
    this.add(txtAddress);

    btnCreate = new JButton("Crear");
    btnCreate.addActionListener(listener);
    btnCreate.setActionCommand("CREATE_STORE");
    this.add(btnCreate);

    lblMessage = new JLabel("");
    this.add(lblMessage);
  }

  public String getName() {
    return txtName.getText();
  }

  public String getAddress() {
    return txtAddress.getText();
  }

  public void showMessage(String message) {
    lblMessage.setText(message);
  }

  public void clearFields() {
    txtName.setText("");
    txtAddress.setText("");
  }

}
