package mvc.controllers;

import mvc.views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminController {
    private AdminWindow myAdmin;
    public AdminController(AdminWindow admin){
        this.myAdmin = admin;
        this.myAdmin.addCloseListener(new CreateListener());
        this.myAdmin.addLoginListener(new CreateListener());

    }
    class CreateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(myAdmin.closeWindow(e)){
                myAdmin.dispose();
            }
            if(myAdmin.loginPushed(e)){
                try{
                    //Admin adminInfo = new Admin();
                    String uNameInside = "admin";
                    String passWInside = "1234cgdaeh";
                    String userNameText = myAdmin.getUsername();
                    String passWordText = myAdmin.getPassword();
                    if(uNameInside.equals(userNameText) && passWInside.equals(passWordText)){
                        AWindowFunctionalities aFunctions = new AWindowFunctionalities();
                        AWFcontroller awfContr = new AWFcontroller(aFunctions);
                    }
                    else{
                        myAdmin.showMessage("Incorrect username or password");
                    }

                }catch(Exception exc){
                    myAdmin.showMessage(exc.toString());
                }
            }
        }
    }
}
