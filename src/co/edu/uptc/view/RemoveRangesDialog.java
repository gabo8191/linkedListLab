package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class RemoveRangesDialog extends JDialog {

  private JLabel lblTitle, lblStart, lblEnd, lblMessage;
  private JTextArea txtStart, txtEnd;
  private JButton btnRemove;

  public RemoveRangesDialog(ActionListener listener) {
    initComponents(listener);
  }

  public void initComponents(ActionListener listener) {
    this.setLayout(new GridLayout(4, 2, 5, 5));
    setTitle("Eliminar Rango");
    setSize(600, 150);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    setVisible(true);

    lblTitle = new JLabel("Eliminar Rango de prodcutos por ID");
    lblTitle.setHorizontalAlignment(JLabel.CENTER);
    lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
    this.add(lblTitle);

    JLabel space = new JLabel("");
    this.add(space);

    lblStart = new JLabel("Inicio");
    this.add(lblStart);

    txtStart = new JTextArea();
    this.add(txtStart);

    lblEnd = new JLabel("Fin");
    this.add(lblEnd);

    txtEnd = new JTextArea();
    this.add(txtEnd);

    btnRemove = new JButton("Eliminar");
    btnRemove.addActionListener(listener);
    btnRemove.setActionCommand("REMOVE_RANGE");
    this.add(btnRemove);

    lblMessage = new JLabel("");
    this.add(lblMessage);

  }

  public int getStart() {
    return Integer.parseInt(txtStart.getText());
  }

  public int getEnd() {
    return Integer.parseInt(txtEnd.getText());
  }

  public void clearFields() {
    txtStart.setText("");
    txtEnd.setText("");
  }

  public void showMessage(String message) {
    lblMessage.setText(message);
  }

}
