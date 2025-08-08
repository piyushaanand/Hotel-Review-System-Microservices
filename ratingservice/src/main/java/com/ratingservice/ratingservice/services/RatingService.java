package com.ratingservice.ratingservice.services;

import java.util.List;

import com.ratingservice.ratingservice.models.entinies.Rating;

public interface RatingService {

    //Create Ratings
    Rating create(Rating rating);

    //get all ratings
    List<Rating> getAll();

    //get by user id
    List<Rating> getRatingByUser(String userId);

    //get all by hotel
    List<Rating> getAllRatingByHotel(String hotelId);
}
