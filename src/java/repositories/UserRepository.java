/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.User;
import entities.UserLogin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import utils.ConnectDB;

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
            String sql = "SELECT * FROM hkcbooking_user";
            preStm = repo.prepareStatement(sql);
            rs = preStm.executeQuery();
            ArrayList<User> list = new ArrayList<User>();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
//                list.add(new User(username, password));
            }
            return list;
        } finally {
            this.closeRepo();
        }
    }

    public UserLogin checkLoginAccounts(String username, String password) {
        try {
            String query = "SELECT * FROM hkcbooking_user where username= ? and password= ?";
            repo = new ConnectDB().getConnection();
            preStm = repo.prepareStatement(query);
            preStm.setString(1, username);
            preStm.setString(2, password);
            rs = preStm.executeQuery();
            while (rs.next()) {
                UserLogin u = new UserLogin(rs.getString(2), rs.getString(3));
                return u;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public User getUserByUsername(String username) {
        try {
            String query = "SELECT * FROM hkcbooking_user where username= ?";
            repo = new ConnectDB().getConnection();
            preStm = repo.prepareStatement(query);
            preStm.setString(1, username);
            rs = preStm.executeQuery();
            while (rs.next()) {
                User u = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                         rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8));
                return u;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
