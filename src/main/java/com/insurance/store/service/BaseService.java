package com.insurance.store.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.insurance.store.model.BaseEntity;
import com.insurance.store.repository.GenericRepository;


public abstract class BaseService<T extends BaseEntity,ID extends Long>  {
@Autowired
protected GenericRepository<T,ID>  repository;

public <S extends T> S save(S entity) {
    return repository.save(entity);
}

public <S extends T> List<S> saveAll(Iterable<S> entities) {
    return repository.saveAll(entities);
}

public List<T> findAll(Sort sort) {
    return repository.findAll(sort);
}

public Page<T> findAll(Pageable pageable) {
    return repository.findAll(pageable);
}

public List<T> findAll() {  
    return repository.findAll();
}

public List<T> findAllById(Iterable<ID> ids) {
    return repository.findAllById(ids);
}

public Optional<T> findById(ID id) {
    return repository.findById(id);
}

public boolean existsById(ID id) {
    return repository.existsById(id);
}

public long count() {
    return repository.count();
}

public void deleteById(ID id) {
    repository.deleteById(id);
}

public void delete(T entity) {
    repository.delete(entity);
}

public void deleteAllById(Iterable<? extends ID> ids) {
    repository.deleteAllById(ids);
}

public void deleteAll(Iterable<? extends T> entities) {
    repository.deleteAll(entities);
}

public void deleteAll() {
    repository.deleteAll();
}


}
