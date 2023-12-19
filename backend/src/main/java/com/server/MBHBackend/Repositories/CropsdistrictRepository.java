/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Repositories;

import com.server.MBHBackend.Models.Cropsdistrict;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Viktor Vu
 */
@Repository
public interface CropsdistrictRepository extends JpaRepository<Cropsdistrict, Long> {

    @Query("SELECT c FROM Cropsdistrict c WHERE "
            + " (CASE WHEN :crop_name IS NOT NULL AND :crop_name <> '' THEN LOWER(:crop_name) LIKE LOWER(CONCAT('%', c.crop_name, '%')) ELSE 1=1 END) AND"
            + " (CASE WHEN :state IS NOT NULL AND :state <> '' THEN c.state = :state  ELSE 1=1 END) AND"
            + " (CASE WHEN :town IS NOT NULL AND :town <> '' THEN LOWER(districtsDetails.name) LIKE LOWER(CONCAT('%',:town , '%')) ELSE 1=1 END) AND "
            + " (CASE WHEN :postcode IS NOT NULL AND :postcode <> '' THEN c.postcode = :postcode ELSE 1=1 END)")
    Page<Cropsdistrict> searchSeasonality(
            @Param("crop_name") String crop_name,
            @Param("state") String state,
            @Param("town") String town,
            @Param("postcode") String postcode,
            Pageable pageable);

}
