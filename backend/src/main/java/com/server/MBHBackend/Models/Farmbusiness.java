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
@Table(name = "farmbusinesses")
public class Farmbusiness {

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

    @Column(name = "abn")
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

    @Column(name = "s_category")
    private String category;

    @Column(name = "s_firm")
    private String firm;

    @Column(name = "s_contact")
    private String contact;

    @Column(name = "s_role")
    private String role;

    @Column(name = "s_addr")
    private String addr;

    @ManyToOne
    @JoinColumn(name = "districtsdetails_id")
    private Districtsdetail districtsDetails;

    @Column(name = "s_tel")
    private String tel;

    @Column(name = "s_fax")
    private String fax;

    @Column(name = "s_mob")
    private String mob;

    @Column(name = "s_email")
    private String email;

    @Column(name = "s_web", columnDefinition = "TEXT")
    private String web;

    @Column(name = "s_buss")
    private String buss;

    @Column(name = "s_hla_email")
    private String hla_email;

    @Column(name = "s_hla_web", columnDefinition = "TEXT")
    private String hla_website;

    @Column(name = "field1")
    private String field1;

    @Column(name = "field2")
    private String field2;

    @Column(name = "field3", columnDefinition = "TEXT")
    private String field3;

    @Column(name = "trial586")
    private String trial586;

    @Column(name = "horticulutre_industry_1")
    private String horticulutre_industry_1;

    @Column(name = "horticulutre_industry_2")
    private String horticulutre_industry_2;

    @Column(name = "livestock_industry")
    private String livestock_industry;

    @Column(name = "cropping_industry")
    private String cropping_industry;

    @Column(name = "other_industry_1")
    private String other_industry_1;

    @Column(name = "scope")
    private String scope;

    public String getHorticulutre_industry_1() {
        return horticulutre_industry_1;
    }

    public void setHorticulutre_industry_1(String horticulutre_industry_1) {
        this.horticulutre_industry_1 = horticulutre_industry_1;
    }

    public String getHorticulutre_industry_2() {
        return horticulutre_industry_2;
    }

    public void setHorticulutre_industry_2(String horticulutre_industry_2) {
        this.horticulutre_industry_2 = horticulutre_industry_2;
    }

    public String getLivestock_industry() {
        return livestock_industry;
    }

    public void setLivestock_industry(String livestock_industry) {
        this.livestock_industry = livestock_industry;
    }

    public String getCropping_industry() {
        return cropping_industry;
    }

    public void setCropping_industry(String cropping_industry) {
        this.cropping_industry = cropping_industry;
    }

    public String getOther_industry_1() {
        return other_industry_1;
    }

    public void setOther_industry_1(String other_industry_1) {
        this.other_industry_1 = other_industry_1;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public Farmbusiness() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFirm() {
        return firm;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public Districtsdetail getDistrictsDetails() {
        return districtsDetails;
    }

    public void setDistrictsDetails(Districtsdetail districtsDetails) {
        this.districtsDetails = districtsDetails;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }

    public String getBuss() {
        return buss;
    }

    public void setBuss(String buss) {
        this.buss = buss;
    }

    public String getHla_email() {
        return hla_email;
    }

    public void setHla_email(String hla_email) {
        this.hla_email = hla_email;
    }

    public String getHla_website() {
        return hla_website;
    }

    public void setHla_website(String hla_website) {
        this.hla_website = hla_website;
    }

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public String getTrial586() {
        return trial586;
    }

    public void setTrial586(String trial586) {
        this.trial586 = trial586;
    }

}
