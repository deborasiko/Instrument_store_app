package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame{
    private JButton customerButton;
    private JButton adminButton;

    public View()
    {
        this.setBounds(100, 100, 643, 432);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel title = new JLabel("Instrument store");
        title.setFont(new Font("Something",Font.PLAIN, 22));
        title.setBounds(230, 21, 180, 40);
        this.getContentPane().add(title);

        customerButton = new JButton("Customer");
        customerButton.setFont(new Font("Something", Font.PLAIN, 16));
        customerButton.setBounds(100, 200, 125, 30);
        //customerButton.addActionListener(this);
        this.getContentPane().add(customerButton);


        adminButton = new JButton("Admin");
        adminButton.setFont(new Font("Something", Font.PLAIN, 16));
        adminButton.setBounds(418, 200, 125, 30);
        //adminButton.addActionListener(this);
        this.getContentPane().add(adminButton);


        this.setVisible(true);
    }

    public void addCustomerListener(ActionListener a){
        customerButton.addActionListener(a);
    }

    public void addAdminListener(ActionListener a){
        adminButton.addActionListener(a);
    }

    public boolean customerPushed(ActionEvent e){
        if(e.getSource()==customerButton){
            return true;
        }
        else return false;
    }

    public boolean adminPushed(ActionEvent e){
        if(e.getSource()==adminButton){
            return true;
        }
        else return false;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
