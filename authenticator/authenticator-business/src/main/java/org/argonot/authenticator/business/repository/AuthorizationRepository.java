/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.repository;

import org.argonot.authenticator.business.entity.Application;
import org.argonot.authenticator.business.entity.Authorization;
import org.argonot.authenticator.business.entity.Role;
import org.argonot.authenticator.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b>AuthorizationRepository</b> provide databse access information around the authorizations
 * @author Meidi
 *
 */
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    /**
     * Find an authorization for a requesting user/app
     * @param user : user requesting an authorization
     * @param app : application requesting the user authentication
     * @return 
     */
    Authorization findByUserAndApp(User user, Application app);

    /**
     * Find an authorization for a user on an app with a certain role
     * @param user : user authorized
     * @param app : application concerned
     * @param role : role granted to user
     * @return an authorization
     */
    Authorization findByUserAndAppAndRole(User user, Application app, Role role);
}
