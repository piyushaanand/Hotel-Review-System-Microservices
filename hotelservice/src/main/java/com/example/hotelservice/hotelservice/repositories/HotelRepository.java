package com.example.hotelservice.hotelservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotelservice.hotelservice.models.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, String> {
    
}
