/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;


public class History {

    private Integer historyId;
    private Integer userId;
    private String message;
    private String historyStatus;
    private String fullname;
    private String phone;
    private String address;
    private Integer roomId;
    private Date startDate;
    private Date endDate;
    private String note;
    private Float total;


    public History() {
    }

    public History(Integer historyId, Integer userId, String message, String historyStatus, String fullname, String phone, String address, Integer roomId, Date startDate, Date endDate, String note, Float total) {
        this.historyId = historyId;
        this.userId = userId;
        this.message = message;
        this.historyStatus = historyStatus;
        this.fullname = fullname;
        this.phone = phone;
        this.address = address;

        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
        this.total = total;
    }

  public History() {

    }

    public Integer getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Integer historyId) {
        this.historyId = historyId
      }    

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
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
