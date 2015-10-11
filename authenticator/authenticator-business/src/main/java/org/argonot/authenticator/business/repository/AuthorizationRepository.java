/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.repository;

import org.argonot.authenticator.business.entity.Authorization;
import org.argonot.authenticator.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * <b>AuthorizationRepository</b> provide databse access information around the authorizations
 * @author Meidi
 *
 */
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    /**
     * Find an authorization by User
     * @param user
     * @return Authorization
     */
    Authorization findByUser(@Param("user") User user);

}
