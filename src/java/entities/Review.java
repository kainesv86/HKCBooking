/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

public class Review {

    private Integer reviewId;
    private Integer roomId;
    private String fullname;
    private String comment;
    private Integer rate;

    public Review() {
    }

    public Review(Integer reviewId, Integer roomId, String fullname, String comment, Integer rate) {
        this.reviewId = reviewId;
        this.roomId = roomId;
        this.fullname = fullname;
        this.comment = comment;
        this.rate = rate;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

}
