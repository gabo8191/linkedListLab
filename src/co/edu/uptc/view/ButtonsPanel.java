package co.edu.uptc.view;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ButtonsPanel extends JPanel {
  private JButton btnShowStores, btnShowProducts, btnShowQuantityProductsDifferent, btnShowTotalValueByChain,
      btnDeleteRange;
  private JLabel lblTitle;

  public ButtonsPanel(ActionListener listener) {
    initComponents(listener);
  }

  public void initComponents(ActionListener listener) {
    this.setLayout(new GridLayout(3, 2, 5, 5));
    lblTitle = new JLabel("Opciones");
    lblTitle.setHorizontalAlignment(JLabel.CENTER);
    lblTitle.setFont(new Font("Arial", Font.BOLD, 15));
    this.add(lblTitle);

    btnShowStores = new JButton("Mostrar Tiendas");
    this.add(btnShowStores);
    btnShowStores.setActionCommand("SHOW_STORES");
    btnShowStores.addActionListener(listener);

    btnShowProducts = new JButton("Mostrar Productos");
    this.add(btnShowProducts);
    btnShowProducts.addActionListener(listener);
    btnShowProducts.setActionCommand("SHOW_PRODUCTS");

    btnShowQuantityProductsDifferent = new JButton("Mostrar Cantidad de Productos Diferentes");
    this.add(btnShowQuantityProductsDifferent);
    btnShowQuantityProductsDifferent.addActionListener(listener);
    btnShowQuantityProductsDifferent.setActionCommand("SHOW_QUANTITY_PRODUCTS_DIFFERENT");

    btnShowTotalValueByChain = new JButton("Mostrar Valor Total por Cadena");
    this.add(btnShowTotalValueByChain);
    btnShowTotalValueByChain.addActionListener(listener);
    btnShowTotalValueByChain.setActionCommand("SHOW_TOTAL_VALUE_BY_CHAIN");

    btnDeleteRange = new JButton("Eliminar Rango");
    this.add(btnDeleteRange);
    btnDeleteRange.addActionListener(listener);
    btnDeleteRange.setActionCommand("DELETE_RANGE");

  }
}
