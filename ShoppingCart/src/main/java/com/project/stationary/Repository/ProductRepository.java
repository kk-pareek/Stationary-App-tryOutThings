package com.project.stationary.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.stationary.Model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
