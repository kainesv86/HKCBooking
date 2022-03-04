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
    }
}
