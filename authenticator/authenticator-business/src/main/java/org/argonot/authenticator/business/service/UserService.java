package org.argonot.authenticator.business.service;

import java.util.List;

import org.argonot.authenticator.business.dto.UserDTO;
import org.argonot.authenticator.business.entity.User;

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

    /**
     * Delete a User
     * 
     * @param idUser
     *            : user id
     * @return true if removed / false otherwise
     */
    boolean removeUser(long idUser);

    /**
     * Unlock a User
     * 
     * @param idUser
     *            : user id
     */
    void unlockUser(long idUser);

    /**
     * Get a user by id
     * 
     * @param idUser
     *            : user id
     * @return
     */
    User find(long idUser);

    /**
     * Update a user
     * 
     * @param user
     *            : user information provided
     * @param idUser : user unique id
     * 
     * @return
     */
    UserDTO update(User user, long idUser);

    /**
     * Create user
     * 
     * @param user
     * @return
     */
    User create(User user);

    /**
     * Create a user if needed and authorized on the app
     * 
     * @param user
     *            : user to create and / or authorize
     * @param auid
     *            : id of app registering the user
     * @param ruid
     *            : user role
     * @param contextPath
     *            : used to build default user avatar URL
     * @return the user
     */
    UserDTO subscribe(User user, String auid, String ruid, String contextPath);

}
