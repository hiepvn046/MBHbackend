/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

/**
 *
 * @author Viktor Vu
 */
@Entity
@Table(name = "districtsdetails")
public class Districtsdetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "s_name")
    private String name;

    @Column(name = "i_postcode")
    private String postcode;

    @Column(name = "s_state")
    private String state;

    @Column(name = "s_desc")
    private String desc;

    @Column(name = "s_tovisit")
    private String tovisit;

    @Column(name = "s_tinfo_addr")
    private String info_addr;

    @Column(name = "s_tinfo_tel")
    private String info_tel;

    @Column(name = "s_tinfo_email")
    private String info_email;

    @Column(name = "s_tinfo_web", columnDefinition = "TEXT")
    private String info_website;

    @Column(name = "s_indications")
    private String indications;

    @Column(name = "s_hla_addr")
    private String hla_addr;

    @Column(name = "s_hla_tel")
    private String hlao_tel;

    @Column(name = "s_hla_email")
    private String hla_email;

    @Column(name = "s_hla_web", columnDefinition = "TEXT")
    private String hla_website;

    @Column(name = "field1")
    private String field1;

    @Column(name = "field2")
    private String field2;

    public Districtsdetail(String name, String postcode, String state) {
        this.name = name;
        this.postcode = postcode;
        this.state = state;
    }

    @Column(name = "trial586")
    private String trial586;

    public Districtsdetail() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTovisit() {
        return tovisit;
    }

    public void setTovisit(String tovisit) {
        this.tovisit = tovisit;
    }

    public String getInfo_addr() {
        return info_addr;
    }

    public void setInfo_addr(String info_addr) {
        this.info_addr = info_addr;
    }

    public String getInfo_tel() {
        return info_tel;
    }

    public void setInfo_tel(String info_tel) {
        this.info_tel = info_tel;
    }

    public String getInfo_email() {
        return info_email;
    }

    public void setInfo_email(String info_email) {
        this.info_email = info_email;
    }

    public String getInfo_website() {
        return info_website;
    }

    public void setInfo_website(String info_website) {
        this.info_website = info_website;
    }

    public String getIndications() {
        return indications;
    }

    public void setIndications(String indications) {
        this.indications = indications;
    }

    public String getHla_addr() {
        return hla_addr;
    }

    public void setHla_addr(String hla_addr) {
        this.hla_addr = hla_addr;
    }

    public String getHlao_tel() {
        return hlao_tel;
    }

    public void setHlao_tel(String hlao_tel) {
        this.hlao_tel = hlao_tel;
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

    public String getTrial586() {
        return trial586;
    }

    public void setTrial586(String trial586) {
        this.trial586 = trial586;
    }

}
