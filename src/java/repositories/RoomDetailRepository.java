/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Room;
import entities.RoomDetail;
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
public class RoomDetailRepository {

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

    public ArrayList<RoomDetail> getAllHistoryDetail() throws SQLException, Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT \n"
                    + "    roomId,\n"
                    + "    [description],\n"
                    + "    price,\n"
                    + "    urlImage,\n"
                    + "    roomStatus,\n"
                    + "    hkcbooking_room_type.roomTypeId,\n"
                    + "    roomName,\n"
                    + "    capacity,\n"
                    + "    acreage\n"
                    + "FROM hkcbooking_room\n"
                    + "LEFT JOIN hkcbooking_room_type\n"
                    + "ON hkcbooking_room.roomTypeId = hkcbooking_room_type.roomTypeId";

            preStm = repo.prepareStatement(sql);

            rs = preStm.executeQuery();
            ArrayList<RoomDetail> list = new ArrayList<RoomDetail>();
            while (rs.next()) {

                Integer roomId = rs.getInt("roomId");
                String description = rs.getString("description");
                Float price = rs.getFloat("price");
                String urlImage = rs.getString("urlImage");
                String roomStatus = rs.getString("roomStatus");

                Integer roomTypeId = rs.getInt("roomTypeId");
                String roomName = rs.getString("roomName");
                Integer capacity = rs.getInt("capacity");
                Integer acreage = rs.getInt("acreage");

                Room room = new Room(roomId, roomTypeId, description, price, urlImage, roomStatus);
                RoomType roomType = new RoomType(roomTypeId, roomName, capacity, acreage);

                list.add(new RoomDetail(room, roomType));
            }

            return list;
        } finally {
            this.closeRepo();
        }
    }
}
