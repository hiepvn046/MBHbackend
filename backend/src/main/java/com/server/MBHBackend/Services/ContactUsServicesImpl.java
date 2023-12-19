/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.ContactUs;
import com.server.MBHBackend.Repositories.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Viktor Vu
 */
@Service
public class ContactUsServicesImpl implements ContactUsServices{
    private final ContactUsRepository repository;

    @Autowired
    public ContactUsServicesImpl(ContactUsRepository repository) {
        this.repository = repository;
    }
    
    
    @Override
    public void saveContact(ContactUs contactus) {
        repository.save(contactus);
    }

}
