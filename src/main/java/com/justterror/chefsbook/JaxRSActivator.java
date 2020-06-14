package com.justterror.chefsbook;

import javax.annotation.security.DeclareRoles;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import static com.justterror.chefsbook.security.Constants.ADMIN;
import static com.justterror.chefsbook.security.Constants.USER;

@DeclareRoles({ADMIN, USER})
    @ApplicationPath("/api")
public class JaxRSActivator extends Application {
}
