/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.server.MBHBackend.Security.user;

import com.server.MBHBackend.Security.auth.RegisterRequest;
import java.util.Date;
import java.util.Optional;

/**
 *
 * @author Viktor Vu
 */

public interface UserService {
    
    User registerUser(RegisterRequest request);
    Optional<User> findByEmail(String email);
    
    UserResponse findByEmail2(String email);
    
    void updateUserByEmail(RegisterRequest registerRequest);
    
    void updateUserByEmail2(UserResponse registerRequest);

    void saveUserVerificationToken(User theUser, String verificationToken);

    String validateToken(String theToken);
    
    void updateSubscribe(String email, Date dateSub, int type);
    
    boolean checkSubscribe(String email);
}
