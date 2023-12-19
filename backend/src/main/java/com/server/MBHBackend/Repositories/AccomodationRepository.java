/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Repositories;

import com.server.MBHBackend.Models.Accomodation;

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
public interface AccomodationRepository extends JpaRepository<Accomodation, Long> {

    @Query("SELECT a FROM Accomodation a WHERE "
            + " (CASE WHEN :accEmail IS NOT NULL AND :accEmail <> '' THEN a.accEmail = :accEmail  ELSE 1=1 END) AND"
            + " (CASE WHEN :city IS NOT NULL AND :city <> '' THEN LOWER(:city) LIKE LOWER(CONCAT('%', a.districtsDetails.name , '%')) ELSE 1=1 END) AND"
            + " (CASE WHEN :state IS NOT NULL AND :state <> '' THEN a.districtsDetails.state = :state  ELSE 1=1 END) AND"
            + " (CASE WHEN :postcode IS NOT NULL AND :postcode <> '' THEN a.districtsDetails.postcode = :postcode ELSE 1=1 END) AND"
            + " (CASE WHEN :keywords IS NOT NULL AND :keywords <> '' THEN LOWER(a.name) LIKE LOWER(CONCAT('%',:keywords, '%')) ELSE 1=1 END) AND"
            + " (CASE WHEN :type IS NOT NULL AND :type <> '' AND :type <> 'other' THEN LOWER(a.name) LIKE LOWER(CONCAT('%',:type, '%')) ELSE 1=1 END) AND"
            + " (CASE WHEN :type = 'other' THEN LOWER(a.name) NOT LIKE '%hostel%' AND LOWER(a.name) NOT LIKE '%park%' AND LOWER(a.name) NOT LIKE '%pub%' AND LOWER(a.name) NOT LIKE '%camp%' ELSE 1=1 END)")
    Page<Accomodation> searchAccomodation(
            @Param("accEmail") String accEmail,
            @Param("city") String city,
            @Param("state") String state,
            @Param("postcode") String postcode,
            @Param("keywords") String keywords,
            @Param("type") String type,
            Pageable pageable);
}
