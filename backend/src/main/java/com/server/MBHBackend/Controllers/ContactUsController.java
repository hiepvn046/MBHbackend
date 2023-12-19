/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Controllers;

import com.server.MBHBackend.Models.ContactUs;
import com.server.MBHBackend.Services.ContactUsServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Viktor Vu
 */
@RestController
@RequestMapping("/api/contactus")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContactUsController {

    private final ContactUsServices services;

    public ContactUsController(ContactUsServices services) {
        this.services = services;
    }
    
    @PostMapping
    public ResponseEntity<String> contactUs(@RequestBody ContactUs contactus) {
        services.saveContact(contactus);
        return ResponseEntity.ok("Success!");
    }
}
