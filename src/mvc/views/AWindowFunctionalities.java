package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AWindowFunctionalities extends JFrame{

    private JTextField productName;
    private JTextField brandId;
    private JTextField categoryId;
    private JButton submitButton;

    private JButton closeButton;

    public AWindowFunctionalities() {
        this.setBounds(100, 50, 643, 432);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);


        JLabel destLabel = new JLabel("Product name:");
        destLabel.setFont(new Font("del", Font.PLAIN, 16));
        destLabel.setBounds(30, 50, 180, 25);
        this.getContentPane().add(destLabel);

        productName = new JTextField();
        productName.setBounds(210, 50, 120, 25);
        this.getContentPane().add(productName);

        JLabel dateLabel = new JLabel("Brand ID:");
        dateLabel.setFont(new Font("del", Font.PLAIN, 16));
        dateLabel.setBounds(30, 75, 180, 25);
        this.getContentPane().add(dateLabel);

        brandId = new JTextField();
        brandId.setBounds(210, 75, 120, 25);
        this.getContentPane().add(brandId);

        JLabel dtimeLabel = new JLabel("Category ID:");
        dtimeLabel.setFont(new Font("del", Font.PLAIN, 16));
        dtimeLabel.setBounds(30, 100, 180, 25);
        this.getContentPane().add(dtimeLabel);

        categoryId = new JTextField();
        categoryId.setBounds(210, 100, 120, 25);
        this.getContentPane().add(categoryId);

        submitButton = new JButton("Submit");
        submitButton.setBounds(210, 125, 100, 25);
        this.getContentPane().add(submitButton);

        closeButton = new JButton("Back");
        closeButton.setBounds(0, 0, 80, 25);
        this.getContentPane().add(closeButton);

        this.setVisible(true);

    }
    public void addCloseListener(ActionListener a){
        closeButton.addActionListener(a);
    }
    public boolean closeWindow(ActionEvent e){
        if(e.getSource()==closeButton) {
            return true;
        }
        else return false;
    }
    public void addSubmitListener(ActionListener a){submitButton.addActionListener(a);}

    public boolean submitPushed(ActionEvent e){
        if(e.getSource()==submitButton){
            return true;
        }
        else return false;
    }

    public String getName(){
        return this.productName.getText();
    }
    public String getBrandId(){
        return this.brandId.getText();
    }
    public String getCategoryId(){
        return this.categoryId.getText();
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
