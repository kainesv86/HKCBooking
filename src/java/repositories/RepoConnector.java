/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author kaine
 */
public class RepoConnector {

    public static Connection connectDatabase() {
        Connection connection = null;
        String id = "localhost";
        String instanceName = "SQLEXPRESS";
        String port = "1433";
        String db = "HKC";
        String username = "sa";
        String password = "1";

        String urlDatabase = String.format("jdbc:sqlserver://%s\\%s:%s;databaseName=%s;user=%s;password=%s", id, instanceName, port, db, username, password);

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(urlDatabase);
            System.out.println("Connection to database successfull");
        } catch (SQLException error) {
            error.printStackTrace();
        } catch (ClassNotFoundException error) {
            error.printStackTrace();
        }

        return connection;
    }
}
