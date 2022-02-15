/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

public class History {

    private Integer historyID;
    User userID;
    private String message;
    private String historyStatus;
    private String fullname;
    private String phone;
    private String address;
    Room roomID;
    private Date startDate;
    private Date endDate;
    private String note;
    private Float total;

    public History() {
    }

    public History(Integer historyID, User userID, String message, String historyStatus, String fullname, String phone, String address, Room roomID, Date startDate, Date endDate, String note, Float total) {
        this.historyID = historyID;
        this.userID = userID;
        this.message = message;
        this.historyStatus = historyStatus;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;
        this.roomID = roomID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
        this.total = total;
    }

    public Integer getHistoryID() {
        return historyID;
    }

    public void setHistoryID(Integer historyID) {
        this.historyID = historyID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHistoryStatus() {
        return historyStatus;
    }

    public void setHistoryStatus(String historyStatus) {
        this.historyStatus = historyStatus;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Room getRoomID() {
        return roomID;
    }

    public void setRoomID(Room roomID) {
        this.roomID = roomID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

}
