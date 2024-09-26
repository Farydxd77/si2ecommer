package com.si2.ecommerce_si2_martinez.service;


import com.si2.ecommerce_si2_martinez.exception.ProductException;
import com.si2.ecommerce_si2_martinez.model.Rating;
import com.si2.ecommerce_si2_martinez.model.User;
import com.si2.ecommerce_si2_martinez.request.RatingRequest;
import org.springframework.stereotype.Service;

import java.util.List;


public interface RatingService {

    public Rating createRating(RatingRequest req, User user)throws ProductException;
    public List<Rating> getProductsRating(Long productId);


}
