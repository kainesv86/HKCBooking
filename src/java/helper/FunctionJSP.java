/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entities.RoomType;
import java.util.ArrayList;

/**
 *
 * @author Kaine
 */
public class FunctionJSP {

    public static RoomType getRoomTypeById(ArrayList<RoomType> list, Integer id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRoomTypeId().equals(id)) {
                return list.get(i);
            }
        }
        return null;
    }
}
