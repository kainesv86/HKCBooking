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
public class HistoryService {

    public static boolean isValidDateBooking(ArrayList<History> histories, Date inputCheckIn, Date inputCheckOut) {
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

            if (history.getStartDate().after(inputCheckIn) && (history.getEndDate().before(inputCheckOut))) {
                return false;
            }

            if ((history.getStartDate().after(inputCheckOut)) && (history.getEndDate().before(inputCheckOut))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidDateInput(Date inputCheckIn, Date inputCheckOut) {
        return inputCheckIn.before(inputCheckOut);
    }
}
