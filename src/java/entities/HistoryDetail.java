/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Kaine
 */
public class HistoryDetail {

    private Integer userId;
    private History history;
    private Room room;
    private RoomType roomType;

    public HistoryDetail(Integer userId, History history, Room room, RoomType roomType) {
        this.userId = userId;
        this.history = history;
        this.room = room;
        this.roomType = roomType;
    }

    public HistoryDetail() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public History getHistory() {
        return history;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

}
