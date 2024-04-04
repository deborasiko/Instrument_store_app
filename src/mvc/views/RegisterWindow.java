package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterWindow extends JFrame {
    private JTextField fullName;
    private JTextField email;
    private JTextField username;
    private JTextField password;
    private JTextField repeatPassword;
    private JButton registration;
    private JButton close;

    public RegisterWindow() {
        this.setBounds(10, 100, 643, 432);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        JLabel nameLabel = new JLabel("Name(first,last):");
        nameLabel.setFont(new Font("del", Font.PLAIN, 16));
        nameLabel.setBounds(30, 150, 150, 25);
        this.getContentPane().add(nameLabel);

        this.fullName = new JTextField();
        this.fullName.setBounds(150, 150, 120, 25);
        this.getContentPane().add(fullName);

        JLabel emailLabel = new JLabel("email:");
        emailLabel.setFont(new Font("del", Font.PLAIN, 16));
        emailLabel.setBounds(30, 175, 100, 25);
        this.getContentPane().add(emailLabel);

        this.email = new JTextField();
        this.email.setBounds(150, 175, 120, 25);
        this.getContentPane().add(email);

        JLabel userLabel = new JLabel("username:");
        userLabel.setFont(new Font("del", Font.PLAIN, 16));
        userLabel.setBounds(30, 200, 100, 25);
        this.getContentPane().add(userLabel);

        this.username = new JTextField();
        this.username.setBounds(150, 200, 120, 25);
        this.getContentPane().add(username);

        JLabel passwordLabel = new JLabel("password:");
        passwordLabel.setFont(new Font("del", Font.PLAIN, 16));
        passwordLabel.setBounds(30, 225, 100, 25);
        this.getContentPane().add(passwordLabel);

        this.password = new JTextField();
        this.password.setBounds(150, 225, 120, 25);
        this.getContentPane().add(password);

        JLabel repeatpwLabel = new JLabel("repeat pword:");
        repeatpwLabel.setFont(new Font("del", Font.PLAIN, 16));
        repeatpwLabel.setBounds(30, 250, 120, 25);
        this.getContentPane().add(repeatpwLabel);

        this.repeatPassword = new JTextField();
        this.repeatPassword.setBounds(150, 250, 120, 25);
        this.getContentPane().add(repeatPassword);

        this.registration = new JButton("Submit");
        this.registration.setBounds(30, 280, 240, 25);
        this.getContentPane().add(registration);

        this.close = new JButton("Back");
        this.close.setBounds(30, 30, 120, 25);
        this.getContentPane().add(close);

        this.setVisible(true);
    }

    public String getEmail(){
        return this.email.getText();
    }
    public String getUser(){
        return this.username.getText();
    }
    public String getPass(){
        return this.password.getText();
    }
    public String getRepeated(){
        return this.repeatPassword.getText();
    }

    public String getName(){
        return this.fullName.getText();
    }
    public void addRegisterListener(ActionListener a){registration.addActionListener(a);}
    public boolean regPushed(ActionEvent e){
        if(e.getSource()==registration) return true;
        else return false;
    }

    public void addBackListener(ActionListener a){close.addActionListener(a);}
    public boolean backPushed(ActionEvent e){
        if(e.getSource()==close) return true;
        else return false;
    }
    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
