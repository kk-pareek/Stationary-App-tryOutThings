package com.project.stationary.Repository;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.stationary.Model.Cart;

@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
}
