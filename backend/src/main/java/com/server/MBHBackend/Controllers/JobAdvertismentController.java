/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Controllers;

import com.server.MBHBackend.Models.JobAdvertisment;
import com.server.MBHBackend.Services.DistrictsdetailServices;
import com.server.MBHBackend.Services.JobAdvertismentServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Viktor Vu
 */
@RestController
@RequestMapping("/api/jobadvertisment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class JobAdvertismentController {

    private final JobAdvertismentServices jobAdvertismentServices;
    private final DistrictsdetailServices districtsdetailServices;

    @Autowired
    public JobAdvertismentController(JobAdvertismentServices jobAdvertismentServices, DistrictsdetailServices districtsdetailServices) {
        this.jobAdvertismentServices = jobAdvertismentServices;
        this.districtsdetailServices = districtsdetailServices;
    }

    @GetMapping
    public ResponseEntity<List<JobAdvertisment>> getAllJobAdvertisment() {
        return ResponseEntity.ok(jobAdvertismentServices.findAll());
    }

    @PostMapping
    public ResponseEntity<JobAdvertisment> createJobAdvertisment(@RequestBody JobAdvertisment jobAdvertisment) {
        String name = jobAdvertisment.getDistrictsDetails().getName();
        String postcode = jobAdvertisment.getDistrictsDetails().getPostcode();
        String state = jobAdvertisment.getDistrictsDetails().getState();
        jobAdvertisment.setDistrictsDetails(districtsdetailServices.checkexists(name, postcode, state));
        return new ResponseEntity<>(jobAdvertismentServices.save(jobAdvertisment), HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<JobAdvertisment>> searchJobAdvertisment(
            @RequestParam(value = "title", required = false, defaultValue = "") String title,
            @RequestParam(value = "city", required = false, defaultValue = "") String city,
            @RequestParam(value = "state", required = false, defaultValue = "") String state,
            @RequestParam(value = "postcode", required = false, defaultValue = "") String postcode,
            @RequestParam(value = "startDate", required = false, defaultValue = "1") String startDate,
            @RequestParam(value = "endDate", required = false, defaultValue = "") String endDate,
            @RequestParam(value = "accEmail", required = false, defaultValue = "") String accEmail,
            @RequestParam(value = "itemsPerPage", required = false, defaultValue = "5") Integer itemsPerPage,
            @RequestParam(value = "page", required = false, defaultValue = "0") Integer page) {

        return ResponseEntity.ok(jobAdvertismentServices.searchJobAdvertisment(title, city, state, postcode, startDate, endDate, accEmail, itemsPerPage, page));
    }
}
