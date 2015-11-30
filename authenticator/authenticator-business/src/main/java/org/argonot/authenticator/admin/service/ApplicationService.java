package org.argonot.authenticator.admin.service;

import java.util.List;

import org.argonot.authenticator.business.api.entity.Application;

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
