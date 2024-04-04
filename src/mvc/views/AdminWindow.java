package mvc.views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminWindow extends JFrame{
    private JLabel username;
    private JLabel password;
    private JTextField uName;
    private JTextField pass;
    private JButton login;

    private JButton close;
    public AdminWindow() {
        this.setBounds(100, 100, 643, 432);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(null);

        this.username = new JLabel("Username:");
        this.username.setBounds(50, 50, 80, 40);
        this.username.setFont(new Font("uname", Font.PLAIN, 16));
        this.getContentPane().add(username);

        this.uName = new JTextField();
        this.uName.setBounds(140, 50, 200, 40);
        this.getContentPane().add(uName);

        this.password = new JLabel("Password:");
        this.password.setBounds(50, 100, 80, 40);
        this.password.setFont(new Font("passw", Font.PLAIN, 16));
        this.getContentPane().add(password);

        this.pass = new JTextField();
        this.pass.setBounds(140, 100, 200, 40);
        this.getContentPane().add(pass);

        this.login = new JButton("Log in");
        this.login.setBounds(140, 160, 100, 30);
        this.getContentPane().add(login);

        this.close = new JButton("Close");
        this.close.setBounds(250, 300, 100, 30);
        this.getContentPane().add(close);


        this.setVisible(true);
    }
    public void addCloseListener(ActionListener a){
        close.addActionListener(a);
    }
    public boolean closeWindow(ActionEvent e){
        if(e.getSource()==close) return true;
        else return false;
    }

    public void addLoginListener(ActionListener a){
        login.addActionListener(a);
    }

    public boolean loginPushed(ActionEvent e){
        if(e.getSource()==login) return true;
        else return false;
    }

    public String getUsername(){
        return uName.getText();
    }
    public void setUsername(){

    }
    public String getPassword(){
        return pass.getText();
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
}
