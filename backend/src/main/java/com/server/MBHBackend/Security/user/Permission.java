package com.server.MBHBackend.Security.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("admin:read"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_CREATE("admin:create"),
    ADMIN_DELETE("admin:delete"),
    
    MANAGER_READ("management:read"),
    MANAGER_UPDATE("management:update"),
    MANAGER_CREATE("management:create"),
    MANAGER_DELETE("management:delete"),
        
    
    BUSINESS_READ("business:read"),
    BUSINESS_UPDATE("business:update"),
    BUSINESS_CREATE("business:create"),
    //BUSINESS_DELETE("business:delete");
    
    ACCOMODATION_READ("accomodation:read"),
    ACCOMODATION_UPDATE("accomodation:update"),
    ACCOMODATION_CREATE("accomodation:create");
    
    @Getter
    private final String permission;
}
