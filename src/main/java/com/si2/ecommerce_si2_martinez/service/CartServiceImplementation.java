package com.si2.ecommerce_si2_martinez.service;

import com.si2.ecommerce_si2_martinez.exception.ProductException;
import com.si2.ecommerce_si2_martinez.model.Cart;
import com.si2.ecommerce_si2_martinez.model.CartItem;
import com.si2.ecommerce_si2_martinez.model.Product;
import com.si2.ecommerce_si2_martinez.model.User;
import com.si2.ecommerce_si2_martinez.repository.CartRepository;
import com.si2.ecommerce_si2_martinez.request.AddItemRequest;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImplementation implements CartService{

    private CartRepository cartRepository;
    private CartItemService cartItemService;
    private ProductService productService;
    public CartServiceImplementation(CartRepository cartRepository, CartItemService cartItemService,ProductService productService) {
        this.cartRepository = cartRepository;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    @Override
    public Cart createCart(User user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cartRepository.save(cart);
    }

    @Override
    public String addCartItem(Long userId, AddItemRequest req) throws ProductException {
        Cart cart =cartRepository.findByUserId(userId);
        Product product = productService.findProductById(req.getProductId());

        CartItem isPresent=cartItemService.isCartItemExist(cart,product,req.getSize(),userId);
        if(isPresent==null){
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCart(cart);
            cartItem.setQuantity(req.getQuantity());
            cartItem.setUserId(userId);

            int price = req.getQuantity()*product.getDiscountedPrice();
            cartItem.setPrice(price);
            cartItem.setSize(req.getSize());

            CartItem  createdCartItem = cartItemService.createCartItem(cartItem);
            cart.getCartIems().add(createdCartItem);
        }
        return "Item Add To Cart";
    }

    @Override
    public Cart findUserCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId);

        int totalPrice = 0;
        int totalDiscountedPrice= 0;
        int totalItem = 0;

        for(CartItem cartItem : cart.getCartIems()){
            totalPrice=totalPrice+cartItem.getPrice();
            totalDiscountedPrice = totalDiscountedPrice+cartItem.getDiscountedPrice();
            totalItem=totalItem+cartItem.getQuantity();
        }

        cart.setTotalDiscountedPrice(totalDiscountedPrice);
        cart.setTotalItem(totalItem);
        cart.setTotalPrice(totalPrice);
        cart.setDiscounte(totalPrice-totalDiscountedPrice);

        return cartRepository.save(cart);
    }
}
