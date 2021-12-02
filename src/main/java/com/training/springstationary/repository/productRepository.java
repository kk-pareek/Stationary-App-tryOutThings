package com.training.springstationary.repository;

import com.training.springstationary.entity.product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface productRepository extends CrudRepository<product,Integer>
{

}
