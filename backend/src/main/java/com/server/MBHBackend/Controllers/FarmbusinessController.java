/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Controllers;

import com.server.MBHBackend.Models.Farmbusiness;
import com.server.MBHBackend.Services.DistrictsdetailServices;
import com.server.MBHBackend.Services.FarmbusinessServices;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Viktor Vu
 */

@RestController
@RequestMapping("/api/farmbusiness")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FarmbusinessController {

    private final FarmbusinessServices farmbusinessServices;
    
    private final DistrictsdetailServices districtsdetailServices;

    public FarmbusinessController(FarmbusinessServices farmbusinessServices, DistrictsdetailServices districtsdetailServices) {
        this.farmbusinessServices = farmbusinessServices;
        this.districtsdetailServices = districtsdetailServices;
    }

    

    @GetMapping
    public ResponseEntity<List<Farmbusiness>> getAllFarmbusiness() {
        return ResponseEntity.ok(farmbusinessServices.findAll());
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Farmbusiness> getFarmbusinessById(@PathVariable Long id) {
        return ResponseEntity.ok(farmbusinessServices.findById(id));
    }

    @PostMapping
    public ResponseEntity<Farmbusiness> createFarmbusiness(@RequestBody Farmbusiness farmbusiness) {
        String name = farmbusiness.getDistrictsDetails().getName();
        String postcode = farmbusiness.getDistrictsDetails().getPostcode();
        String state = farmbusiness.getDistrictsDetails().getState();
        farmbusiness.setDistrictsDetails(districtsdetailServices.checkexists(name, postcode, state));
        return new ResponseEntity<>(farmbusinessServices.save(farmbusiness), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Farmbusiness> updateFarmbusiness(@PathVariable Long id, @RequestBody Farmbusiness farmbusiness) {
        farmbusiness.setId(id); // Ensure the ID in the DTO matches the path variable
        return ResponseEntity.ok(farmbusinessServices.save(farmbusiness));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFarmbusiness(@PathVariable Long id) {
        farmbusinessServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/search")
    public ResponseEntity<Page<Farmbusiness>> searchFarmbusiness(
            @RequestParam(value = "accEmail", required = false, defaultValue ="") String accEmail,
            @RequestParam(value = "city", required = false, defaultValue = "") String city,
            @RequestParam(value = "state", required = false, defaultValue = "") String state,
            @RequestParam(value = "postcode", required = false, defaultValue = "") String postcode,
            @RequestParam(value = "range", required = false, defaultValue = "1") Integer range,
            @RequestParam(value = "keywords", required = false, defaultValue = "") String keywords,
            @RequestParam(value = "industry", required = false, defaultValue = "") String industry,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {
        
        
        
        return ResponseEntity.ok(farmbusinessServices.searchFarmbusiness(accEmail, city, state, postcode, keywords, industry, page));
    }
}
