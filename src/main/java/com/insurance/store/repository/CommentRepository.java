package com.insurance.store.repository;

import org.springframework.stereotype.Repository;

import com.insurance.store.model.Comment;

@Repository 
public interface CommentRepository  extends GenericRepository<Comment,Long> {

}
