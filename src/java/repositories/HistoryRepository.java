/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.History;
import entities.Room;
import entities.User;
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

    public ArrayList<History> getAllHistory() throws SQLException, Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT * FROM hkcbooking_history";
            preStm = repo.prepareStatement(sql);
            rs = preStm.executeQuery();
            ArrayList<History> list = new ArrayList<History>();
            while (rs.next()) {
                Integer historyID = rs.getInt("historyId");
                String message = rs.getString("message");
                String historyStatus = rs.getString("historyStatus");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String note = rs.getString("note");
                Float total = rs.getFloat("total");
                Integer userID = rs.getInt("userId");
                Integer roomID = rs.getInt("roomId");
                UserRepository ur = new UserRepository();
                User u = ur.getUserByUserId(userID);
                RoomRepository rr = new RoomRepository();
                Room r = rr.getRoomById(roomID);
                list.add(new History(historyID, u, message, historyStatus, r, startDate, endDate, note, total));

            }
            return list;
        } finally {
            this.closeRepo();
        }
    }
}
