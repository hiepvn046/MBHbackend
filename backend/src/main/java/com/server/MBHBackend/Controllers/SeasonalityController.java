/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Controllers;

import com.server.MBHBackend.Models.Cropsdistrict;
import com.server.MBHBackend.Models.SeasonalityRequest;
import com.server.MBHBackend.Services.CropsdistrictServices;
import org.springframework.data.domain.Page;
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
@RequestMapping("/api/seasonality")
@CrossOrigin(origins = "*")
public class SeasonalityController {

    private final CropsdistrictServices cropsdistrictServices;

    public SeasonalityController(CropsdistrictServices cropsdistrictServices) {
        this.cropsdistrictServices = cropsdistrictServices;
    }

    @PostMapping
    public ResponseEntity<Page<Cropsdistrict>> searchSeasonality(@RequestBody SeasonalityRequest getQueryTerms) {

        String crop_name = getQueryTerms.getIndustry();
        String town = getQueryTerms.getCity();
        String state = getQueryTerms.getState();
        String postcode = getQueryTerms.getPostcode();
        Integer page = getQueryTerms.getPage();
        Integer size = getQueryTerms.getSize();
        return ResponseEntity.ok(cropsdistrictServices.searchSeasonality(crop_name, town, state, postcode, page, size));
    }

}
