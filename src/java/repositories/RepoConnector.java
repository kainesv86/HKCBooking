/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author kaine
 */
public class RepoConnector {

    public static Connection connectDatabase() {
<<<<<<< HEAD
        Connection connection = null;
        String id = "localhost";
        String instanceName = "MSSQLSERVER";
        String port = "1433";
        String db = "HKCBooking";
        String username = "sa";
        String password = "1234567890";

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
=======
        try {
            Context context = new InitialContext();
            Context end = (Context) context.lookup("java:comp/env");
            DataSource env = (DataSource) end.lookup("DatabaseConfig");
            Connection conn = env.getConnection();
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
>>>>>>> 1e519d4dcc98669fe3533a103c3c608df080446c
    }
}
