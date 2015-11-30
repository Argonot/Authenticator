/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.admin.service;

import java.util.List;

import org.argonot.authenticator.business.api.entity.Authorization;

/**
 * <b>AuthorizationService</b> provides authorizations logic
 * @author Meidi
 *
 */
public interface AuthorizationService {

    /**
     * List all the authorizations
     * @return
     */
    List<Authorization> listAuthorizations();
}
