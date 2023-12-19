/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Services;

import com.server.MBHBackend.Models.Districtsdetail;
import java.util.List;

/**
 *
 * @author Viktor Vu
 */
public interface DistrictsdetailServices {

    List<Districtsdetail> findAll();

    Districtsdetail findById(int id);
    
    Districtsdetail checkexists(String name, String postcode, String state);

    Districtsdetail save(Districtsdetail districtsdetail);

    void deleteById(int id);
}
