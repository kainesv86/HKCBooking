/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Review;
import java.util.ArrayList;

/**
 *
 * @author kaine
 */
public class ReviewService {

    public static Float reviewRateOverall(ArrayList<Review> reviews) {

        Float sum = Float.valueOf("0");
        for (Review review : reviews) {
            sum += review.getRate();
        }
        if (reviews.size() > 0) {
            return sum / reviews.size();
        }

        return sum;
    }
}
