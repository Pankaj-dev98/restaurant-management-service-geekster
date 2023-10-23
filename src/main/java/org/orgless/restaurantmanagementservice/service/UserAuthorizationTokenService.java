package org.orgless.restaurantmanagementservice.service;

import jakarta.transaction.Transactional;
import org.orgless.restaurantmanagementservice.entity.User;
import org.orgless.restaurantmanagementservice.entity.UserAuthorizationToken;
import org.orgless.restaurantmanagementservice.persistence.UserAuthorizationTokenDAO;
import org.orgless.restaurantmanagementservice.utils.AuthorizationInputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserAuthorizationTokenService {
    private UserAuthorizationTokenDAO tokenDAO;

    @Autowired
    public UserAuthorizationTokenService(UserAuthorizationTokenDAO tokenDAO) {
        this.tokenDAO = tokenDAO;
    }

    public String createToken(User user) {
        UserAuthorizationToken token = tokenDAO.findByUser(user);
        if(token != null)
            return token.getTokenValue();

        return tokenDAO.save(new UserAuthorizationToken(0, UUID.randomUUID().toString(), user)).getTokenValue();
    }

    public boolean authenticate(String email, String tokenValue) {
        UserAuthorizationToken token = tokenDAO.findByTokenValue(tokenValue);

        return token != null && token.getUser() != null && token.getUser().getEmail().equalsIgnoreCase(email);
    }

    public boolean authenticate(AuthorizationInputDTO authInfo) {
        return authenticate(authInfo.getEmail(), authInfo.getTokenValue());
    }

    @Transactional
    public void removeToken(User user) {
        tokenDAO.deleteByUser(user);
    }
}
