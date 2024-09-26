package com.si2.ecommerce_si2_martinez.service;



import com.si2.ecommerce_si2_martinez.exception.OrderException;
import com.si2.ecommerce_si2_martinez.model.Address;
import com.si2.ecommerce_si2_martinez.model.Order;
import com.si2.ecommerce_si2_martinez.model.User;

import java.util.List;

public interface OrderService {

    public Order createOrder(User user, Address shippingAdress);

      public Order findOrderById(Long orderId) throws OrderException;

      public List<Order> usersOrderHistory(Long userId);

      public Order placedOrder(Long orderId) throws OrderException;

      public Order confirmedOrder(Long orderId)throws OrderException;

      public Order shippedOrder(Long orderId) throws OrderException;

      public Order deliveredOrder(Long orderId) throws OrderException;

      public Order cancledOrder(Long orderId) throws OrderException;

      public List<Order> getAllOrders();

      public void deleteOrder(Long orderId) throws OrderException;
}
