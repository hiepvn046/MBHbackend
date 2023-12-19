/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Controllers;

import com.server.MBHBackend.Models.Districtsdetail;
import com.server.MBHBackend.Services.DistrictsdetailServices;
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
@RequestMapping("/api/districtsdetail")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DistrictsdetailController {

    private final DistrictsdetailServices districtsdetailServices;

    public DistrictsdetailController(DistrictsdetailServices districtsdetailServices) {
        this.districtsdetailServices = districtsdetailServices;
    }

    @GetMapping
    public ResponseEntity<List<Districtsdetail>> getAllDistrictsdetail() {
        return ResponseEntity.ok(districtsdetailServices.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Districtsdetail> getDistrictsdetailById(@PathVariable int id) {
        return ResponseEntity.ok(districtsdetailServices.findById(id));
    }

    @PostMapping
    public ResponseEntity<Districtsdetail> createDistrictsdetail(@RequestBody Districtsdetail districtsdetail) {
        return new ResponseEntity<>(districtsdetailServices.save(districtsdetail), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Districtsdetail> updateDistrictsdetail(@PathVariable int id, @RequestBody Districtsdetail districtsdetail) {
        districtsdetail.setId(id); // Ensure the ID in the DTO matches the path variable
        return ResponseEntity.ok(districtsdetailServices.save(districtsdetail));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDistrictsdetail(@PathVariable int id) {
        districtsdetailServices.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
