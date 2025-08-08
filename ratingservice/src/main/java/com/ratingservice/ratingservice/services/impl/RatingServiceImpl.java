package com.ratingservice.ratingservice.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ratingservice.ratingservice.models.entinies.Rating;
import com.ratingservice.ratingservice.repositories.RatingRepo;
import com.ratingservice.ratingservice.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService{

    @Autowired
    private RatingRepo ratingRepo;


    @Override
    public Rating create(Rating rating) {
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getAll() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingByUser(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotel(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
    
}
