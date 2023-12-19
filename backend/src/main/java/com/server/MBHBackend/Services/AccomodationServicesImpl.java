/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.Accomodation;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.server.MBHBackend.Repositories.AccomodationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author Viktor Vu
 */
@Service
public class AccomodationServicesImpl implements AccomodationServices {

    private final AccomodationRepository accommodationRepository;

    @Autowired
    public AccomodationServicesImpl(AccomodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    @Transactional
    public List<Accomodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    @Transactional
    public Accomodation findById(Long id) {
        return accommodationRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Accomodation save(Accomodation accommodation) {
        accommodation = accommodationRepository.save(accommodation);
        return accommodation;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Page<Accomodation> searchAccomodation(String accEmail, String city, String state, String postcode, String keywords, String type, Integer page) {
        Pageable pageable = PageRequest.of(page, 5);
        return accommodationRepository.searchAccomodation(accEmail, city, state, postcode, keywords, type, pageable);
    }
    
    
}
