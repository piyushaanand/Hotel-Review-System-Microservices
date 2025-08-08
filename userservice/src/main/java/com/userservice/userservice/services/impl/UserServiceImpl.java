package com.userservice.userservice.services.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.userservice.userservice.exceptions.ResourceNotFoundExceptions;
import com.userservice.userservice.externalservices.HotelService;
import com.userservice.userservice.models.Hotel;
import com.userservice.userservice.models.Rating;
import com.userservice.userservice.models.entities.User;
import com.userservice.userservice.repositories.UserRepository;
import com.userservice.userservice.services.UserService;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;


    private Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        List<User> user = userRepository.findAll();
        for(User u : user){
            Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+u.getUserId(), Rating[].class);
            List<Rating> ratingList = new ArrayList<>(Arrays.asList(ratings));
            for(Rating r : ratingList){
                // ResponseEntity<Hotel> response = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+r.getHotelId(), Hotel.class);
                // Hotel hotel = response.getBody();
                Hotel hotel = hotelService.getHotel(r.getHotelId());
                r.setHotel(hotel);
            }
            u.setRatings(ratingList);
        }
        return user;
    }

    @Override
    public User getUser(String userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundExceptions("User with given id is not on the server !! :" + userId));


        //fetch rating of the above users 
        //http://localhost:8093/ratings/users/d8af07a0-64f8-4bdb-ad44-944fb296ea21

        Rating[] ratings = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/"+user.getUserId(), Rating[].class);
        logger.info("{} ", ratings);

        List<Rating> ratingss = Arrays.stream(ratings).toList();

        //fetch hotel and put
        List<Rating> ratingList = ratingss.stream().map(rating -> {
            // ResponseEntity<Hotel> forEntity =  restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(), Hotel.class);
            // Hotel hotel = forEntity.getBody();
            Hotel hotel = hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingss);
        return user;    
    }
    
}
