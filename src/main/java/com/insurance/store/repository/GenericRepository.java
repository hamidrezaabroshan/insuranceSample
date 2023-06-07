package com.insurance.store.repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.insurance.store.model.BaseEntity;

@Repository
public interface GenericRepository<T extends BaseEntity, ID extends Long> extends ListCrudRepository<T, ID>, ListPagingAndSortingRepository<T, ID> {

}
