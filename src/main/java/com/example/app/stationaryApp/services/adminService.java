package com.example.app.stationaryApp.services;

import com.example.app.stationaryApp.entities.Admin;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface adminService {
    List<Admin> getAdmin();
    Admin createAdmin(Admin admin);
    Admin geAdminById(Integer adminId);
    Admin updateAdminById(Integer adminId, Admin admin);
    Admin deleteAdminById(Integer adminId);
}
