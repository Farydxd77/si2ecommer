package com.si2.ecommerce_si2_martinez.model;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @OneToMany(mappedBy = "cart",cascade = CascadeType.ALL,orphanRemoval = true)
    @Column(name="cart_items")
    private Set<CartItem> cartItems = new HashSet<>();


    @Column(name = "total_price")
    private double totalPrice;

    @Column(name= "total_item")
    private int totalItem;

    private int totalDiscountedPrice;

    private int discounte;

    public Cart() {}

    public Cart(Long id, User user, Set<CartItem> cartItems, double totalPrice, int totalItem, int totalDiscountedPrice, int discounte) {
        this.id = id;
        this.user = user;
        this.cartItems = cartItems;
        this.totalPrice = totalPrice;
        this.totalItem = totalItem;
        this.totalDiscountedPrice = totalDiscountedPrice;
        this.discounte = discounte;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CartItem> getCartIems() {
        return cartItems;
    }

    public void setCartIems(Set<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getTotalItem() {
        return totalItem;
    }

    public void setTotalItem(int totalItem) {
        this.totalItem = totalItem;
    }

    public int getTotalDiscountedPrice() {
        return totalDiscountedPrice;
    }

    public void setTotalDiscountedPrice(int totalDiscountedPrice) {
        this.totalDiscountedPrice = totalDiscountedPrice;
    }

    public int getDiscounte() {
        return discounte;
    }

    public void setDiscounte(int discounte) {
        this.discounte = discounte;
    }
}
