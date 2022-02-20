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
public class RoomType {

    private Integer roomTypeId;
    private String roomName;
    private Integer capacity;
    private Integer acreage;

    public RoomType(Integer roomTypeId, String roomName, Integer capacity, Integer acreage) {
        this.roomTypeId = roomTypeId;
        this.roomName = roomName;
        this.capacity = capacity;
        this.acreage = acreage;
    }

    public RoomType() {
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getAcreage() {
        return acreage;
    }

    public void setAcreage(Integer acreage) {
        this.acreage = acreage;
    }

}
