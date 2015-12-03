package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceTest extends AbstractBusinessSpringContextTest {

    @Autowired
    RoleService roleService;

    @Test
    public void testListRoles() {
        assertTrue(CollectionUtils.isNotEmpty(roleService.listRoles()));
    }
}
