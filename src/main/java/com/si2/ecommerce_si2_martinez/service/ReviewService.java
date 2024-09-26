package com.si2.ecommerce_si2_martinez.service;

import com.si2.ecommerce_si2_martinez.exception.ProductException;
import com.si2.ecommerce_si2_martinez.model.Review;
import com.si2.ecommerce_si2_martinez.model.User;
import com.si2.ecommerce_si2_martinez.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    public Review createReview(ReviewRequest req, User user) throws ProductException;
    public List<Review> getAllReview(Long productId);


}
