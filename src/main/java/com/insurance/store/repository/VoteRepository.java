package com.insurance.store.repository;

import org.springframework.stereotype.Repository;

import com.insurance.store.model.Vote;

@Repository 
public interface VoteRepository  extends GenericRepository<Vote,Long> {

}
