/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Security.user;

import java.io.UnsupportedEncodingException;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


/**
 *
 * @author Viktor Vu
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class RegistrationCompleteEventListener implements ApplicationListener<RegistrationCompleteEvent> {

    private final UserService userService;

    private final JavaMailSender mailSender;
    private User theUser;

    @Override
    public void onApplicationEvent(RegistrationCompleteEvent event) {
        // 1. Get the newly registered user
        theUser = event.getUser();
        //2. Create a verification token for the user
        String verificationToken = UUID.randomUUID().toString();
        //3. Save the verification token for the user
        userService.saveUserVerificationToken(theUser, verificationToken);
        //4 Build the verification url to be sent to the user
        String url = event.getApplicationUrl() + "/api/v1/auth/verifyEmail?token=" + verificationToken;
        //5. Send the email.
        try {
            sendVerificationEmail(verificationToken);
        } catch ( UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        log.info("Click the link to verify your registration :  {}", url);
    }

    public void sendVerificationEmail(String verificationToken) throws UnsupportedEncodingException {
        String subject = "Email Verification";
        String mailContent = "Hi, " + theUser.getEmail()+ ", \n"
                + "Thank you for registering with us." + " "
                + "Please, take the verify code below to complete your registration.\n"
                + "" + verificationToken + "\n"
                + "Thank you\n"
                + "Users Registration Portal Service";
        
        SimpleMailMessage mess = new SimpleMailMessage();
        mess.setFrom("zooxdwick@gmail.com");
        mess.setTo(theUser.getEmail());
        mess.setSubject(subject);
        mess.setText(mailContent);
        mailSender.send(mess);
    }
}
