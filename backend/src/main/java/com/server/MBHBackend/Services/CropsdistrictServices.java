/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.Cropsdistrict;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Viktor Vu
 */
public interface CropsdistrictServices {

    List<Cropsdistrict> findAll();

    Cropsdistrict findById(Long id);

    Cropsdistrict save(Cropsdistrict cropsdistrict);

    void deleteById(Long id);
    
    Page<Cropsdistrict> searchSeasonality(String crop_name, String town, String state, String postcode, Integer page, Integer size);
}
