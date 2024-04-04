package mvc.controllers;
import mvc.views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewController {
    private View myView;
    public ViewController(View view){

        this.myView = view;

        //this.myView.addCustomerListener(new CreateListener());
        this.myView.addCustomerListener(new CreateListener());
        this.myView.addAdminListener(new CreateListener());
    }

    class CreateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if(myView.customerPushed(e)){
               CustomerWindow customer1 = new CustomerWindow();
               CustomerController customControll = new CustomerController(customer1);
            }
            if(myView.adminPushed(e)){
                AdminWindow admin1 = new AdminWindow();
                AdminController adminCont = new AdminController(admin1);
            }
        }
    }
}
