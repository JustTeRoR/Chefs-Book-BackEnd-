package com.justterror.chefsbook.security;

import com.justterror.chefsbook.user.boundary.UserRepository;
import com.justterror.chefsbook.user.entity.User;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static com.justterror.chefsbook.security.Constants.ADMIN;
import static com.justterror.chefsbook.security.Constants.USER;
import static java.util.Collections.emptySet;
import static java.util.Collections.singleton;
import static java.util.Arrays.asList;
import static javax.security.enterprise.identitystore.IdentityStore.ValidationType.PROVIDE_GROUPS;

public class AuthorizationIdentityStore implements IdentityStore {

    @Inject
    UserRepository repository;

    @PersistenceContext(name="users")
    private EntityManager entityManager;

    @Override
    public Set<String> getCallerGroups(CredentialValidationResult validationResult) {
        Set<String> result;
        User expectedUser = repository.findByUsername(validationResult.getCallerPrincipal().getName());
        result = (singleton(expectedUser.getRole()));
        if (result == null) {
            result = emptySet();
        }
        return result;
    }

    @Override
    public Set<ValidationType> validationTypes() {
        return singleton(PROVIDE_GROUPS);
    }

}