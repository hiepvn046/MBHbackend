/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.JobAdvertisment;
import com.server.MBHBackend.Repositories.JobAdvertismentRepository;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Viktor Vu
 */
@Service
public class JobAdvertismentServicesImpl implements JobAdvertismentServices {

    private final JobAdvertismentRepository jobAdvertismentRepository;

    public JobAdvertismentServicesImpl(JobAdvertismentRepository jobAdvertismentRepository) {
        this.jobAdvertismentRepository = jobAdvertismentRepository;
    }

    @Override
    public List<JobAdvertisment> findAll() {
        return jobAdvertismentRepository.findAll();
    }

    @Override
    public JobAdvertisment findById(Long id) {
        return jobAdvertismentRepository.findById(id).orElse(null);
    }

    @Override
    public JobAdvertisment save(JobAdvertisment jobAdvertisment) {
        return jobAdvertismentRepository.save(jobAdvertisment);
    }

    @Override
    public void deleteById(Long id) {
        jobAdvertismentRepository.deleteById(id);
    }

    @Override
    public Page<JobAdvertisment> searchJobAdvertisment(String title, String city, String state, String postcode, String startDate, String endDate, String accEmail, Integer itemPerPage, Integer page) {
        Pageable pageable = PageRequest.of(page, itemPerPage);
        return jobAdvertismentRepository.searchJobAdvertisment(title, city, state, postcode, startDate, endDate, accEmail, pageable);
    }

}
