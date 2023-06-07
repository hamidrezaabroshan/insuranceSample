package com.insurance.store.repository;

import org.springframework.stereotype.Repository;

import com.insurance.store.model.User;

@Repository 
public interface UserRepository extends GenericRepository<User,Long>   {

}
