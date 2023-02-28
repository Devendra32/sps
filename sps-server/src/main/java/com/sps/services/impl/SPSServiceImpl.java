package com.sps.services.impl;

import com.sps.entities.User;
import com.sps.exceptions.InvalidDataException;
import com.sps.helper.ApiResponse;
import com.sps.repository.UserRepository;
import com.sps.services.SPSService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SPSServiceImpl implements SPSService {
    @Autowired
    private UserRepository userRepo;
    @Autowired
    private ApiResponse apiResponse;

    @Override
    public ApiResponse addUser(User user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw new InvalidDataException("Email Already Exist!!!");
        } else if (userRepo.findByMobile(user.getMobile()).isPresent()) {
            throw new InvalidDataException("Mobile Already Exist!!!");
        } else {
            try {
                User savedUser = userRepo.save(user);
                apiResponse.setObj(savedUser);
                apiResponse.setMsg("User Successfully Registered!!!");
            } catch (RuntimeException e) {
                apiResponse.setObj(null);
                apiResponse.setMsg("User Registration Failed!!!");
            }
        }
        return apiResponse;
    }
}
