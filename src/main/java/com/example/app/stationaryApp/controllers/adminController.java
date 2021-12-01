package com.example.app.stationaryApp.controllers;

import com.example.app.stationaryApp.entities.Admin;
import com.example.app.stationaryApp.services.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class adminController {

  private adminService theAdminService;

  @Autowired
  public adminController(adminService theAdminService) {
    this.theAdminService = theAdminService;
  }

  @GetMapping
  public ResponseEntity<String> applicationStatus(){
    return new ResponseEntity<>("Admin-Service is up", HttpStatus.OK);
  }

  @GetMapping("admin")
  public ResponseEntity<List<Admin>> getAdmin(){
    return new ResponseEntity<>(theAdminService.getAdmin(),HttpStatus.OK);
  }

  @GetMapping("create")
  public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin){
    return new ResponseEntity<>(theAdminService.createAdmin(admin),HttpStatus.CREATED);
  }

  @GetMapping("{id}")
  public ResponseEntity<Admin> getAdminById(@PathVariable("id") Integer adminId){
    return new ResponseEntity<>(theAdminService.geAdminById(adminId),HttpStatus.FOUND);
  }

  @PutMapping("update/{id}")
  public ResponseEntity<Admin> updateAdmin(@PathVariable("id") Integer adminId, @RequestBody Admin admin){
    return new ResponseEntity<>(theAdminService.updateAdminById(adminId, admin),HttpStatus.OK);
  }

  @PutMapping("delete/{id}")
  public ResponseEntity<Admin> deleteAdmin(@PathVariable("id") Integer adminId, @RequestBody Admin admin){
    return new ResponseEntity<>(theAdminService.deleteAdminById(adminId),HttpStatus.OK);
  }

}
