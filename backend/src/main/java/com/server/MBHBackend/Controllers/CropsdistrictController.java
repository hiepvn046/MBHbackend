/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Controllers;

import com.server.MBHBackend.Models.Cropsdistrict;
import com.server.MBHBackend.Services.CropsdistrictServices;
import java.util.List;
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
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Viktor Vu
 */

@RestController
@RequestMapping("/api/cropsdistrict")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CropsdistrictController {

    private final CropsdistrictServices cropsdistrictServices;

    public CropsdistrictController(CropsdistrictServices cropsdistrictServices) {
        this.cropsdistrictServices = cropsdistrictServices;
    }

    @GetMapping
    public ResponseEntity<List<Cropsdistrict>> getAllCropsdistrict() {
        return ResponseEntity.ok(cropsdistrictServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cropsdistrict> getCropsdistrictById(@PathVariable Long id) {
        return ResponseEntity.ok(cropsdistrictServices.findById(id));
    }

    @PostMapping
    public ResponseEntity<Cropsdistrict> createCropsdistrict(@RequestBody Cropsdistrict cropsdistrict) {
        return new ResponseEntity<>(cropsdistrictServices.save(cropsdistrict), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cropsdistrict> updateCropsdistrict(@PathVariable Long id, @RequestBody Cropsdistrict cropsdistrict) {
        cropsdistrict.setId(id); // Ensure the ID in the DTO matches the path variable
        return ResponseEntity.ok(cropsdistrictServices.save(cropsdistrict));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCropsdistrict(@PathVariable Long id) {
        cropsdistrictServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
