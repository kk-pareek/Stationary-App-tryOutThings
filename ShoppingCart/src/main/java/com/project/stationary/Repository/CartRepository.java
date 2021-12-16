package com.project.stationary.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stationary.Model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
}
