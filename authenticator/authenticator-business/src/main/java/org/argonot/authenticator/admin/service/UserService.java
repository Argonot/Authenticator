package org.argonot.authenticator.admin.service;

import java.util.List;

import org.argonot.authenticator.business.api.entity.User;

/**
 * <b>UserService</b> provides user logic
 * @author Meidi
 *
 */
public interface UserService {

    /**
     * List all the users
     * @return
     */
    List<User> listUsers();
}
