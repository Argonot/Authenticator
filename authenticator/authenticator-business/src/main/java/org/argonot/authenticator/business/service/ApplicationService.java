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
     * 
     * @return all the applications
     */
    List<Application> listApplications();

    /**
     * Find an application by id
     * 
     * @param auid
     *            : application unique ID
     * @return the found application
     */
    Application find(String auid);

    /**
     * Update an existing application
     * 
     * @param app
     *            : the provided application information
     * @return the updated application
     */
    Application update(Application app);

    /**
     * Create an application
     * 
     * @param app
     *            : the new application to create
     * @return the saved application
     */
    Application create(Application app);

    /**
     * Delete an application permanently
     * 
     * @param auid
     *            : the application unique identifier
     */
    void removeApplication(String auid);
}
