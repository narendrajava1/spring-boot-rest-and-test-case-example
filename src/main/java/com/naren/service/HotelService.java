package com.naren.service;
import com.naren.dao.jpa.HotelRepository;
import com.naren.domain.Hotel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class HotelService {

    private static final Logger log = LoggerFactory.getLogger(HotelService.class);

    @Autowired
    private HotelRepository hotelRepository;


    public HotelService() {
    }

    public Hotel createHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    public Hotel getHotel(long id) {
        List<Hotel> hotelList=new ArrayList<>();
        Hotel hotel=new Hotel();
        hotel.setId(1);
        hotel.setCity("Hyderabad");
        hotel.setName("Saravora INN");
        hotelList.add(hotel);
       return hotelList.stream().filter(hotelPrd->hotelPrd.getId()==1).findFirst().get();
    }

    public void updateHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    public void deleteHotel(Long id) {
        hotelRepository.deleteById(id);
    }

}
