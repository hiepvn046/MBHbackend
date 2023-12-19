/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.Farmbusiness;
import com.server.MBHBackend.Repositories.FarmbusinessRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Viktor Vu
 */
@Service
public class FarmbusinessServicesImpl implements FarmbusinessServices {

    private final FarmbusinessRepository farmbusinessRepository;

    @Autowired
    public FarmbusinessServicesImpl(FarmbusinessRepository farmbusinessRepository) {
        this.farmbusinessRepository = farmbusinessRepository;
    }

    @Override
    @Transactional
    public List<Farmbusiness> findAll() {
        return farmbusinessRepository.findAll();
    }

    @Override
    @Transactional
    public Farmbusiness findById(Long id) {
        return farmbusinessRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Farmbusiness save(Farmbusiness farmbusiness) {
        farmbusiness = farmbusinessRepository.save(farmbusiness);
        return farmbusiness;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        farmbusinessRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Page<Farmbusiness> searchFarmbusiness(String accEmail, String city, String state, String postcode, String keywords, String industry, Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return farmbusinessRepository.searchFarmbusiness(accEmail, city, state, postcode, keywords, industry, pageable);
    }
    
    

}
