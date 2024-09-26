package com.si2.ecommerce_si2_martinez.repository;

import com.si2.ecommerce_si2_martinez.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review,Long> {
    @Query("Select r from Review r where r.product.id=:productId")
    public List<Review> getAllProductsReview(@Param("productId") Long productId);

}
