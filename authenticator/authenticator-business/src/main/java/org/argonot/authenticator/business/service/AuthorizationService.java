/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.service;

import java.util.List;

import org.argonot.authenticator.business.entity.Authorization;

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

    /**
     * Finds an authorization by unique id
     * 
     * @param idAuth
     *            : authorization unique id
     * @return
     */
    Authorization find(long idAuth);

    /**
     * Update an authorization
     * 
     * @param auth
     *            : the authorization to update
     * @param idAuth
     *            : the provided authorization information
     * @return
     */
    Authorization update(Authorization auth, long idAuth);

    /**
     * Create an authorization
     * 
     * @param auth
     *            : authorization to create
     * @return
     */
    Authorization create(Authorization auth);

    /**
     * Permanently remove an authorization
     * 
     * @param idAuth
     *            : authorization to remove unique id
     */
    void removeAuthorization(long idAuth);
}
