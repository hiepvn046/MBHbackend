/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Controllers;

import com.server.MBHBackend.Models.SubscribeResponse;
import com.server.MBHBackend.Security.user.UserService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Viktor Vu
 */
@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PaymentResponseController {

    private final UserService userService;

    @Autowired
    public PaymentResponseController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<String> updateSubscribe(@RequestBody SubscribeResponse subscribeResponse) {
        String email = subscribeResponse.getEmail();
        Date dateSub = subscribeResponse.getTransactionData().getDate();
        System.out.println(updateSubscribe(email));
        if ("APPROVED".equals(subscribeResponse.getPaymentStatus())) {

            switch (subscribeResponse.getTransactionData().getAmount()) {
                case 3000 ->
                    userService.updateSubscribe(email, dateSub, 1);
                case 5000 ->
                    userService.updateSubscribe(email, dateSub, 2);
                case 7500 ->
                    userService.updateSubscribe(email, dateSub, 3);
                case 10000 ->
                    userService.updateSubscribe(email, dateSub, 4);
                case 12500 ->
                    userService.updateSubscribe(email, dateSub, 5);
                default ->
                    throw new AssertionError();
            }
            System.out.println(updateSubscribe(email));
        }

        return new ResponseEntity<>("APPROVED", HttpStatus.CREATED);
    }

    @GetMapping
    public boolean updateSubscribe(@RequestParam(value = "email", required = true) String email) {
        return userService.checkSubscribe(email);
    }
}
