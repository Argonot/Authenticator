package org.argonot.authenticator.admin.service.impl;

import java.util.List;

import org.argonot.authenticator.admin.service.AuthorizationService;
import org.argonot.authenticator.business.api.entity.Authorization;
import org.argonot.authenticator.business.api.repository.AuthorizationRepository;
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
