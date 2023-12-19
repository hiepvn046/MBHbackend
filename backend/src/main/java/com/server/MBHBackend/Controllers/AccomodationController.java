/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Controllers;

import com.server.MBHBackend.Models.Accomodation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.server.MBHBackend.Services.AccomodationServices;
import com.server.MBHBackend.Services.DistrictsdetailServices;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Viktor Vu
 */
@RestController
@RequestMapping("/api/accomodation")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AccomodationController {

    private final AccomodationServices accommodationService;

    private final DistrictsdetailServices districtsdetailServices;

    @Autowired
    public AccomodationController(AccomodationServices accommodationService, DistrictsdetailServices districtsdetailServices) {
        this.accommodationService = accommodationService;
        this.districtsdetailServices = districtsdetailServices;
    }

    @GetMapping
    public ResponseEntity<List<Accomodation>> getAllAccommodations() {
        return ResponseEntity.ok(accommodationService.findAll());
    }

    @GetMapping("/getone/{id}")
    public ResponseEntity<Accomodation> getAccommodationById(@PathVariable Long id) {
        return ResponseEntity.ok(accommodationService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Accomodation> createAccommodation(@RequestBody Accomodation accommodation) {
        String name = accommodation.getDistrictsDetails().getName();
        String postcode = accommodation.getDistrictsDetails().getPostcode();
        String state = accommodation.getDistrictsDetails().getState();
        accommodation.setDistrictsDetails(districtsdetailServices.checkexists(name, postcode, state));
        return new ResponseEntity<>(accommodationService.save(accommodation), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Accomodation> updateAccommodation(@PathVariable Long id, @RequestBody Accomodation accommodation) {
        accommodation.setId(id); // Ensure the ID in the DTO matches the path variable
        return ResponseEntity.ok(accommodationService.save(accommodation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccommodation(@PathVariable Long id) {
        accommodationService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Page<Accomodation>> searchAccommodation(
            @RequestParam(value = "accEmail", required = false, defaultValue = "") String accEmail,
            @RequestParam(value = "city", required = false, defaultValue = "") String city,
            @RequestParam(value = "state", required = false, defaultValue = "") String state,
            @RequestParam(value = "postcode", required = false, defaultValue = "") String postcode,
            @RequestParam(value = "range", required = false, defaultValue = "1") Integer range,
            @RequestParam(value = "keywords", required = false, defaultValue = "") String keywords,
            @RequestParam(value = "type", required = false, defaultValue = "") String type,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {

        return ResponseEntity.ok(accommodationService.searchAccomodation(accEmail, city, state, postcode, keywords, type, page));
    }
}
