package com.sps.services;

import com.sps.entities.User;
import com.sps.helper.ApiResponse;

public interface SPSService {
    public ApiResponse addUser(User user);
}
