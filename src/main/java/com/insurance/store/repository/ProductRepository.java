package com.insurance.store.repository;

import org.springframework.stereotype.Repository;

import com.insurance.store.model.Product;

@Repository 
public interface ProductRepository  extends GenericRepository<Product,Long> {

}
