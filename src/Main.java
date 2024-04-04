import mvc.views.*;
import mvc.controllers.*;
import javax.swing.*;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        View myView = new View();
        ViewController contr = new ViewController(myView);

        Connection1 myC = new Connection1();
    }
}