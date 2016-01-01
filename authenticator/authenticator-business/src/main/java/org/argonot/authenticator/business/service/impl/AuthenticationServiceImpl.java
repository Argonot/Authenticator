/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.service.impl;

import org.apache.log4j.Logger;
import org.argonot.authenticator.business.entity.Application;
import org.argonot.authenticator.business.entity.Authorization;
import org.argonot.authenticator.business.entity.User;
import org.argonot.authenticator.business.repository.ApplicationRepository;
import org.argonot.authenticator.business.repository.AuthorizationRepository;
import org.argonot.authenticator.business.repository.UserRepository;
import org.argonot.authenticator.business.service.AuthenticationService;
import org.argonot.commons.utils.CipherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>AuthenticationService</b> implementation
 * @author Meidi
 *
 */
@Service("AuthenticationService")
@Transactional
public class AuthenticationServiceImpl implements AuthenticationService {

    /**
     * Maximum number of authentication tries
     */
    private static final int AUTHENTICATION_MAX_TRIES = 3;

    /**
     * Application logger
     */
    private static final Logger LOGGER = Logger.getLogger(AuthenticationServiceImpl.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorizationRepository authorizationRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public User authenticateUser(String email, String password, String appUID) {
        User user = userRepository.findByEmailIgnoreCase(email);
        if(user != null && isAuthorizedUser(user, password, appUID)) {
            LOGGER.info("Authentication success for user " + email + "on application " + appUID);
            return user;
        }
        LOGGER.warn("Authentication failure for user " + email + " on " + appUID);
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User authenticateUserWithLockStrategy(String email, String password, String appUID) {
        User user = userRepository.findByEmailIgnoreCase(email);
        if(user != null && isAuthorizedUser(user, password, appUID) && !user.isLocked()) {
            LOGGER.info("Authentication success for user " + email + "on application " + appUID);
            return user;
        }
        LOGGER.warn("Authentication failure for user " + email);
        processAuthenticationFailure(user);
        return null;
    }

    /**
     * Say if the User is authorized to use the given application
     * @param email : user entered email
     * @param password : user entered password
     * @param appUID : Application unique identifier
     * @return <b>True</b> : Authorized <br/> <b>False</b> : Unauthorized
     */
    private boolean isAuthorizedUser(User user, String password, String appUID) {
        Application app = applicationRepository.findOne(appUID);
        if(app != null) {
            Authorization authorization = authorizationRepository.findByUserAndApp(user, app);
            if(authorization != null && user.getPassword().equals(CipherUtils.encrypt(password))) {
                LOGGER.info("Found authorization for user " + user.getEmail() + " on application " + authorization.getApp().getName());
                return true;
            }
            LOGGER.warn("Authorization not found for user " + user.getEmail() + " on application " + appUID);
        } else {
            LOGGER.error("Authorization cannot be found because the authenticating application code doesn't exist or is empty");
        }
        return false;
    }

    /**
     * Process all the actions needed against authentication failure<br>
     * - Increment the user's authentication failure count for a known email
     * - Lock the user's account if there are 3 authentication failure streak for a known email
     * @param user : the user who failed the authentication
     */
    private void processAuthenticationFailure(User user) {
        if(user != null) {
            recordAuthenticationFailureAsTry(user);
            lockCompromisedAccount(user);
        } else {
            LOGGER.warn("Impossible to record authentication failure. The user doesn't exist in the system.");
        }
    }

    /**
     * Increment the user's authentication failure count for a known email
     * @param user : the user who failed the authentication
     */
    private void recordAuthenticationFailureAsTry(User user) {
        if(user.getTries() < AUTHENTICATION_MAX_TRIES) {
            user.setTries(user.getTries() + 1);
            userRepository.save(user);
            LOGGER.warn("Authentication failure recorded for user " + user.getEmail());
            LOGGER.warn("New user authentication failure streak count : " + user.getTries());
        }
    }

    /**
     * Lock the user's account if there are 3 authentication failure streak for a known email
     * @param user : the user who failed the authentication
     */
    private void lockCompromisedAccount(User user) {
        if(user.getTries() == AUTHENTICATION_MAX_TRIES) {
            user.setLocked(true);
            userRepository.save(user);
            LOGGER.warn("User account was locked by the system for user " + user.getEmail());
        }
    }
}
