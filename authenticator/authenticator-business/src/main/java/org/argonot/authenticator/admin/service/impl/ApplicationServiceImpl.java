package org.argonot.authenticator.admin.service.impl;

import java.util.List;

import org.argonot.authenticator.admin.service.ApplicationService;
import org.argonot.authenticator.business.api.entity.Application;
import org.argonot.authenticator.business.api.repository.ApplicationRepository;
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
