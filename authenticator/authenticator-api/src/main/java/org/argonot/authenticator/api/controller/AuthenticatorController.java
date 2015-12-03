/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.api.controller;

import org.argonot.authenticator.api.vo.CredentialsVO;
import org.argonot.authenticator.business.entity.User;
import org.argonot.authenticator.business.service.AuthenticationService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * <b>AuthentificatorController</b> expose every RESTFUL methods that can be called relative to an authentification
 * @author Meidi
 *
 */
@Controller
@SessionAttributes({"userSession"})
@RequestMapping("/authenticator")
public class AuthenticatorController {

    @Autowired
    private Mapper mapper;

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * Simply authenticate a User from his credentials
     * @param credentials : user authentication information
     * @return credentials in json
     */
    @RequestMapping(value = "/authenticate/user", method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseBody
    public CredentialsVO authenticateUser(@RequestBody CredentialsVO credentials) {
        User user =  authenticationService.authenticateUser(credentials.getEmail(), credentials.getPassword(), credentials.getAuid());
        return mapper.map(user, CredentialsVO.class);
    }
    
    /**
     * Authenticate a User from his credentials with 3 tries before account lock
     * @param credentials : user authentication information
     * @return credentials in json
     */
    @RequestMapping(value = "/secure/authenticate/user", method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseBody
    public CredentialsVO secureAuthenticateUser(@RequestBody CredentialsVO credentials) {
        User user =  authenticationService.authenticateUserWithLockStrategy(credentials.getEmail(), credentials.getPassword(), credentials.getAuid());
        return mapper.map(user, CredentialsVO.class);
    }
    
    /**
     * Authenticate a User from his credentials with 3 tries before account lock
     * @param credentials : user authentication information
     * @return credentials in json
     */
    @RequestMapping(value = "/admin/user/account/status", method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseBody
    public Boolean userAccountStatus(@RequestBody CredentialsVO credentials) {
        return authenticationService.isUserLocked(credentials.getEmail());
    }

}
