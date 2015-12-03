package org.argonot.authenticator.business.service;

import java.util.List;

import org.argonot.authenticator.business.entity.Application;

/**
 * <b>ApplicationService</b> provides applications logic
 * @author Meidi
 *
 */
public interface ApplicationService {

    /**
     * List all the applications
     * @return
     */
    List<Application> listApplications();
}
