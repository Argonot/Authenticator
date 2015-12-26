package org.argonot.authenticator.business.service.impl;

import java.util.List;

import org.argonot.authenticator.business.entity.Role;
import org.argonot.authenticator.business.repository.RoleRepository;
import org.argonot.authenticator.business.service.RoleService;
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

    /**
     * {@inheritDoc}
     */
    @Override
    public Role find(String ruid) {
        return roleRepository.findOne(ruid);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role update(Role role) {
        return roleRepository.save(role);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Role create(Role role) {
        if (roleRepository.findOne(role.getId()) == null) {
            return roleRepository.save(role);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean removeRole(String ruid) {
        try {
            roleRepository.delete(roleRepository.findOne(ruid));
            return true;
        } catch(Exception e) {
            return false;
        }
    }
}
