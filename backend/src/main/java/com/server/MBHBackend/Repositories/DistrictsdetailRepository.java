/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Repositories;

import com.server.MBHBackend.Models.Districtsdetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Viktor Vu
 */
@Repository
public interface DistrictsdetailRepository extends JpaRepository<Districtsdetail, Integer> {
    Districtsdetail findByNameAndPostcodeAndState(String name, String postcode, String state);
}
