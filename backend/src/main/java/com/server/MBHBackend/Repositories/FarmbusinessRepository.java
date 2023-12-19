/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Repositories;

import com.server.MBHBackend.Models.Accomodation;
import com.server.MBHBackend.Models.Farmbusiness;
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
public interface FarmbusinessRepository extends JpaRepository<Farmbusiness, Long> {

    @Query("SELECT f FROM Farmbusiness f WHERE "
            + " (CASE WHEN :accEmail IS NOT NULL AND :accEmail <> '' THEN f.accEmail = :accEmail  ELSE 1=1 END) AND"
            + " (CASE WHEN :city IS NOT NULL AND :city <> '' THEN LOWER(:city) LIKE LOWER(CONCAT('%', f.districtsDetails.name , '%')) ELSE 1=1 END) AND"
            + " (CASE WHEN :state IS NOT NULL AND :state <> '' THEN f.districtsDetails.state = :state  ELSE 1=1 END) AND"
            + " (CASE WHEN :postcode IS NOT NULL AND :postcode <> '' THEN f.districtsDetails.postcode = :postcode ELSE 1=1 END) AND"
            + " (CASE WHEN :keywords IS NOT NULL AND :keywords <> '' THEN LOWER(f.firm) LIKE LOWER(CONCAT('%',:keywords, '%')) ELSE 1=1 END) AND"
            + " (CASE WHEN :industry IS NOT NULL AND :industry <> '' THEN LOWER(f.category) LIKE LOWER(CONCAT('%',:industry, '%')) ELSE 1=1 END) ")
    Page<Farmbusiness> searchFarmbusiness(
            @Param("accEmail") String accEmail,
            @Param("city") String city,
            @Param("state") String state,
            @Param("postcode") String postcode,
            @Param("keywords") String keywords,
            @Param("industry") String industry,
            Pageable pageable);
}
