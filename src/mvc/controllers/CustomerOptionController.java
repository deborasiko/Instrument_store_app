package mvc.controllers;

import mvc.views.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.time.*;

import static java.lang.Integer.parseInt;
public class CustomerOptionController {
    CustomerOptionWindow myOptions;
    int customerId;

    public CustomerOptionController(CustomerOptionWindow customer,int cid) {
        this.customerId = cid;
        this.myOptions = customer;
        this.myOptions.addCloseListener(new CreateListener());
        this.myOptions.addFindListener(new CreateListener());
        this.myOptions.addCreateSaleListener(new CreateListener());
        this.myOptions.addAddSaleListener(new CreateListener());
    }

    class CreateListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (myOptions.closePushed(e)) {
                myOptions.dispose();
            }
            if (myOptions.findPushed(e)) {
                try {
                    String categoryText = myOptions.getCategory();
                    Connection1 optionCtrl = new Connection1();
                    int categoryId = optionCtrl.getCategoryId(categoryText);
                    ResultSet resultSet = optionCtrl.getContentCategory(categoryId);
                    while (resultSet.next()) {
                        String name = resultSet.getString("product_name");
                        String productId = resultSet.getString("product_id");
                        String brand = resultSet.getString("brand_name");
                        String country = resultSet.getString("country");
                        myOptions.addRow(name, parseInt(productId), brand, country);
                    }

                } catch (Exception exception) {
                    myOptions.showMessage(exception.toString());
                }
            }
            if(myOptions.createPushed(e)){
                try{
                    Connection1 createCtrl = new Connection1();
                    int maxiSale = createCtrl.getMaxSaleID();
                    createCtrl.insertSale(customerId,"card", "in process", maxiSale+1);
                    myOptions.showMessage("Done");
                }catch(Exception exc){
                    myOptions.showMessage("itt " + exc.toString());
                }
            }
            if(myOptions.addSalePushed(e)){
                try{
                    Connection1 addCtrl = new Connection1();
                    int maxiSale = addCtrl.getMaxSaleID();
                    String productText = myOptions.getProductId();
                    int productId = parseInt(productText);
                    String nrText = myOptions.getNr();
                    int nr = parseInt(nrText);
                    int maxiItem = addCtrl.getMaxiSaleItemId();
                    addCtrl.insertSaleItem(productId,maxiSale,nr,maxiItem+1);
                    myOptions.showMessage("Done");
                }catch(Exception newException){
                    myOptions.showMessage(newException.toString());
                }
            }
        }
    }
}
