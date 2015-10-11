/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.api.controller;

import javax.servlet.http.HttpSession;

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
@RequestMapping("/authentificator")
public class AuthenticatorController {

    @Autowired
    private Mapper mapper;

    @Autowired
    private AuthenticationService authenticationService;

    /**
     * Authentificate a User
     * 
     * @return json string
     */
    @RequestMapping(value = "/authentificate/user", method = RequestMethod.POST, headers="Accept=application/json")
    @ResponseBody
    public CredentialsVO authentificateUser(@RequestBody CredentialsVO credentials, HttpSession session) {
        User userSession =  authenticationService.authentificateUser(credentials.getEmail(), credentials.getPassword(), credentials.getAuid(), session.getId());
        return mapper.map(userSession, CredentialsVO.class);
    }

}
