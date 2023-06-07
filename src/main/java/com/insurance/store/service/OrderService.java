package com.insurance.store.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.store.model.Order;
import com.insurance.store.model.Product;
import com.insurance.store.model.User;
import com.insurance.store.repository.OrderRepository;

@Service 
public class OrderService  extends BaseService<Order,Long> {
@Autowired
private OrderRepository orderRepository;

public boolean existsByUserAndProduct(User user, Product product) {
    return orderRepository.existsByUserAndProduct(user, product);
}


}
