/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.Accomodation;
import com.server.MBHBackend.Models.Farmbusiness;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Viktor Vu
 */
public interface FarmbusinessServices {

    List<Farmbusiness> findAll();

    Farmbusiness findById(Long id);

    Farmbusiness save(Farmbusiness farmbusiness);

    void deleteById(Long id);
    
    Page<Farmbusiness> searchFarmbusiness(String accEmail, String city, String state, String postcode, String keywords, String industry, Integer page);
}
