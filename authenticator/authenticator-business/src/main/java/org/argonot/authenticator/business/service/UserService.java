package org.argonot.authenticator.business.service;

import java.util.List;

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
     */
    void removeUser(long idUser);

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
    User update(User user, long idUser);

    /**
     * Create user
     * 
     * @param user
     * @return
     */
    User create(User user);
}
