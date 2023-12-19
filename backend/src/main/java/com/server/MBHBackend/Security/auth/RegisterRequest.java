package com.server.MBHBackend.Security.auth;

import com.server.MBHBackend.Models.Districtsdetail;
import com.server.MBHBackend.Security.user.Role;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Role role;
    
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
}
