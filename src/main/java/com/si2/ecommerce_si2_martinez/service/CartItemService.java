package com.si2.ecommerce_si2_martinez.service;

import com.si2.ecommerce_si2_martinez.exception.CartItemException;
import com.si2.ecommerce_si2_martinez.exception.UserException;
import com.si2.ecommerce_si2_martinez.model.Cart;
import com.si2.ecommerce_si2_martinez.model.CartItem;
import com.si2.ecommerce_si2_martinez.model.Product;

public interface CartItemService {

     public CartItem createCartItem(CartItem cartItem);

     public CartItem updateCartItem(Long userId,Long id,CartItem cartItem) throws CartItemException, UserException;


     public CartItem isCartItemExist(Cart cart, Product product,String size, Long userId);

     public void removeCartItem(Long userId,Long cartItemId) throws CartItemException, UserException;

      public CartItem findCartItemById(Long cartItemId) throws CartItemException;



}
