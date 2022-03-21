/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.History;
import entities.Room;
import entities.RoomDetail;
import static java.lang.Float.NaN;
import java.sql.Date;
import java.util.ArrayList;
import repositories.HistoryRepository;
import variables.HistoryStatus;
import variables.RoomStatus;

/**
 *
 * @author Kaine
 */
public class RoomService {

    public static ArrayList<RoomDetail> filterRoomByDateBooking(ArrayList<RoomDetail> roomDetails, Date checkInDate, Date checkOutDate) throws Exception {

        HistoryRepository historyRepository = new HistoryRepository();

        for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {
            ArrayList<History> histories = historyRepository.getAllHistoryByRoomId(roomDetail.getRoom().getRoomId());

            histories = HistoryService.filterHistoryByStatus(histories, HistoryStatus.status.CANCEL, false);

            if (!histories.isEmpty() && !HistoryService.isValidDateBooking(histories, checkInDate, checkOutDate)) {
                roomDetails.remove(roomDetail);
            }
        }

        return roomDetails;
    }

    public static ArrayList<RoomDetail> filterRoomByStatus(ArrayList<RoomDetail> roomDetails, RoomStatus.status status) {
        for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {
            if (!roomDetail.getRoom().getRoomStatus().equals(status.toString())) {
                roomDetails.remove(roomDetail);
            }
        }
        return roomDetails;
    }

    public static ArrayList<RoomDetail> filterRoomByPriceBooking(ArrayList<RoomDetail> roomDetails, Float minValue, Float maxValue) throws Exception {
        if (minValue != null || maxValue != null) {
            if ((minValue != null && minValue.compareTo(NaN) != 0) && (maxValue != null && maxValue.compareTo(NaN) != 0)) {
                if (minValue > maxValue) {
                    roomDetails.clear();
                    return roomDetails;
                }

                if (minValue != null) {
                    for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {
                        if (roomDetail.getRoom().getPrice() < minValue) {
                            roomDetails.remove(roomDetail);
                        }

                    }
                }

                if (maxValue != null) {
                    for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {
                        if (roomDetail.getRoom().getPrice() > maxValue) {
                            roomDetails.remove(roomDetail);
                        }
                    }
                }
            } else {
                roomDetails.clear();
            }

        }
        return roomDetails;
    }

    public static ArrayList<RoomDetail> filterRoomByName(ArrayList<RoomDetail> roomDetails, String roomName) throws Exception {

        if (roomName != null) {
            for (RoomDetail roomDetail : (ArrayList<RoomDetail>) roomDetails.clone()) {
                if (!roomDetail.getRoomType().getRoomName().toLowerCase().contains(roomName.toLowerCase())) {
                    roomDetails.remove(roomDetail);
                }

            }
        }

        return roomDetails;
    }
}
