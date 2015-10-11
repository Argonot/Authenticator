/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.service;

import org.argonot.authenticator.business.entity.User;


/**
 * <b>AuthentificationService</b> provides common actions around the Users
 * @author Meidi
 *
 */
public interface AuthenticationService {

    /**
     * Say if the User is authorized to use the given application
     * @param email : user entered email
     * @param password : user entered password
     * @param appUID : Application unique identifier
     * @return <b>True</b> : Access granted <br/> <b>False</b> : Access denied
     */
    boolean isAuthorized(String email, String password, String appUID);

    /**
     * Try to authentificate a User by email and password provided
     * @param email : user entered email
     * @param password : user entered password
     * @param appUID : application unique identifier
     * @param sessionId : session unique identifier
     * @return success : user | fail : null
     */
    User authentificateUser(String email, String password, String appUID, String sessionId);

}
