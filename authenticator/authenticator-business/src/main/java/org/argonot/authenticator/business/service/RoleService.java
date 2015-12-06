package org.argonot.authenticator.business.service;

import java.util.List;

import org.argonot.authenticator.business.entity.Role;

/**
 * <b>RoleService</b> provides roles logic
 * @author Meidi
 *
 */
public interface RoleService {

    /**
     * List all the roles availables
     * @return
     */
    List<Role> listRoles();

    /**
     * Find a role by id
     * 
     * @param ruid
     *            : role unique identifier
     * @return a Role
     */
    Role find(String ruid);

    /**
     * Update a provided role
     * 
     * @param role
     *            : provided role
     * @return an updated role
     */
    Role update(Role role);

    /**
     * Create a provided role
     * 
     * @param role
     *            : provided role
     */
    void create(Role role);

    /**
     * Delete a role
     * 
     * @param ruid
     *            : role unique identifier
     */
    void removeRole(String ruid);
}
