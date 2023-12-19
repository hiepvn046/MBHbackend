/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 *
 * @author Viktor Vu
 */
@Entity
@Table(name = "accomodations")
public class Accomodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "accEmail")
    private String accEmail;

    public String getAccEmail() {
        return accEmail;
    }

    public void setAccEmail(String accEmail) {
        this.accEmail = accEmail;
    }
    
    

    @Column(name = "s_name")
    private String name;

    @Column(name = "s_contact")
    private String contact;

    @Column(name = "s_addr")
    private String address;

    @Column(name = "accomodation_type")
    private String accomodation_type;

    @Column(name = "capacity")
    private String capacity;
    
    @Column(name = "contact_role")
    private String contact_role;

    public String getContact_role() {
        return contact_role;
    }

    public void setContact_role(String contact_role) {
        this.contact_role = contact_role;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAccomodation_type() {
        return accomodation_type;
    }

    public void setAccomodation_type(String accomodation_type) {
        this.accomodation_type = accomodation_type;
    }

    @ManyToOne
    @JoinColumn(name = "districtsdetails_id")
    private Districtsdetail districtsDetails;

    @Column(name = "s_tel")
    private String telephone;

    @Column(name = "s_fax")
    private String fax;

    @Column(name = "s_mob")
    private String mobile;

    @Column(name = "s_email")
    private String email;

    @Column(name = "s_web", columnDefinition = "TEXT")
    private String website;

    @Column(name = "ABN")
    private String abn;

    @Column(name = "acc_note")
    private String acc_note;

    public String getAbn() {
        return abn;
    }

    public void setAbn(String abn) {
        this.abn = abn;
    }

    public String getAcc_note() {
        return acc_note;
    }

    public void setAcc_note(String acc_note) {
        this.acc_note = acc_note;
    }

    @Column(name = "field1")
    private String field1;

    @Column(name = "trial579")
    private String trial579;

    public Accomodation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Districtsdetail getDistrictsDetails() {
        return districtsDetails;
    }

    public void setDistrictsDetails(Districtsdetail districtsDetails) {
        this.districtsDetails = districtsDetails;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getTrial579() {
        return trial579;
    }

    public void setTrial579(String trial579) {
        this.trial579 = trial579;
    }

}
