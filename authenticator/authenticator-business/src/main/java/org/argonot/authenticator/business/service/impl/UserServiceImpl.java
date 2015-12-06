package org.argonot.authenticator.business.service.impl;

import java.util.List;

import org.argonot.authenticator.business.entity.Authorization;
import org.argonot.authenticator.business.entity.User;
import org.argonot.authenticator.business.repository.AuthorizationRepository;
import org.argonot.authenticator.business.repository.UserRepository;
import org.argonot.authenticator.business.service.UserService;
import org.argonot.commons.utils.CipherUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>UserService</b> implementation
 * @author Meidi
 *
 */
@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthorizationRepository authorizationRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeUser(long idUser) {
        User user = userRepository.findOne(idUser);
        for (Authorization authorization : user.getAuthorizations()) {
            authorizationRepository.delete(authorization);
        }
        userRepository.delete(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void unlockUser(long idUser) {
        User user = userRepository.findOne(idUser);
        user.setLocked(false);
        user.setTries(0);
        userRepository.save(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User find(long idUser) {
        return userRepository.findOne(idUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User update(User userProvided, long idUser) {
        User user = userRepository.findOne(idUser);
        if (user != null) {
            user.setEmail(userProvided.getEmail());
            user.setName(userProvided.getName());
            user.setSurname(userProvided.getSurname());
            if (userProvided.getPassword() != null) {
                user.setPassword(CipherUtils.encrypt(userProvided.getPassword()));
            }
            userRepository.save(user);
            return user;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User create(User user) {
        user.setTries(0);
        user.setLocked(false);
        user.setPassword(CipherUtils.encrypt(user.getPassword()));
        return userRepository.save(user);
    }

}
