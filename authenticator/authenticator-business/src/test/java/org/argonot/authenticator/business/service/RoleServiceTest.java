package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.argonot.authenticator.business.entity.Role;
import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RoleServiceTest extends AbstractBusinessSpringContextTest {

    private static final String GUEST_ROLE_NAME = "GUEST";
    private static final String GUEST_ROLE_RUID = "GST";
    private static final String ADMIN_ROLE_RUID = "ADM";
    private static final String REMOVE_ROLE_RUID = "RMV";
    private static final String ADMIN_ROLE_NAME = "ADMIN";
    private static final String USER_ROLE_NAME = "USER";
    
    private static final Role role = new Role();
    private static final Role newRole = new Role();
    
    @Autowired
    RoleService roleService;
    
    @BeforeClass
    public static void setUpTest() {
        newRole.setId(GUEST_ROLE_RUID);
        newRole.setName(GUEST_ROLE_NAME);
    }
    
    @Before
    public void setUpTests() {
        role.setId(ADMIN_ROLE_RUID);
        role.setName(ADMIN_ROLE_NAME);
    }

    @Test
    public void testListRoles() {
        assertTrue(CollectionUtils.isNotEmpty(roleService.listRoles()));
    }
    
    @Test
    public void testFindRole() {
        assertTrue(roleService.find(ADMIN_ROLE_RUID) != null);
    }
    
    @Test
    public void testUpdateRole() {
        role.setName(USER_ROLE_NAME);
        assertTrue(USER_ROLE_NAME.equals(roleService.update(role).getName()));
    }
    
    @Test
    public void testCreateRole() {
        assertTrue(roleService.create(newRole) != null);
    }
    
    @Test
    public void testRemoveRole() {
        assertTrue(roleService.removeRole(REMOVE_ROLE_RUID));
    }
    
    @Test
    public void testRemoveUnexistingRole() {
        assertFalse(roleService.removeRole(GUEST_ROLE_RUID));
    }
    
    @Test
    public void testCreateExistingRole() {
        assertNull(roleService.create(role));
    }
}
