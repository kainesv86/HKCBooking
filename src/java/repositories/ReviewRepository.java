/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Review;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Kaine
 */
public class ReviewRepository {

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

    public boolean addReview(Review review) {

        String sql = "INSERT INTO hkcbooking_review"
                + "(roomId, fullname, comment, rate) VALUES "
                + "(?,?,?,?)";
        try {
            repo = RepoConnector.connectDatabase();
            preStm = repo.prepareStatement(sql);
            preStm.setInt(1, review.getRoomId());
            preStm.setString(2, review.getFullname());
            preStm.setString(3, review.getComment());
            preStm.setInt(4, review.getRate());
            preStm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<Review> getReviewByRoomId(Integer roomId) throws SQLException, Exception {
        try {
            repo = RepoConnector.connectDatabase();
            String sql = "SELECT reviewId, roomId, fullname, comment, rate FROM hkcbooking_review WHERE roomId=?";
            preStm = repo.prepareStatement(sql);
            preStm.setInt(1, roomId);
            rs = preStm.executeQuery();
            ArrayList<Review> list = new ArrayList<Review>();
            while (rs.next()) {
                Integer reviewId = rs.getInt("reviewId");
                roomId = rs.getInt("roomId");
                String fullname = rs.getString("fullname");
                String comment = rs.getString("comment");
                Integer rate = rs.getInt("rate");

                list.add(new Review(reviewId, roomId, fullname, comment, rate));
            }
            return list;
        } finally {
            this.closeRepo();
        }
    }
}
