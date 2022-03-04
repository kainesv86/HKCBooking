/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.History;
import entities.HistoryDetail;
import entities.Room;
import entities.RoomType;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kaine
 */
public class HistoryDetailRepository {

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

    public ArrayList<HistoryDetail> getAllHistoryDetail(String status) throws SQLException, Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT \n"
                    + "    userId,\n"
                    + "    historyId,\n"
                    + "    [message],\n"
                    + "    historyStatus,\n"
                    + "    fullname,\n"
                    + "    phone,\n"
                    + "    address,\n"
                    + "    startDate,\n"
                    + "    endDate,\n"
                    + "    note,\n"
                    + "    total,\n"
                    + "    hkcbooking_room.roomId,\n"
                    + "    [description],\n"
                    + "    price,\n"
                    + "    urlImage,\n"
                    + "    roomStatus,\n"
                    + "    hkcbooking_room_type.roomTypeId,\n"
                    + "    roomName,\n"
                    + "    capacity,\n"
                    + "    acreage\n"
                    + "FROM hkcbooking_history \n"
                    + "LEFT JOIN hkcbooking_room\n"
                    + "ON hkcbooking_history.roomId = hkcbooking_room.roomId\n"
                    + "LEFT JOIN hkcbooking_room_type\n"
                    + "ON hkcbooking_room_type.roomTypeId = hkcbooking_room.roomTypeId ORDER BY historyId DESC\n";

            if (status != null) {
                sql += "WHERE historyStatus=?";
            }
            preStm = repo.prepareStatement(sql);
            if (status != null) {
                preStm.setString(1, status);
            }

            rs = preStm.executeQuery();
            ArrayList<HistoryDetail> list = new ArrayList<HistoryDetail>();
            while (rs.next()) {
                Integer userId = rs.getInt("userId");

                Integer historyId = rs.getInt("historyId");
                String message = rs.getString("message");
                String historyStatus = rs.getString("historyStatus");
                String fullName = rs.getString("fullName");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String note = rs.getString("note");
                Float total = rs.getFloat("total");

                Integer roomId = rs.getInt("roomId");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                String urlImage = rs.getString("urlImage");
                String roomStatus = rs.getString("roomStatus");

                Integer roomTypeId = rs.getInt("roomTypeId");
                String roomName = rs.getString("roomName");
                Integer capacity = rs.getInt("capacity");
                Integer acreage = rs.getInt("acreage");

                History history = new History(historyId, userId, message, historyStatus, fullName, phone, address, roomId, startDate, endDate, note, total);
                Room room = new Room(roomId, roomTypeId, description, price, urlImage, roomStatus);
                RoomType roomType = new RoomType(roomTypeId, roomName, capacity, acreage);

                list.add(new HistoryDetail(userId, history, room, roomType));
            }
            return list;
        } finally {
            this.closeRepo();
        }
    }

    public ArrayList<HistoryDetail> getHistoryDetailByUserId(Integer userId, String status) throws SQLException, Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT \n"
                    + "    userId,\n"
                    + "    historyId,\n"
                    + "    [message],\n"
                    + "    historyStatus,\n"
                    + "    fullname,\n"
                    + "    phone,\n"
                    + "    address,\n"
                    + "    startDate,\n"
                    + "    endDate,\n"
                    + "    note,\n"
                    + "    total,\n"
                    + "    hkcbooking_room.roomId,\n"
                    + "    [description],\n"
                    + "    price,\n"
                    + "    urlImage,\n"
                    + "    roomStatus,\n"
                    + "    hkcbooking_room_type.roomTypeId,\n"
                    + "    roomName,\n"
                    + "    capacity,\n"
                    + "    acreage\n"
                    + "FROM hkcbooking_history \n"
                    + "LEFT JOIN hkcbooking_room\n"
                    + "ON hkcbooking_history.roomId = hkcbooking_room.roomId\n"
                    + "LEFT JOIN hkcbooking_room_type\n"
                    + "ON hkcbooking_room_type.roomTypeId = hkcbooking_room.roomTypeId\n"
                    + "WHERE userId=? ORDER BY historyId DESC";

            if (status != null) {
                sql += " AND historyStatus=?";
            }
            preStm = repo.prepareStatement(sql);
            preStm.setInt(1, userId);

            if (status != null) {
                preStm.setString(2, status);
            }

            rs = preStm.executeQuery();
            ArrayList<HistoryDetail> list = new ArrayList<HistoryDetail>();
            while (rs.next()) {
                userId = rs.getInt("userId");

                Integer historyId = rs.getInt("historyId");
                String message = rs.getString("message");
                String historyStatus = rs.getString("historyStatus");
                String fullName = rs.getString("fullName");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                Date startDate = rs.getDate("startDate");
                Date endDate = rs.getDate("endDate");
                String note = rs.getString("note");
                Float total = rs.getFloat("total");

                Integer roomId = rs.getInt("roomId");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                String urlImage = rs.getString("urlImage");
                String roomStatus = rs.getString("roomStatus");

                Integer roomTypeId = rs.getInt("roomTypeId");
                String roomName = rs.getString("roomName");
                Integer capacity = rs.getInt("capacity");
                Integer acreage = rs.getInt("acreage");

                History history = new History(historyId, userId, message, historyStatus, fullName, phone, address, roomId, startDate, endDate, note, total);
                Room room = new Room(roomId, roomTypeId, description, price, urlImage, roomStatus);
                RoomType roomType = new RoomType(roomTypeId, roomName, capacity, acreage);

                list.add(new HistoryDetail(userId, history, room, roomType));
            }
            return list;
        } finally {
            this.closeRepo();
        }
    }
}
