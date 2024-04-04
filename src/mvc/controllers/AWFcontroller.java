package mvc.controllers;

import mvc.views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.*;

import static java.lang.Integer.parseInt;

public class AWFcontroller {
    AWindowFunctionalities myFunctions;
    public AWFcontroller(AWindowFunctionalities function){
        this.myFunctions = function;
        this.myFunctions.addSubmitListener(new CreateListener());
        this.myFunctions.addCloseListener(new CreateListener());

    }
    class CreateListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(myFunctions.closeWindow(e)){
                myFunctions.dispose();
            }
            if(myFunctions.submitPushed(e)){
                try{
                    String name = myFunctions.getName();
                    String brandText = myFunctions.getBrandId();
                    int bid = parseInt(brandText);
                    String categoryText = myFunctions.getCategoryId();
                    int cid = parseInt(categoryText);
                    Connection1 awfConnect = new Connection1();
                    int maxiPid = awfConnect.maxiPID();
                    awfConnect.insertProduct(name,bid,cid,maxiPid+1);
                    myFunctions.showMessage("Done!");

                }catch(Exception exc){
                    myFunctions.showMessage(exc.toString());
                }
            }
        }
    }
}
