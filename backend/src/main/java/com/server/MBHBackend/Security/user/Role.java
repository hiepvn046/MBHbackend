/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.server.MBHBackend.Security.user;

import static com.server.MBHBackend.Security.user.Permission.ACCOMODATION_CREATE;
import static com.server.MBHBackend.Security.user.Permission.ACCOMODATION_READ;
import static com.server.MBHBackend.Security.user.Permission.ACCOMODATION_UPDATE;
import static com.server.MBHBackend.Security.user.Permission.ADMIN_CREATE;
import static com.server.MBHBackend.Security.user.Permission.ADMIN_DELETE;
import static com.server.MBHBackend.Security.user.Permission.ADMIN_READ;
import static com.server.MBHBackend.Security.user.Permission.ADMIN_UPDATE;
import static com.server.MBHBackend.Security.user.Permission.BUSINESS_CREATE;
import static com.server.MBHBackend.Security.user.Permission.BUSINESS_READ;
import static com.server.MBHBackend.Security.user.Permission.BUSINESS_UPDATE;
import static com.server.MBHBackend.Security.user.Permission.MANAGER_CREATE;
import static com.server.MBHBackend.Security.user.Permission.MANAGER_DELETE;
import static com.server.MBHBackend.Security.user.Permission.MANAGER_READ;
import static com.server.MBHBackend.Security.user.Permission.MANAGER_UPDATE;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 *
 * @author Viktor Vu
 */
@RequiredArgsConstructor
public enum Role {

    USER(Collections.emptySet()),
    ADMIN(
            Set.of(
                    ADMIN_READ,
                    ADMIN_UPDATE,
                    ADMIN_DELETE,
                    ADMIN_CREATE,
                    MANAGER_READ,
                    MANAGER_UPDATE,
                    MANAGER_DELETE,
                    MANAGER_CREATE,
                    BUSINESS_CREATE, 
                    BUSINESS_READ, 
                    BUSINESS_UPDATE
            )
    ),
    BUSINESS(
            Set.of(
                    BUSINESS_CREATE, 
                    BUSINESS_READ, 
                    BUSINESS_UPDATE
            )
    ),
    ACCOMODATION(
            Set.of(
                    ACCOMODATION_CREATE, 
                    ACCOMODATION_READ, 
                    ACCOMODATION_UPDATE
            )
    ),
    MANAGER(
            Set.of(
                    MANAGER_READ,
                    MANAGER_UPDATE,
                    MANAGER_DELETE,
                    MANAGER_CREATE
            )
    );

    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities() {
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}
