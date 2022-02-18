/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.History;
import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author Kaine
 */
public class RoomService {

    public static boolean isValidDateBooking(Date inputCheckIn, Date inputCheckOut, ArrayList<History> histories) {
        for (History history : histories) {

            if (history.getStartDate().equals(inputCheckIn) || history.getEndDate().equals(inputCheckIn)) {
                return false;
            }

            if (history.getStartDate().equals(inputCheckOut) || history.getEndDate().equals(inputCheckOut)) {
                return false;
            }

            if (inputCheckIn.after(history.getStartDate()) && (inputCheckIn.before(history.getEndDate()))) {
                return false;
            }

            if (inputCheckOut.after(history.getStartDate()) && (inputCheckOut.before(history.getEndDate()))) {
                return false;
            }

            if (inputCheckIn.after(history.getStartDate()) && (inputCheckIn.before(history.getEndDate()))) {
                return false;
            }

            if (inputCheckOut.after(history.getStartDate()) && (inputCheckOut.before(history.getEndDate()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDateInput(Date inputCheckIn, Date inputCheckOut) {
        return inputCheckIn.before(inputCheckOut);
    }
}
