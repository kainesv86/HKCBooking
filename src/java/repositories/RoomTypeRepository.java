/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.RoomType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kaine
 */
public class RoomTypeRepository {

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

    public RoomType getRoomTypeById(Integer id) throws Exception {
        try {
            String query = "SELECT * FROM hkcbooking_room_type where roomTypeId=?";
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(query);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            while (rs.next()) {
                RoomType room = new RoomType(rs.getInt("roomTypeId"), rs.getString("roomName"), rs.getInt("capacity"), rs.getInt("acreage"));
                return room;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.closeRepo();
        }
        return null;
    }

    public ArrayList<RoomType> getAllRoomType() throws Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT * FROM hkcbooking_room_type";
            preStm = repo.prepareStatement(sql);
            rs = preStm.executeQuery();

            ArrayList<RoomType> list = new ArrayList<RoomType>();
            while (rs.next()) {

                Integer roomTypeId = rs.getInt("roomTypeId");
                String roomName = rs.getString("roomName");
                Integer capacity = rs.getInt("capacity");
                Integer acreage = rs.getInt("acreage");

                list.add(new RoomType(roomTypeId, roomName, capacity, acreage));
            }
            return list;
        } finally {
            this.closeRepo();
        }
    }
    public boolean addRoomType(RoomType roomType) {
        String INSERT_USER_SQL = "INSERT INTO hkcbooking_room_type"
                + "(roomTypeId,roomName,capacity,acreage) VALUES"
                + "(?,?,?,?)";
        try {
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(INSERT_USER_SQL);
            preStm.setInt(1, roomType.getRoomTypeId());
            preStm.setString(2, roomType.getRoomName());
            preStm.setInt(3, roomType.getCapacity());
            preStm.setInt(4, roomType.getAcreage());
            preStm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    
    public boolean checkRoomTypeExist(int roomTypeId,String RoomName) {
        String CHECK_TYPE_SQL = "SELECT RoomName FROM hkcbooking_room_type "
                + "WHERE RoomTypeID =? OR RoomName=?";
        try {
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(CHECK_TYPE_SQL);
            preStm.setInt(1, roomTypeId);
            preStm.setString(2, RoomName);
            preStm.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
