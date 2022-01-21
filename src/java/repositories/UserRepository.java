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
import java.sql.SQLException;
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
//                list.add(new User(username, password));
            }
            return list;
        } finally {
            this.closeRepo();
        }
    }
    public int registerUser(User user)throws ClassNotFoundException, SQLException {
        
        
        String INSERT_USER_SQL ="INSERT INTO hkcbooking_user"+
                "(username,password,fullname,address,phone,role,email) VALUES" +
                "(?,?,?,?,?,?,?)";
        int result = 0;
        try {
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(INSERT_USER_SQL);
            preStm.setString(1, user.getUsername());
            preStm.setString(2, user.getPassword());
            preStm.setString(3, user.getFullname());
            preStm.setString(4, user.getAddress());
            preStm.setString(5, user.getPhone());
            preStm.setString(6, user.getRole());
            preStm.setString(7, user.getEmail());
            
            
            result = preStm.executeUpdate();
            preStm.setString(result, INSERT_USER_SQL);
            System.out.println(preStm);
           
        } catch (Exception e) {
        }
                return result;
        
    }
}
