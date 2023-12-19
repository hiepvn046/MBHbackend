/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Models;

import java.util.Date;

/**
 *
 * @author Viktor Vu
 */
public class TransactionData {

    private String currency;
    private Integer amount;
    private Date date;
    private String description;

    public TransactionData() {
    }

    public TransactionData(String currency, Integer amount, Date date, String description) {
        this.currency = currency;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
