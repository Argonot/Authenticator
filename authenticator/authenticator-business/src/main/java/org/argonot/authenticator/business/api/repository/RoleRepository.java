/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.api.repository;

import org.argonot.authenticator.business.api.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <b>RoleRepository</b> provide databse access information around the roles
 * @author Meidi
 *
 */
public interface RoleRepository extends JpaRepository<Role, Long> {

}
