package com.si2.ecommerce_si2_martinez.service;

import com.si2.ecommerce_si2_martinez.exception.UserException;
import com.si2.ecommerce_si2_martinez.model.User;

public interface UserService {


    public User findUserById(Long userId) throws UserException;

    public User findUserProfileByJwt(String jwt) throws UserException;


}
