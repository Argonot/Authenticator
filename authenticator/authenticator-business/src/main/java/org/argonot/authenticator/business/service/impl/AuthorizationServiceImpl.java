package org.argonot.authenticator.business.service.impl;

import java.util.List;

import org.argonot.authenticator.business.entity.Authorization;
import org.argonot.authenticator.business.repository.AuthorizationRepository;
import org.argonot.authenticator.business.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>AuthorizationService</b> implementation
 * @author Meidi
 *
 */
@Service("AuthorizationService")
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {

    @Autowired
    private AuthorizationRepository authorizationRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Authorization> listAuthorizations() {
        return authorizationRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authorization find(long idAuth) {
        return authorizationRepository.findOne(idAuth);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authorization update(Authorization auth, long idAuth) {
        Authorization authorization = authorizationRepository.findOne(idAuth);
        if (authorization != null) {
            authorization.setApp(auth.getApp());
            authorization.setRole(auth.getRole());
            authorization.setUser(auth.getUser());
            authorizationRepository.save(authorization);
            return authorization;
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Authorization create(Authorization auth) {
        return authorizationRepository.save(auth);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeAuthorization(long idAuth) {
        authorizationRepository.delete(authorizationRepository.findOne(idAuth));
    }
    
}
