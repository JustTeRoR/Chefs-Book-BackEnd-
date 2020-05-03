package com.justterror.chefsbook.security;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import static com.justterror.chefsbook.security.Constants.REMEMBERME_VALIDITY_SECONDS;

public class TokenProvider {
    @Inject
    Logger logger;

    private static final String AUTHORITIES_KEY = "auth";

    private String secretKey;

    private long tokenValidity;

    private long tokenValidityForRememberMe;

    @PostConstruct
    public void init() {
        // load from config
        this.secretKey = "my-secret-jwt-key";
        this.tokenValidity = TimeUnit.HOURS.toMillis(10);   //10 hours
        this.tokenValidityForRememberMe = TimeUnit.SECONDS.toMillis(REMEMBERME_VALIDITY_SECONDS);   //24 hours

        
    }
}
