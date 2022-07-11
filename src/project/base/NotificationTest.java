package project.base;
import java.sql.*;

public class NotificationTest {
    public static void main(String args[]) throws Exception
    {
        //Declare JDBC Driver
        String JDBC_DRIVER = "org.postgresql.Driver";


        //Connection String
        //String connStr = "jdbc:postgresql://host/database
        //Username=HR, Password=HR, IP=localhost, IP=1521, SID=xe
        String user = "ycftweud";
        String pass = "hvdEIVLY901iezCnu-FIulM9cdroaOAE";
        String connStr = "jdbc:postgresql://tiny.db.elephantsql.com/ycftweud";
        Class.forName("org.postgresql.Driver");

        // Create two distinct connections, one for the notifier
        // and another for the listener to show the communication
        // works across connections although this example would
        // work fine with just one connection.

        Connection lConn = DriverManager.getConnection(connStr,user,pass);


//        DBListener listener = new DBListener(lConn);
//        listener.start();
    }
}