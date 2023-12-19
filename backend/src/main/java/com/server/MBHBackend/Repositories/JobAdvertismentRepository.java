/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.server.MBHBackend.Repositories;

import com.server.MBHBackend.Models.JobAdvertisment;
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
public interface JobAdvertismentRepository extends JpaRepository<JobAdvertisment, Long> {

    @Query("SELECT j FROM JobAdvertisment j WHERE "
            + " (CASE WHEN :title IS NOT NULL AND :title <> '' THEN LOWER(j.title) like LOWER(CONCAT('%',:title,'%')) ELSE 1=1 END) AND"
            + " (CASE WHEN :city IS NOT NULL AND :city <> '' THEN LOWER(:city) LIKE LOWER(CONCAT('%', j.districtsDetails.name , '%')) ELSE 1=1 END) AND"
            + " (CASE WHEN :state IS NOT NULL AND :state <> '' THEN j.districtsDetails.state = :state  ELSE 1=1 END) AND"
            + " (CASE WHEN :postcode IS NOT NULL AND :postcode <> '' THEN j.districtsDetails.postcode = :postcode ELSE 1=1 END) AND"
            + " (CASE WHEN :startDate IS NOT NULL AND :startDate <> '' THEN j.startDate >= :startDate ELSE 1=1 END) AND"
            + " (CASE WHEN :accEmail IS NOT NULL AND :accEmail <> '' THEN j.accEmail = :accEmail ELSE 1=1 END) AND"
            + " (CASE WHEN :endDate IS NOT NULL AND :endDate <> '' THEN j.endDate <= :endDate ELSE 1=1 END)")
    Page<JobAdvertisment> searchJobAdvertisment(
            @Param("title") String title,
            @Param("city") String city,
            @Param("state") String state,
            @Param("postcode") String postcode,
            @Param("startDate") String startDate,
            @Param("endDate") String endDate,
            @Param("accEmail") String accEmail,
            Pageable pageable);
}
