/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RoomRepository {

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

    public ArrayList<Room> getAllRoom() throws Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT * FROM hkcbooking_room";
            preStm = repo.prepareStatement(sql);
            rs = preStm.executeQuery();

            ArrayList<Room> list = new ArrayList<Room>();
            while (rs.next()) {
                Integer roomId = rs.getInt("roomId");
                Integer roomTypeId = rs.getInt("roomTypeId");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                String urlImage = rs.getString("urlImage");
                String roomStatus = rs.getString("roomStatus");
                list.add(new Room(roomId, roomTypeId, description, price, urlImage, roomStatus));
            }
            return list;
        } finally {
            this.closeRepo();
        }
    }

    public Room getRoomById(Integer id) throws Exception {
        try {
            String query = "SELECT * FROM hkcbooking_room where roomId=?";
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(query);
            preStm.setInt(1, id);
            rs = preStm.executeQuery();
            while (rs.next()) {
                Integer roomId = rs.getInt("roomId");
                Integer roomTypeId = rs.getInt("roomTypeId");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                String urlImage = rs.getString("urlImage");
                String roomStatus = rs.getString("roomStatus");
                Room room = new Room(roomId, roomTypeId, description, price, urlImage, roomStatus);
                return room;
            }

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            this.closeRepo();
        }
        return null;
    }

    public boolean addRoom(Room room) {
        String INSERT_USER_SQL = "INSERT INTO hkcbooking_room"
                + "(roomTypeId,price,urlImage,description,roomStatus) VALUES"
                + "(?,?,?,?,?)";
        try {
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(INSERT_USER_SQL);
            preStm.setInt(1, room.getRoomTypeId());
            preStm.setFloat(2, room.getPrice());
            preStm.setString(3, room.getUrlImage());
            preStm.setString(4, room.getDescription());
            preStm.setString(5, room.getRoomStatus());
            preStm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;

    }
}
