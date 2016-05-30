/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.argonot.authenticator.api.util.EnvironmentVariables;
import org.argonot.authenticator.api.vo.CredentialsVO;
import org.argonot.authenticator.business.entity.User;
import org.argonot.authenticator.business.service.AuthenticationService;
import org.argonot.authenticator.business.service.UserService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <b>UserController</b> expose every RESTFUL methods that can be called relative to a User manipulation
 * @author Meidi
 *
 */
@Controller
@RequestMapping("/users")
public class UserController extends AbstractAuthenticatorController {
    
    private static final String ACCEPT_APPLICATION_JSON_HEADER = "Accept=application/json";

    @Autowired
    private Mapper mapper;
    
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationService authenticationService;
    
    @Autowired
    private EnvironmentVariables environmentVariables;

    /**
     * Simply authenticate a User from his credentials
     * 
     * @param credentials
     *            : user authentication information
     * @return credentials in json
     */
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST, headers = ACCEPT_APPLICATION_JSON_HEADER)
    @ResponseBody
    public CredentialsVO authenticateUser(@RequestBody CredentialsVO credentials) {
        return mapper.map(authenticationService.authenticateUser(credentials.getEmail(), credentials.getPassword(),
                credentials.getAuid()), CredentialsVO.class);
    }
    
    /**
     * Authenticate a User from his credentials with 3 tries before account lock
     * 
     * @param credentials
     *            : user authentication information
     * @return credentials in json
     */
    @RequestMapping(value = "/authenticate/strong", method = RequestMethod.POST, headers = ACCEPT_APPLICATION_JSON_HEADER)
    @ResponseBody
    public CredentialsVO strongAuthenticateUser(@RequestBody CredentialsVO credentials) {
        return mapper.map(authenticationService.authenticateUserWithLockStrategy(credentials.getEmail(),
                credentials.getPassword(), credentials.getAuid()), CredentialsVO.class);
    }

    /**
     * Route for subscribing User to an app
     * 
     * @param credentials
     *            : user credentials
     * @return recorded user
     */
    @RequestMapping(value = "/subscribe", method = RequestMethod.POST, headers=ACCEPT_APPLICATION_JSON_HEADER)
    @ResponseBody
    public CredentialsVO subscribeUser(@RequestBody CredentialsVO credentials, HttpServletRequest request) {
        return this.mapper.map(userService.subscribe(mapper.map(credentials, User.class), credentials.getAuid(),
                credentials.getRuid(), this.getRootUrl(request)), CredentialsVO.class);
    }
    
    /**
     * Route for subscribing User to an app
     * @param credentials : user credentials
     * @return recorded user
     */
    @RequestMapping(value = "/update/{idUser}", method = RequestMethod.POST, headers=ACCEPT_APPLICATION_JSON_HEADER)
    @ResponseBody
    public CredentialsVO updateUser(@RequestBody CredentialsVO credentials, @PathVariable long idUser) {
        return this.mapper.map(userService.update(mapper.map(credentials, User.class), idUser), CredentialsVO.class);
    }
    
    /**
     * Route to update a user avatar
     * 
     * @param avatar base64
     * @return avatar URL
     */
    @RequestMapping(value = "/avatar/upload", method = RequestMethod.POST, headers = ACCEPT_APPLICATION_JSON_HEADER)
    @ResponseBody
    public CredentialsVO updateUserAvatar(@RequestBody CredentialsVO credentials) {
        return this.mapper.map(userService.updateUserAvatar(credentials.getAvatar(), environmentVariables.getAvatarUploadFolder(), environmentVariables.getAvatarUploadUrl(), this.mapper.map(credentials, User.class)), CredentialsVO.class);
    }

}
