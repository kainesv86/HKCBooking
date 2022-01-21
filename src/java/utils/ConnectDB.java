
package utils;

import java.sql.Connection;
import java.sql.DriverManager;


public class ConnectDB {

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName=" + dbName;
        if (instance == null || instance.trim().isEmpty()) {
            url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        }
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        ConnectDB db = new ConnectDB();
        System.out.println("db");
    }
//        String url ="jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=ProductManagement";
    String serverName = "localhost\\SQLEXPRESS";
    String dbName = "HKCBooking";
    String portNumber = "1433";
    String instance = "";
    String userID = "sa";
    String password = "1234567890";

}
