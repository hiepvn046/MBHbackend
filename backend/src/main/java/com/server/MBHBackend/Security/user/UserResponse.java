/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Security.user;

import com.server.MBHBackend.Models.Districtsdetail;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Viktor Vu
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private String firstname;
    private String lastname;
    private String email;

    private String gender;
    private Integer age;
    private String work_oppo;
    private String address;

    private Districtsdetail districtsdetail;

    private String phone;

    private String rights_to_work;

    private String visaType;

    private boolean haveTFN;

    private boolean haveBank;

    private boolean haveSuper;

    private String education;

    private String about;

    private String universityLevel;

    private Date subscribe;
}
