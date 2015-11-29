/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.api.repository;

import org.argonot.authenticator.business.api.entity.Application;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * <b>ApplicationRepository</b> provide databse access information around the applications
 * @author Meidi
 *
 */
public interface ApplicationRepository extends JpaRepository<Application, String>  {

}
