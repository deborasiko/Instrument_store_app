package mvc.views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerOptionWindow extends JFrame{
    private JButton find;
    private JComboBox categories;
    private JTable productTable = new JTable();
    private JScrollPane panel;
    private DefaultTableModel productModel = new DefaultTableModel();
    private JButton closeButton;
    private String categoriesArray[] = {"Idiophones", "Membranophones", "String instruments", "Wind instruments", "Electric instruments"};
    private JButton createSale;
    private JTextField productId;
    private JTextField nr;
    private JButton addButton;
    public CustomerOptionWindow() {
        this.setBounds(100, 10, 1000, 800);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel selection = new JLabel("Please select a category:");
        selection.setBounds(30, 40, 200, 25);
        selection.setFont(new Font("uname", Font.PLAIN, 16));
        this.getContentPane().add(selection);

        categories = new JComboBox<>(categoriesArray);
        categories.setFont(new Font("plain", Font.PLAIN, 16));
        categories.setBounds(230,40,210,25);
        this.getContentPane().add(categories);

        find = new JButton("Find");
        find.setBounds(450, 40, 100, 25);
        find.setFont(new Font("uname", Font.PLAIN, 16));
        this.getContentPane().add(find);

        productTable.setModel(productModel);
        productModel.addColumn("Product name");
        productModel.addColumn("Product id");
        productModel.addColumn("Brand");
        productModel.addColumn("Country of origin");
        productTable.setFont(new Font("show",Font.PLAIN,16));
        productTable.setRowHeight(25);
        panel = new JScrollPane(productTable);
        panel.setBounds(30,80,900,400);
        this.getContentPane().add(panel);

        closeButton = new JButton("Back");
        closeButton.setFont(new Font("show",Font.PLAIN,14));
        closeButton.setBounds(0,0,100,20);
        this.getContentPane().add(closeButton);

        createSale =  new JButton("Create Sale");
        createSale.setFont(new Font("show",Font.PLAIN,14));
        createSale.setBounds(30,490,200,20);
        this.getContentPane().add(createSale);

        JLabel productLabel = new JLabel("Product id:");
        productLabel.setFont(new Font("show",Font.PLAIN,14));
        productLabel.setBounds(30,510,100,20);
        this.getContentPane().add(productLabel);

        productId = new JTextField();
        productId.setBounds(130,510,100,20);
        this.getContentPane().add(productId);

        JLabel productNrLabel = new JLabel("nr:");
        productNrLabel.setFont(new Font("show",Font.PLAIN,14));
        productNrLabel.setBounds(30,530,100,20);
        this.getContentPane().add(productNrLabel);

        nr = new JTextField();
        nr.setBounds(130,530,100,20);
        this.getContentPane().add(nr);

        addButton =  new JButton("Add to sale");
        addButton.setFont(new Font("show",Font.PLAIN,14));
        addButton.setBounds(30,550,200,20);
        this.getContentPane().add(addButton);


        this.setVisible(true);
    }
    public void addCloseListener(ActionListener a){closeButton.addActionListener(a);}
    public boolean closePushed(ActionEvent e){
        return e.getSource() == closeButton;
    }

    public void addFindListener(ActionListener a){find.addActionListener(a);}

    public boolean findPushed(ActionEvent e){
        if(e.getSource()==find) return true;
        else return false;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    public void addRow(String name, int id, String brand, String country){
        panel = new JScrollPane();
        productModel.addRow(new Object[]{name, id, brand, country});
    }


    public String getCategory(){
        return (String)categories.getSelectedItem();
    }
    public String getProductId(){
        return this.productId.getText();
    }
    public String getNr(){
        return this.nr.getText();
    }
    public void addCreateSaleListener(ActionListener a){createSale.addActionListener(a);}
    public boolean createPushed(ActionEvent e){
        return e.getSource()==createSale;
    }
    public void addAddSaleListener(ActionListener a){addButton.addActionListener(a);}
    public boolean addSalePushed(ActionEvent e){
        return e.getSource()==addButton;
    }
}
