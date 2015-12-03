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
    
}
