package com.si2.ecommerce_si2_martinez.service;


import com.si2.ecommerce_si2_martinez.exception.ProductException;
import com.si2.ecommerce_si2_martinez.model.Product;
import com.si2.ecommerce_si2_martinez.model.Review;
import com.si2.ecommerce_si2_martinez.model.User;
import com.si2.ecommerce_si2_martinez.repository.ProductRepository;
import com.si2.ecommerce_si2_martinez.repository.ReviewRepository;
import com.si2.ecommerce_si2_martinez.request.ReviewRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewServiceImplementation implements ReviewService {


    private ReviewRepository reviewRepository;
    private ProductRepository productRepository;
    private ProductService productService;

    public ReviewServiceImplementation(ReviewRepository reviewRepository, ProductRepository productRepository, ProductService productService) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
        this.productService = productService;
    }
    @Override
    public Review createReview(ReviewRequest req, User user) throws ProductException {
        Product product = productService.findProductById(req.getProductId());

        Review review = new Review();
        review.setProduct(product);
        review.setUser(user);
        review.setReview(req.getReview());
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    @Override
    public List<Review> getAllReview(Long productId) {


        return reviewRepository.getAllProductsReview(productId);
    }
}
