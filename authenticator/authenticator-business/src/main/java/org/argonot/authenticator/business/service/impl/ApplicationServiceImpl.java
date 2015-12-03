package org.argonot.authenticator.business.service.impl;

import java.util.List;

import org.argonot.authenticator.business.entity.Application;
import org.argonot.authenticator.business.repository.ApplicationRepository;
import org.argonot.authenticator.business.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>ApplicationService</b> implementation
 * @author Meidi
 *
 */
@Service("ApplicationService")
@Transactional
public class ApplicationServiceImpl implements ApplicationService {
    
    @Autowired
    private ApplicationRepository applicationRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Application> listApplications() {
        return applicationRepository.findAll();
    }

}
