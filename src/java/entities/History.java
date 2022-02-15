/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.sql.Date;

/**
 *
 * @author Kaine
 */
public class History {

    private Integer userId;
    private String message;
    private String historyStatus;
    private Integer roomId;
    private Date startDate;
    private Date endDate;
    private String note;
    private Float total;

    public History(Integer userId, String message, String historyStatus, Integer roomId, Date startDate, Date endDate, String note, Float total) {
        this.userId = userId;
        this.message = message;
        this.historyStatus = historyStatus;
        this.roomId = roomId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.note = note;
        this.total = total;
    }

    public History() {
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
