/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Security.user;

import com.server.MBHBackend.Security.auth.RegisterRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author Viktor Vu
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, VerificationTokenRepository verificationTokenRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.verificationTokenRepository = verificationTokenRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserResponse findByEmail2(String email) {
        if (userRepository.findByEmail(email).isPresent()) {
            User u = userRepository.findByEmail(email).get();
            UserResponse ures = new UserResponse(u.getFirstname(), u.getLastname(), u.getEmail(), u.getGender(), u.getAge(), u.getWork_oppo(), u.getAddress(), u.getDistrictsdetail(), u.getPhone(), u.getRights_to_work(), u.getVisaType(), u.isHaveTFN(), u.isHaveBank(), u.isHaveSuper(), u.getEducation(), u.getAbout(), u.getUniversityLevel(), u.getSubscribe());
            return ures;
        }
        return null;
    }

    @Override
    public void saveUserVerificationToken(User theUser, String token) {
        verificationTokenRepository.save(new VerificationToken(token, theUser));
    }

    @Override
    public String validateToken(String theToken) {
        VerificationToken token = verificationTokenRepository.findByToken(theToken);
        if (token == null) {
            return "Invalid verification token";
        }
        User user = token.getUser();
        Calendar calendar = Calendar.getInstance();
        if ((token.getExpirationTime().getTime() - calendar.getTime().getTime()) <= 0) {
            verificationTokenRepository.delete(token);
            return "Token already expired";
        }
        user.setEnabled(true);
        userRepository.save(user);
        return "valid";
    }

    @Override
    public User registerUser(RegisterRequest request) {
        Optional<User> user = this.findByEmail(request.getEmail());
        if (user.isPresent()) {
            throw new UserAlreadyExistsException(
                    "User with email " + request.getEmail() + " already exists");
        }
        var newUser = new User();
        newUser.setFirstname(request.getFirstname());
        newUser.setLastname(request.getLastname());
        newUser.setEmail(request.getEmail());
        newUser.setPassword(passwordEncoder.encode(request.getPassword()));
        newUser.setRole(request.getRole());
        return userRepository.save(newUser);
    }

    @Override
    public void updateUserByEmail(RegisterRequest update) {
        if (findByEmail(update.getEmail()).isPresent()) {
            User user = findByEmail(update.getEmail()).get();
            user.setFirstname(update.getFirstname());
            user.setLastname(update.getLastname());
            user.setAge(update.getAge());
            user.setWork_oppo(update.getWork_oppo());
            user.setAddress(update.getAddress());
            user.setDistrictsdetail(update.getDistrictsdetail());
            user.setPhone(update.getPhone());
            user.setRights_to_work(update.getRights_to_work());
            user.setHaveBank(update.isHaveBank());
            user.setHaveSuper(update.isHaveSuper());
            user.setHaveTFN(update.isHaveTFN());
            user.setEducation(update.getEducation());
            user.setAbout(update.getAbout());
            user.setVisaType(update.getVisaType());
            user.setUniversityLevel(update.getUniversityLevel());
            user.setGender(update.getGender());

            userRepository.save(user);
        }
    }

    @Override
    public void updateUserByEmail2(UserResponse update) {
        if (findByEmail(update.getEmail()).isPresent()) {
            User user = findByEmail(update.getEmail()).get();
            user.setFirstname(update.getFirstname());
            user.setLastname(update.getLastname());
            user.setAge(update.getAge());
            user.setWork_oppo(update.getWork_oppo());
            user.setAddress(update.getAddress());
            user.setDistrictsdetail(update.getDistrictsdetail());
            user.setPhone(update.getPhone());
            user.setRights_to_work(update.getRights_to_work());
            user.setHaveBank(update.isHaveBank());
            user.setHaveSuper(update.isHaveSuper());
            user.setHaveTFN(update.isHaveTFN());
            user.setEducation(update.getEducation());
            user.setAbout(update.getAbout());
            user.setVisaType(update.getVisaType());
            user.setUniversityLevel(update.getUniversityLevel());
            user.setGender(update.getGender());

            userRepository.save(user);
        }
    }

    @Override
    public void updateSubscribe(String email, Date dateSub, int type) {
        if (findByEmail(email).isPresent()) {
            User user = findByEmail(email).get();

            Date currentDate = new Date();

            if ((user.getSubscribe() == null) || user.getSubscribe().before(currentDate)) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(dateSub);

                switch (type) {
                    case 1 ->
                        calendar.add(Calendar.DATE, 30);
                    case 2 ->
                        calendar.add(Calendar.DATE, 90);
                    case 3 ->
                        calendar.add(Calendar.DATE, 180);
                    case 4 ->
                        calendar.add(Calendar.DATE, 270);
                    case 5 ->
                        calendar.add(Calendar.DATE, 365);
                    default ->
                        throw new AssertionError();
                }

                Date updatedDate = calendar.getTime();
                user.setSubscribe(updatedDate);
            } else {
                Calendar calendar2 = Calendar.getInstance();
                calendar2.setTime(user.getSubscribe());

                switch (type) {
                    case 1 ->
                        calendar2.add(Calendar.DATE, 30);
                    case 2 ->
                        calendar2.add(Calendar.DATE, 90);
                    case 3 ->
                        calendar2.add(Calendar.DATE, 180);
                    case 4 ->
                        calendar2.add(Calendar.DATE, 270);
                    case 5 ->
                        calendar2.add(Calendar.DATE, 365);
                    default ->
                        throw new AssertionError();
                }

                Date updatedDate2 = calendar2.getTime();
                user.setSubscribe(updatedDate2);
            }
            userRepository.save(user);
        }
    }

    @Override
    public boolean checkSubscribe(String email) {
        Date currentDate = new Date();
        if (findByEmail(email).isPresent()) {
            if (findByEmail(email).get().getSubscribe() == null) {
                return false;
            } else {
                Date subscribe = findByEmail(email).get().getSubscribe();
                return !subscribe.before(currentDate);
            }
        } else {
            return false;
        }
    }

}
