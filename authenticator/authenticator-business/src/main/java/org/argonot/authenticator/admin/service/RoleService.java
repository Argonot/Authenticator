package org.argonot.authenticator.admin.service;

import java.util.List;

import org.argonot.authenticator.business.api.entity.Role;

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
}
