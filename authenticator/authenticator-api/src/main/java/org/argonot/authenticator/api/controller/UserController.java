/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.api.controller;

import javax.servlet.http.HttpServletRequest;

import org.argonot.authenticator.api.utils.AbstractAuthenticatorController;
import org.argonot.authenticator.api.vo.CredentialsVO;
import org.argonot.authenticator.business.entity.User;
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
    
    @Autowired
    private Mapper mapper;
    
    @Autowired
    private UserService userService;
    
    /**
     * Route for subscribing User to an app
     * @param credentials : user credentials
     * @return recorded user
     */
    @RequestMapping(value = "/subscribe", method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseBody
    public User subscribeUser(@RequestBody CredentialsVO credentials, HttpServletRequest request) {
        return userService.subscribe(mapper.map(credentials, User.class), credentials.getAuid(), credentials.getRuid(),
                this.getRootUrl(request));
    }
    
    /**
     * Route for subscribing User to an app
     * @param credentials : user credentials
     * @return recorded user
     */
    @RequestMapping(value = "/update/{idUser}", method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseBody
    public User updateUser(@RequestBody CredentialsVO credentials, @PathVariable long idUser) {
        return userService.update(mapper.map(credentials, User.class), idUser);
    }

}
