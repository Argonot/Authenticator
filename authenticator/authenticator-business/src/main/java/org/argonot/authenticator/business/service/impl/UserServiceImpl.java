package org.argonot.authenticator.business.service.impl;

import java.util.HashSet;
import java.util.List;

import org.apache.log4j.Logger;
import org.argonot.authenticator.business.dto.UserDTO;
import org.argonot.authenticator.business.entity.Authorization;
import org.argonot.authenticator.business.entity.User;
import org.argonot.authenticator.business.repository.ApplicationRepository;
import org.argonot.authenticator.business.repository.RoleRepository;
import org.argonot.authenticator.business.repository.UserRepository;
import org.argonot.authenticator.business.service.AuthorizationService;
import org.argonot.authenticator.business.service.UserService;
import org.argonot.commons.utils.CipherUtils;
import org.dozer.Mapper;
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
    
    private static final String ANONYMOUS_AVATAR_RESOURCE_PATH = "/resources/img/anonymous_200.gif";

    /**
     * Application logger
     */
    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private Mapper mapper;

    @Autowired
    private AuthorizationService authorizationService;
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private RoleRepository roleRepository;
    
    @Autowired
    private ApplicationRepository appRepository;

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
    public boolean removeUser(long idUser) {
        try {
            userRepository.delete(userRepository.findOne(idUser));
            return true;
        } catch(Exception e) {
            return false;
        }
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
    public UserDTO update(User userProvided, long idUser) {
        User user = userRepository.findOne(idUser);
        if (user != null) {
            user.setEmail(userProvided.getEmail());
            user.setName(userProvided.getName());
            user.setSurname(userProvided.getSurname());
            if (userProvided.getPassword() != null && userProvided.getPassword() != user.getPassword() && !userProvided.getPassword().equals("")) {
                user.setPassword(CipherUtils.encrypt(userProvided.getPassword()));
            }
            userRepository.save(user);
            return this.mapper.map(user, UserDTO.class);
        }
        String errorMessage = "Impossible to update user";
        LOGGER.warn(errorMessage);
        return new UserDTO(true, errorMessage);
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

    /**
     * {@inheritDoc}
     */
    @Override
    public UserDTO subscribe(User subscribingUser, String auid, String ruid, String contextPath) {
        User user = userRepository.findByEmailIgnoreCase(subscribingUser.getEmail());
        if(user == null) {
            subscribingUser.setAvatar(contextPath + ANONYMOUS_AVATAR_RESOURCE_PATH);
            user = this.create(subscribingUser);
            user.setAuthorizations(new HashSet<Authorization>());
            authorizationService.create(new Authorization(user, appRepository.findOne(auid) , roleRepository.findOne(ruid)));
        } else if(user != null && !authorizationService.existsAuthorization(user, auid, ruid)) {
            authorizationService.create(new Authorization(user, appRepository.findOne(auid) , roleRepository.findOne(ruid)));
        } else {
            String errorMessage = "Impossible to record user";
            LOGGER.warn(errorMessage);
            return new UserDTO(true, errorMessage);
        }
        return this.mapper.map(user, UserDTO.class);
    }

}