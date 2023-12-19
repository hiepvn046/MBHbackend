/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.JobAdvertisment;
import java.util.Date;
import java.util.List;
import org.springframework.data.domain.Page;

/**
 *
 * @author Viktor Vu
 */
public interface JobAdvertismentServices {
    List<JobAdvertisment> findAll();

    JobAdvertisment findById(Long id);

    JobAdvertisment save(JobAdvertisment jobAdvertisment);

    void deleteById(Long id);
    
    Page<JobAdvertisment> searchJobAdvertisment(String title, String city, String state, String postcode, String startDate, String endDate, String accEmail, Integer itemPerPage, Integer page);
}
