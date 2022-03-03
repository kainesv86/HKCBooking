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
                + "(userId,message,historyStatus,fullname,phone,address,roomId,startDate,endDate,note,total) VALUES"
                + "(?,?,?,?,?,?,?,?,?,?,?)";

        try {
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(INSERT_USER_SQL);
            preStm.setInt(1, history.getUserId());
            preStm.setString(2, history.getMessage());
            preStm.setString(3, history.getHistoryStatus());
            preStm.setString(4, history.getFullname());
            preStm.setString(5, history.getPhone());
            preStm.setString(6, history.getAddress());
            preStm.setInt(7, history.getRoomId());
            preStm.setDate(8, history.getStartDate());
            preStm.setDate(9, history.getEndDate());
            preStm.setString(10, history.getNote());
            preStm.setFloat(11, history.getTotal());

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
            String sql = "SELECT * FROM hkcbooking_history ORDER BY historyId DESC";
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

    public ArrayList<History> getAllHistoryByRoomId(Integer roomId) throws SQLException, Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT * FROM hkcbooking_history WHERE roomId=? ORDER BY historyId DESC";
            preStm = repo.prepareStatement(sql);
            preStm.setInt(1, roomId);
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
                roomId = rs.getInt("roomId");

                list.add(new History(historyId, userId, message, historyStatus, fullName, phone, address, roomId, startDate, endDate, note, total));

            }
            return list;
        } finally {
            this.closeRepo();
        }
    }

    public ArrayList<History> getAllHistoryByUserId(Integer userId) throws SQLException, Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT * FROM hkcbooking_history WHERE userId=? ORDER BY historyId DESC";
            preStm = repo.prepareStatement(sql);
            preStm.setInt(1, userId);
            rs = preStm.executeQuery();
            ArrayList<History> list = new ArrayList<History>();
            while (rs.next()) {
                Integer historyId = rs.getInt("historyId");
                userId = rs.getInt("userId");
                String message = rs.getString("message");
                String historyStatus = rs.getString("historyStatus");
                String fullName = rs.getString("fullName");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Integer roomId = rs.getInt("roomId");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String note = rs.getString("note");
                Float total = rs.getFloat("total");

                list.add(new History(historyId, userId, message, historyStatus, fullName, phone, address, roomId, startDate, endDate, note, total));

            }
            return list;
        } finally {
            this.closeRepo();
        }
    }

    public History getRoomByDate(Date d1, Date d2) throws SQLException, Exception {
        try {
            String sql = "SELECT * FROM hkcbooking_history where startDate=? AND endDate=? ORDER BY historyId DESC";
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

    public boolean updateHistoryByAdmin(History history) throws Exception {

        Connection repo = null;
        try {
            String query = "UPDATE hkcbooking_history SET message=?,"
                    + "historyStatus=? WHERE historyId=?";
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(query);
            if (repo != null) {
                preStm = repo.prepareStatement(query);
                preStm.setString(1, history.getMessage());
                preStm.setString(2, history.getHistoryStatus());
                preStm.setInt(3, history.getHistoryId());
                preStm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (repo != null) {
                repo.close();
            }
        }
        return false;
    }

    public boolean updateNoteHistory(History history) throws Exception {

        Connection repo = null;
        try {
            String query = "UPDATE hkcbooking_history SET note=?"
                    + " WHERE historyId=?";
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(query);
            if (repo != null) {
                preStm = repo.prepareStatement(query);
                preStm.setString(1, history.getNote());
                preStm.setInt(2, history.getHistoryId());
                preStm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (repo != null) {
                repo.close();
            }
        }
        return false;
    }

    public boolean updateHistoryByBookingCancel(History history) throws Exception {

        Connection repo = null;
        try {
            String query = "UPDATE hkcbooking_history SET historyStatus=?"
                    + " WHERE historyId=? AND userId=?";
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(query);
            if (repo != null) {
                preStm = repo.prepareStatement(query);
                preStm.setString(1, history.getHistoryStatus());
                preStm.setInt(2, history.getHistoryId());
                preStm.setInt(3, history.getUserId());
                preStm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (repo != null) {
                repo.close();
            }
        }
        return false;
    }

    public boolean updateHistoryByDeleteRoom(History history) throws Exception {

        Connection repo = null;
        try {
            String query = "UPDATE hkcbooking_history \n"
                    + "SET historyStatus = 'CANCEL',\n"
                    + "[message] = ? \n"
                    + "WHERE startDate >= ? AND roomId=? AND historyStatus <> 'CANCEL' ";

            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(query);
            if (repo != null) {
                preStm = repo.prepareStatement(query);
                preStm.setString(1, history.getMessage());
                preStm.setDate(2, history.getStartDate());
                preStm.setInt(3, history.getRoomId());

                System.out.println(preStm.executeUpdate());
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (preStm != null) {
                preStm.close();
            }
            if (repo != null) {
                repo.close();
            }
        }
        return false;
    }
}
