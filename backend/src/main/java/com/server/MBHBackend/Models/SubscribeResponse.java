/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.server.MBHBackend.Models;

/**
 *
 * @author Viktor Vu
 */
public class SubscribeResponse {
    private String email;
    private String paymentStatus;
    private TransactionData transactionData;
    
    

    public SubscribeResponse() {
    }

    public SubscribeResponse(String email, String paymentStatus, TransactionData transactionData) {
        this.email = email;
        this.paymentStatus = paymentStatus;
        this.transactionData = transactionData;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public TransactionData getTransactionData() {
        return transactionData;
    }

    public void setTransactionData(TransactionData transactionData) {
        this.transactionData = transactionData;
    }
    
    
}
