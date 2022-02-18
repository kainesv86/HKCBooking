/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.History;
import entities.Room;
import entities.RoomDetail;
import java.sql.Date;
import java.util.ArrayList;
import repositories.HistoryRepository;
import variables.roomStatus;

/**
 *
 * @author Kaine
 */
public class RoomService {

    public static ArrayList<RoomDetail> filterRoomByDateBooking(ArrayList<RoomDetail> roomDetails, Date checkInDate, Date checkOutDate) throws Exception {

        HistoryRepository historyRepository = new HistoryRepository();

        for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {
            ArrayList<History> histories = historyRepository.getAllHistoryByRoomId(roomDetail.getRoom().getRoomId());
            if (!histories.isEmpty() && !HistoryService.isValidDateBooking(histories, checkInDate, checkOutDate)) {
                roomDetails.remove(roomDetail);
            }
        }

        return roomDetails;
    }

    public static ArrayList<RoomDetail> filterRoomByStatus(ArrayList<RoomDetail> roomDetails, roomStatus.status status) {
        for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {
            if (!roomDetail.getRoom().getRoomStatus().equals(status.toString())) {
                roomDetails.remove(roomDetail);
            }
        }
        return roomDetails;
    }

}
