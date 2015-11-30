package org.argonot.authenticator.admin.service.impl;

import java.util.List;

import org.argonot.authenticator.admin.service.UserService;
import org.argonot.authenticator.business.api.entity.User;
import org.argonot.authenticator.business.api.repository.UserRepository;
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
    UserRepository userRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<User> listUsers() {
        return userRepository.findAll();
    }

}
