package com.ratingservice.ratingservice.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ratingservice.ratingservice.models.entinies.Rating;
import java.util.List;


@Repository
public interface RatingRepo extends MongoRepository<Rating, String>{
    
    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
