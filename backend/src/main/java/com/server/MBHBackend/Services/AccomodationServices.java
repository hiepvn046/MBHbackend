/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.Accomodation;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Viktor Vu
 */
public interface AccomodationServices {

    List<Accomodation> findAll();

    Accomodation findById(Long id);

    Accomodation save(Accomodation accommodation);

    void deleteById(Long id);
    
    Page<Accomodation> searchAccomodation(String accEmail, String city, String state, String postcode, String keywords, String type, Integer page);
}
