/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.repository;

import org.argonot.authenticator.business.entity.Application;
import org.argonot.authenticator.business.entity.Authorization;
import org.argonot.authenticator.business.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b>AuthorizationRepository</b> provide databse access information around the authorizations
 * @author Meidi
 *
 */
public interface AuthorizationRepository extends JpaRepository<Authorization, Long> {

    Authorization findByUserAndApp(User user, Application app);
}
