package org.argonot.authenticator.admin.service.impl;

import java.util.List;

import org.argonot.authenticator.admin.service.RoleService;
import org.argonot.authenticator.business.api.entity.Role;
import org.argonot.authenticator.business.api.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>RoleService</b> implementation
 * @author Meidi
 *
 */
@Service("RoleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Role> listRoles() {
        return roleRepository.findAll();
    }

}
