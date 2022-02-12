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
}
