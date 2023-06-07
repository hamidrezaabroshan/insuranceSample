package com.insurance.store.repository;

import org.springframework.stereotype.Repository;

import com.insurance.store.model.Order;
import com.insurance.store.model.Product;
import com.insurance.store.model.User;

@Repository 
public interface OrderRepository extends GenericRepository<Order,Long>   {
    boolean existsByUserAndProduct(User user, Product product);
}
