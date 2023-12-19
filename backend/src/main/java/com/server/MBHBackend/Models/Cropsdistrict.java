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
@Table(name = "cropsdistricts")
public class Cropsdistrict {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "districtsdetails_id")
    private Districtsdetail districtsDetails;

    @Column(name = "i_postcode")
    private String postcode;

    @Column(name = "s_state")
    private String state;

    @Column(name = "s_crop_name")
    private String crop_name;

    @Column(name = "i_jan")
    private int jan;

    @Column(name = "i_feb")
    private int feb;

    @Column(name = "i_mar")
    private int mar;

    @Column(name = "i_apr")
    private int apr;

    @Column(name = "i_may")
    private int may;

    @Column(name = "i_jun")
    private int jun;

    @Column(name = "i_jul")
    private int jul;

    @Column(name = "i_ago")
    private int aug;

    @Column(name = "i_sep")
    private int sep;

    @Column(name = "i_oct")
    private int oct;

    @Column(name = "i_nov")
    private int nov;

    @Column(name = "i_dec")
    private int dec;

    @Column(name = "trial582")
    private String trial582;

    public Cropsdistrict() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Districtsdetail getDistrictsDetails() {
        return districtsDetails;
    }

    public void setDistrictsDetails(Districtsdetail districtsDetails) {
        this.districtsDetails = districtsDetails;
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

    public String getCrop_name() {
        return crop_name;
    }

    public void setCrop_name(String crop_name) {
        this.crop_name = crop_name;
    }

    public int getJan() {
        return jan;
    }

    public void setJan(int jan) {
        this.jan = jan;
    }

    public int getFeb() {
        return feb;
    }

    public void setFeb(int feb) {
        this.feb = feb;
    }

    public int getMar() {
        return mar;
    }

    public void setMar(int mar) {
        this.mar = mar;
    }

    public int getApr() {
        return apr;
    }

    public void setApr(int apr) {
        this.apr = apr;
    }

    public int getMay() {
        return may;
    }

    public void setMay(int may) {
        this.may = may;
    }

    public int getJun() {
        return jun;
    }

    public void setJun(int jun) {
        this.jun = jun;
    }

    public int getJul() {
        return jul;
    }

    public void setJul(int jul) {
        this.jul = jul;
    }

    public int getAug() {
        return aug;
    }

    public void setAug(int aug) {
        this.aug = aug;
    }

    public int getSep() {
        return sep;
    }

    public void setSep(int sep) {
        this.sep = sep;
    }

    public int getOct() {
        return oct;
    }

    public void setOct(int oct) {
        this.oct = oct;
    }

    public int getNov() {
        return nov;
    }

    public void setNov(int nov) {
        this.nov = nov;
    }

    public int getDec() {
        return dec;
    }

    public void setDec(int dec) {
        this.dec = dec;
    }

    public String getTrial582() {
        return trial582;
    }

    public void setTrial582(String trial582) {
        this.trial582 = trial582;
    }

}
