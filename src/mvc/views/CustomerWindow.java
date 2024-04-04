package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CustomerWindow extends  JFrame{
    private JTextField uName;
    private JTextField pass;
    private JButton login;

    private JButton register;

    private JButton close;

    public CustomerWindow() {
        this.setBounds(100, 100, 643, 432);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel username = new JLabel("Username:");
        username.setBounds(50, 50, 80, 40);
        username.setFont(new Font("uname", Font.PLAIN, 16));
        this.getContentPane().add(username);

        this.uName = new JTextField();
        this.uName.setBounds(140, 50, 200, 40);
        this.getContentPane().add(uName);

        JLabel password = new JLabel("Password:");
        password.setBounds(50, 100, 80, 40);
        password.setFont(new Font("passw", Font.PLAIN, 16));
        this.getContentPane().add(password);

        this.pass = new JTextField();
        this.pass.setBounds(140, 100, 200, 40);
        this.getContentPane().add(pass);

        this.login = new JButton("Log in");
        this.login.setBounds(140, 160, 100, 30);
        this.getContentPane().add(login);

        this.register = new JButton("Register");
        this.register.setBounds(200, 260, 200, 30);
        this.getContentPane().add(register);

        this.close = new JButton("Close");
        this.close.setBounds(250, 300, 100, 30);
        this.getContentPane().add(close);

        this.setVisible(true);
    }
    public void addCCListener(ActionListener a){close.addActionListener(a);}
    public boolean ccPushed(ActionEvent e){
        return e.getSource() == close;
    }
    public void addLCListener(ActionListener a){login.addActionListener(a);}

    public boolean lcPushed(ActionEvent e){
        return e.getSource() == login;
    }

    public void addRCListener(ActionListener a){register.addActionListener(a);}

    public boolean rcPushed(ActionEvent e){
        return e.getSource() == register;
    }

    public String getUserNameCustomer(){
        return this.uName.getText();
    }

    public String getPassWordCustomer(){
        return this.pass.getText();
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
