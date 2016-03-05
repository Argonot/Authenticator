package org.argonot.authenticator.api.controller;

import javax.servlet.http.HttpServletRequest;

/**
 * <b>AbstractAuthenticatorController</b> regroup all commons methods for
 * authenticator's controllers
 * 
 * @author Meidi
 *
 */
public abstract class AbstractAuthenticatorController {

    /**
     * Build the application base URL
     * 
     * @param request
     *            : Http request
     * @return BASEURL
     */
    protected String getRootUrl(HttpServletRequest request) {
        return request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
                + request.getContextPath();
    }
}
