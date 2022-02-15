/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.History;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DELL
 */
public class HistoryRepository {

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

    public boolean addHistory(History history) throws ClassNotFoundException, SQLException {

        String INSERT_USER_SQL = "INSERT INTO hkcbooking_history"
                + "(username,password,fullname,address,phone,role,email) VALUES"
                + "(?,?,?,?,?,?,?)";

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

            preStm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<History> getAllHistory() throws SQLException, Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT * FROM hkcbooking_history";
            preStm = repo.prepareStatement(sql);
            rs = preStm.executeQuery();
            ArrayList<History> list = new ArrayList<History>();
            while (rs.next()) {
                Integer historyId = rs.getInt("historyId");
                String message = rs.getString("message");
                String historyStatus = rs.getString("historyStatus");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String note = rs.getString("note");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Float total = rs.getFloat("total");
                Integer userId = rs.getInt("userId");
                Integer roomId = rs.getInt("roomId");

                list.add(new History(historyId, userId, message, historyStatus, fullName, phone, address, roomId, startDate, endDate, note, total));

            }
            return list;
        } finally {
            this.closeRepo();
        }
    }

    public History getRoomByDate(Date d1, Date d2) throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM hkcbooking_history where startDate=? AND endDate=?";
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(sql);
            preStm.setDate(1, d1);
            preStm.setDate(2, d2);
            rs = preStm.executeQuery();
            if (d1.compareTo(d2) < 0) {
                return null;
            }
            while (rs.next()) {

                Integer historyId = rs.getInt("historyId");
                String message = rs.getString("message");
                String historyStatus = rs.getString("historyStatus");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String note = rs.getString("note");
                String fullName = rs.getString("fullName");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                Float total = rs.getFloat("total");
                Integer userId = rs.getInt("userId");
                Integer roomId = rs.getInt("roomId");

                History h = new History(historyId, userId, message, historyStatus, fullName, phone, address, roomId, startDate, endDate, note, total);
                return h;

            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.closeRepo();
        }
        return null;
    }
}
