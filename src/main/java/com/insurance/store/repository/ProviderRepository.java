package com.insurance.store.repository;

import org.springframework.stereotype.Repository;

import com.insurance.store.model.Provider;

@Repository 
public interface ProviderRepository  extends GenericRepository<Provider,Long> {

}
