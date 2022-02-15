/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.CartItem;
import entities.Room;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.Date;
import java.sql.Date;

/**
 *
 * @author DELL
 */
public class CartItemRepository {

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

//    public ArrayList<CartItem> getAllCartItem() throws SQLException, Exception {
//        try {
//            repo = RepoConnector.connectDatabase();
//            String sql = "SELECT * FROM hkcbooking_history";
//            preStm = repo.prepareStatement(sql);
//            rs = preStm.executeQuery();
//
//            ArrayList<CartItem> list = new ArrayList<CartItem>();
//            while (rs.next()) {
//
//                Date startDate = rs.getDate("startDate");
//                Date endDate = rs.getDate("endDate");
//                Float total = rs.getFloat("total");
//                Integer roomID = rs.getInt("roomID");
//                RoomRepository rr = new RoomRepository();
//                Room rtr = rr.getRoomById(roomID);
//                list.add(new CartItem(rtr, startDate, endDate, total));
//            }
//            return list;
//        } finally {
//            this.closeRepo();
//        }
//    }
//    public CartItem getRoomByDate(Date startDate, Date endDate) {
//        try {
//            String query = "SELECT * FROM hkcbooking_history where startDate=? AND endDate=?";
//            repo = RepoConnector.connectDatabase();
//            preStm = repo.prepareStatement(query);
//            preStm.setDate(1, startDate);
//            preStm.setDate(2, endDate);
//            rs = preStm.executeQuery();
//            if (startDate.compareTo(endDate) < 0) {
//                return null;
//            }
//            while (rs.next()) {
//                CartItem room = new CartItem(rs.getInt("roomID")a
//                , rs.getString("roomName")
//                , rs.getInt("capacity")
//                , rs.getInt("acreage")
//                );
//                return room;
//            }
//
//        } catch (Exception e) {
//            System.out.println(e);
//        } finally {
//            this.closeRepo();
//        }
//        return null;
//    }
}
