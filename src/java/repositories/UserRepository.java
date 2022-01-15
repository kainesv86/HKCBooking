/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author kaine
 */
public class UserRepository {

    private Connection repo;
    private PreparedStatement preStm;
    private ResultSet rs;

    public void closeRepo() throws Exception {
        if (rs != null) {
            rs.close();
        }
        if (preStm != null) {
            preStm.close();
        }
        if (repo != null) {
            repo.close();
        }
    }

    public ArrayList<User> getAllUser() throws Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT * FROM booking_user";
            preStm = repo.prepareStatement(sql);
            rs = preStm.executeQuery();
            ArrayList<User> list = new ArrayList<User>();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                list.add(new User(username, password));
            }
            return list;
        } finally {
            this.closeRepo();
        }
    }
}
