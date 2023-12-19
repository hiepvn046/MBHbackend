/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Security.user;

import com.server.MBHBackend.Services.DistrictsdetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Viktor Vu
 */
@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

    private final UserService services;
    private final DistrictsdetailServices districtsdetailServices;

    @Autowired
    public UserController(UserService services, DistrictsdetailServices districtsdetailServices) {
        this.services = services;
        this.districtsdetailServices = districtsdetailServices;
    }

    

    @GetMapping()
    public ResponseEntity<UserResponse> getUser(
            @RequestParam(value = "email", required = true, defaultValue = "") String email
    ) {
        return ResponseEntity.ok(services.findByEmail2(email));
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody UserResponse ures) {

        String name = ures.getDistrictsdetail().getName();
        String postcode = ures.getDistrictsdetail().getPostcode();
        String state = ures.getDistrictsdetail().getState();
        ures.setDistrictsdetail(districtsdetailServices.checkexists(name, postcode, state));
        services.updateUserByEmail2(ures);

        return ResponseEntity.ok("Update succesfully!");
    }
}
