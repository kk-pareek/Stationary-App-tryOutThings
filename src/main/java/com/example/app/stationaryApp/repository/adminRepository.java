package com.example.app.stationaryApp.repository;

import com.example.app.stationaryApp.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface adminRepository extends JpaRepository<Admin,Integer> {
}
