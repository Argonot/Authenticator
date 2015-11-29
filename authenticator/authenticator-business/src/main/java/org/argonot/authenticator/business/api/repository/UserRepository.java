/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.api.repository;

import org.argonot.authenticator.business.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

/**
 * <b>UserRepository</b> provide databse access information around the users
 * @author Meidi
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Find a user by his email
     * @param email
     * @return User
     */
    User findByEmail(@Param("email") String email);

}
