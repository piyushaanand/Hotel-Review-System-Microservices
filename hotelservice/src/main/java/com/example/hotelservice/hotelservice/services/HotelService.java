package com.example.hotelservice.hotelservice.services;

import java.util.List;

import com.example.hotelservice.hotelservice.models.entities.Hotel;

public interface HotelService {
    
    //Create
    Hotel create(Hotel hotel);

    //getAll
    List<Hotel> getAll();

    //get Single
    Hotel get(String id);
}
