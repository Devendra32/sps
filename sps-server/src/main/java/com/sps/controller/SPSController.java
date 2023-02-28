package com.sps.controller;

import com.sps.entities.User;
import com.sps.exceptions.InvalidDataException;
import com.sps.helper.ApiResponse;
import com.sps.services.SPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/SPS01/api")
public class SPSController {
    @Autowired
    private SPSService spsService;

    //Add New User
    @PostMapping("/user")
    public ResponseEntity<?> addUser(@RequestBody User user) {
        try{
            ApiResponse apiResponse = this.spsService.addUser(user);
            if (apiResponse.getObj() != null) {
                return new ResponseEntity<>(apiResponse, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(apiResponse, HttpStatus.BAD_REQUEST);
            }
        }catch (InvalidDataException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }
}
