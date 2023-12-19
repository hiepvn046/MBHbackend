/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Security.auth;

import com.server.MBHBackend.Security.user.RegistrationCompleteEvent;
import com.server.MBHBackend.Security.user.User;
import com.server.MBHBackend.Security.user.UserService;
import com.server.MBHBackend.Security.user.VerificationToken;
import com.server.MBHBackend.Security.user.VerificationTokenRepository;
import com.server.MBHBackend.Services.DistrictsdetailServices;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
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
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;
    private final UserService userService;
    private final ApplicationEventPublisher publisher;
    private final VerificationTokenRepository tokenRepository;
    private final DistrictsdetailServices districtsdetailServices;
    
    @PostMapping("/register")
    public ResponseEntity<String> register(
            @RequestBody RegisterRequest request, final HttpServletRequest SVrequest
    ) {
        User user = userService.registerUser(request);
        publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(SVrequest)));
        return ResponseEntity.ok("Success!  Please, check your email for to complete your registration");
    }
    
    @PostMapping("/updateInfo")
    public ResponseEntity<String> updateInfor(@RequestBody RegisterRequest request){
        String name = request.getDistrictsdetail().getName();
        String postcode = request.getDistrictsdetail().getPostcode();
        String state = request.getDistrictsdetail().getState();
        request.setDistrictsdetail(districtsdetailServices.checkexists(name, postcode, state));
        
        userService.updateUserByEmail(request);
        return ResponseEntity.ok("Success!");
    }
    
    @GetMapping("/verifyEmail")
    public ResponseEntity<String> verifyEmail(@RequestParam("token") String token){
        VerificationToken theToken = tokenRepository.findByToken(token);
        if (theToken.getUser().isEnabled()){
            return ResponseEntity.ok("This account has already been verified, please, login.");
        }
        String verificationResult = userService.validateToken(token);
        if (verificationResult.equalsIgnoreCase("valid")){
            return ResponseEntity.ok("Email verified successfully. Now you can login to your account");
        }
        return ResponseEntity.ok("Invalid verification token");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        service.refreshToken(request, response);
    }
    
    public String applicationUrl(HttpServletRequest request) {
        return "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath();
    }
    
}
