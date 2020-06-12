package com.justterror.chefsbook.user.boundary;

import com.justterror.chefsbook.meal.entity.Meal;
import com.justterror.chefsbook.security.JWTAuthenticationMechanism;
import com.justterror.chefsbook.user.entity.User;
import com.sun.deploy.association.RegisterFailedException;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jws.soap.SOAPBinding;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.security.enterprise.AuthenticationException;
import javax.security.enterprise.identitystore.PasswordHash;
import javax.ws.rs.core.Response;
import javax.xml.registry.RegistryException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.justterror.chefsbook.security.Constants;
import static sun.security.x509.CertificateAlgorithmId.ALGORITHM;

@Stateless
public class UserService {

    @Inject
    Logger logger;

    @Inject
    UserRepository repository;

    @PersistenceContext(name="users")
    private EntityManager entityManager;
    private static final SecureRandom RAND = new SecureRandom();



    public String login(String username, String password) {
        User user = repository.findByUsername(username);
        if (user != null) {
            String hashedInputPwd = getMD5Hash(password);
            if (user.getPassword().equals(hashedInputPwd))
            {
                return "token jwt";
            }
        }
        return "Failure";
    }

    public User register(String  username, String password) {
        if (!isUserDuplicate(username) && username != null && password != null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(getMD5Hash(password));
            user.setRole(Constants.USER);
            return repository.save(user);
        } else {
            //TODO:: To debug this
            return null;
        }
    }

    private boolean isUserDuplicate(String username) {
        logger.info("Verifing does username = " + username + "is unique");
        User user = repository.findByUsername(username);
        return user != null;
    }

    public static String getMD5Hash(String input) {
        StringBuffer sb = new StringBuffer();

        try {
            MessageDigest md =
                    MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] mdbytes = md.digest();

            //convert the byte to hex format
            for (int i = 0; i < mdbytes.length; i++) {
                sb.append(Integer.toString((mdbytes[i] & 0xff)
                        + 0x100, 16).substring(1));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return sb.toString();
    }
}
