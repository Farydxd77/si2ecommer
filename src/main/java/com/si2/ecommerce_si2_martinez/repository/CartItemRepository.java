package com.si2.ecommerce_si2_martinez.repository;

import com.si2.ecommerce_si2_martinez.model.Cart;
import com.si2.ecommerce_si2_martinez.model.CartItem;
import com.si2.ecommerce_si2_martinez.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    @Query("SELECT ci From CartItem ci Where ci.cart=:cart And ci.product=:product And ci.size=:size And ci.userId=:userId")
    public CartItem isCartItemExist(@Param("cart")Cart cart, @Param("product") Product product, @Param("size")String  size, @Param("userId")Long userId);


}
