/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.service;

import org.argonot.authenticator.business.entity.User;


/**
 * <b>AuthenticationService</b> provides common actions around the Users
 * @author Meidi
 *
 */
public interface AuthenticationService {

    /**
     * Try to authenticate a User by email and password provided
     * @param email : user entered email
     * @param password : user entered password
     * @param appUID : application unique identifier
     * @return success : user | fail : null
     */
    User authenticateUser(String email, String password, String appUID);
    
    /**
     * Try to authenticate a User by email and password provided with three tries before the account is locked
     * @param email
     * @param password
     * @param appUID
     * @return
     */
    User authenticateUserWithLockStrategy(String email, String password, String appUID);
}
