/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.Districtsdetail;
import com.server.MBHBackend.Repositories.DistrictsdetailRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Viktor Vu
 */
@Service
public class DistrictsdetailServicesImpl implements DistrictsdetailServices {

    private final DistrictsdetailRepository districtsdetailRepository;

    @Autowired
    public DistrictsdetailServicesImpl(DistrictsdetailRepository districtsdetailRepository) {
        this.districtsdetailRepository = districtsdetailRepository;
    }

    @Override
    @Transactional
    public List<Districtsdetail> findAll() {
        return districtsdetailRepository.findAll();
    }

    @Override
    @Transactional
    public Districtsdetail findById(int id) {
        return districtsdetailRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Districtsdetail save(Districtsdetail districtsdetail) {
        districtsdetail = districtsdetailRepository.save(districtsdetail);
        return districtsdetail;
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        districtsdetailRepository.deleteById(id);
    }

    @Override
    public Districtsdetail checkexists(String name, String postcode, String state) {
        if (districtsdetailRepository.findByNameAndPostcodeAndState(name, postcode, state) != null) {
            return districtsdetailRepository.findByNameAndPostcodeAndState(name, postcode, state);
        } else {

            return districtsdetailRepository.save(new Districtsdetail(name, postcode, state));
        }
    }

}
