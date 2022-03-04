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
public class RoomDetail {

    private Room room;
    private RoomType roomType;

    public RoomDetail(Room room, RoomType roomType) {
        this.room = room;
        this.roomType = roomType;
    }

    public RoomDetail() {
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
