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
public class Room {

    private Integer roomId;
    private Integer roomTypeId;
    private String description;
    private float price;
    private String urlImage;
    private String roomStatus;

    public Room() {
    }

    public Room(Integer roomId, Integer roomTypeId, String description, float price, String urlImage, String roomStatus) {
        this.roomId = roomId;
        this.roomTypeId = roomTypeId;
        this.description = description;
        this.price = price;
        this.urlImage = urlImage;
        this.roomStatus = roomStatus;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

}
