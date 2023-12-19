/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.Cropsdistrict;
import com.server.MBHBackend.Repositories.CropsdistrictRepository;
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
public class CropsdistrictServicesImpl implements CropsdistrictServices {

    private final CropsdistrictRepository cropsdistrictRepository;

    @Autowired
    public CropsdistrictServicesImpl(CropsdistrictRepository cropsdistrictRepository) {
        this.cropsdistrictRepository = cropsdistrictRepository;
    }

    @Override
    @Transactional
    public List<Cropsdistrict> findAll() {
        return cropsdistrictRepository.findAll();
    }

    @Override
    @Transactional
    public Cropsdistrict findById(Long id) {
        return cropsdistrictRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cropsdistrict save(Cropsdistrict cropsdistrict) {
        cropsdistrict = cropsdistrictRepository.save(cropsdistrict);
        return cropsdistrict;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        cropsdistrictRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Page<Cropsdistrict> searchSeasonality(String crop_name, String town, String state, String postcode, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        return cropsdistrictRepository.searchSeasonality(crop_name, state, town, postcode, pageable);
    }

}
