package com.userservice.userservice.externalservices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.userservice.userservice.models.Hotel;

@FeignClient(name = "HOTELSERVICE")
public interface HotelService 
{
    @GetMapping("/hotels/{hotelId}")
    Hotel getHotel(@PathVariable("hotelId") String hotelId);
    
}
