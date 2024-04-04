package mvc.controllers;

import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.*;

import static java.lang.Integer.parseInt;

public class Connection1 {
    String url =  "jdbc:postgresql://localhost:5432/instrument";
    String username = "postgres";
    String password = "12345678";
    Connection connection = DriverManager.getConnection(url,username,password);
    Statement statement = connection.createStatement();

    String tableBrands= "\"brands\"";
    String tableCategories= "\"categories\"";
    String tableCustomer = "\"customer\"";
    String tableCa = "\"customer_address\"";
    String tableProducts = "\"products\"";
    String tableSi = "\"sale_items\"";
    String tableSales = "\"sales\"";
    String tableSl = "\"stock_levels\"";
    String tableSuppliers = "\"suppliers\"";

    public Connection1() throws SQLException {
    }
    public void insertUserQuery(String email, String username, String password, String fullName, int customerid)throws SQLException{
        String userQuery = "insert into customer values ('" + customerid + "' , '" + email + "','" + username + "','" + password + "','" + fullName + "')";
        this.statement.executeUpdate(userQuery);
    }

    public ResultSet userInfoQuery(String user, String password) throws SQLException{
        String userInfoQuery = "select * from customer where username = '" + user + "' and password='" + password + "'" ;
        //this.statement.executeQuery(userInfoQuery);
        ResultSet result = this.statement.executeQuery(userInfoQuery);
        return result;
    }

    public int miniId() throws SQLException {
        String q = "select MAX(customer_id) as minimum from customer";
        ResultSet result = this.statement.executeQuery(q);
        result.next();
        int maxi = result.getInt("minimum");
        return maxi;
    }

    public int getCategoryId(String name) throws SQLException {
        String q= "Select category_id from categories where category_name = '" + name + "'";
        ResultSet result = this.statement.executeQuery(q);
        result.next();
        String idText = result.getString("category_id");
        int id = parseInt(idText);
        return id;
    }

    public ResultSet getContentCategory(int category) throws SQLException {
        String q="select product_name,product_id,brand_name,country from products join brands b on b.brand_id = products.brand_id where products.category_id='" + category + "'";
        ResultSet result = this.statement.executeQuery(q);
        return result;
    }

    public int maxiPID() throws SQLException {
        String q = "select MAX(product_id) as maxi from products";
        ResultSet result = this.statement.executeQuery(q);
        result.next();
        int maxi = result.getInt("maxi");
        return maxi;
    }

    public void insertProduct(String name, int brand, int category, int id) throws SQLException {
        String q="insert into products values('" + name + "','" + brand + "','" + category + "','" + id + "')";
        this.statement.executeUpdate(q);
    }

    public int getMaxSaleID()throws SQLException{
        String q="select MAX(sale_id) as maxi from sales";
        ResultSet result = this.statement.executeQuery(q);
        result.next();
        int maxi = result.getInt("maxi");
        return maxi;
    }

    public void insertSale(int cid, String method, String status, int sid)throws SQLException{
        String q="insert into sales values('" + cid + "','" + method + "','" + status + "','" + sid + "')";
        this.statement.executeUpdate(q);
    }

    public int getMaxiSaleItemId()throws SQLException{
        String q="select MAX(sale_item_id) as maxi from sale_items";
        ResultSet result = this.statement.executeQuery(q);
        result.next();
        int maxi = result.getInt("maxi");
        return maxi;
    }

    public void insertSaleItem(int productId, int saleId, int nr, int saleItemId)throws SQLException{
        String q="insert into sale_items values('" + productId + "','" + saleId + "','" + nr + "','" + saleItemId + "')";
        this.statement.executeUpdate(q);
    }

}
