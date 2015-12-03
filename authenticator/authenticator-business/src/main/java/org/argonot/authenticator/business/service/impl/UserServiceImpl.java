package org.argonot.authenticator.business.service.impl;

import java.util.List;

import org.argonot.authenticator.business.entity.User;
import org.argonot.authenticator.business.repository.UserRepository;
import org.argonot.authenticator.business.service.UserService;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

}
