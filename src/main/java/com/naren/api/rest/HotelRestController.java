package com.naren.api.rest;

import com.naren.domain.Hotel;
import com.naren.service.HotelService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelRestController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("sayHello")
    public String sayHello(){
        return "hello";
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    Hotel getHotel(@ApiParam(value = "The ID of the hotel.", required = true)
                   @PathVariable("id") Long id) throws Exception {
        Hotel hotel = this.hotelService.getHotel(id);
        //todo: http://goo.gl/6iNAkz
        return hotel;
    }
}
