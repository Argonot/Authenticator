/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.service.impl;


import org.argonot.authenticator.business.entity.User;
import org.argonot.authenticator.business.repository.AuthorizationRepository;
import org.argonot.authenticator.business.repository.UserRepository;
import org.argonot.authenticator.business.service.AuthenticationService;
import org.argonot.commons.utils.CipherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("AuthentificatorService")
@Transactional
public class AuthenticatorServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorizationRepository authorizationRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isAuthorized(String email, String password, String appUID) {
        User user = userRepository.findByEmail(email);
        if(user != null && user.getPassword().equals(CipherUtils.encrypt(password)) && authorizationRepository.findByUser(user).getApp().getId().equals(appUID)) {
            return true;
        }
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User authenticateUser(String email, String password, String appUID) {
        if(isAuthorized(email, password, appUID)) {
            User user = userRepository.findByEmail(email);
            return user;
        }
        return null;
    }

}
