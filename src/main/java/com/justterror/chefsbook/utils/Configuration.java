package com.justterror.chefsbook.utils;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.security.enterprise.SecurityContext;
import java.util.logging.Logger;


public class Configuration {
    @Produces
    public Logger produceLog(InjectionPoint injectionPoint) {
        return Logger.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
    }
}