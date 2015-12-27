package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.argonot.authenticator.business.entity.Authorization;
import org.argonot.authenticator.business.entity.Role;
import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorizationServiceTest extends AbstractBusinessSpringContextTest {

    private static final long AUTHORIZATION_TO_REMOVE_ID = 7L;

    private static final String TRELLO_KPI_AUID = "TKP";

    private static final long FIRST_USER_ID = 1L;

    private static final String ADMIN_ROLE_NAME = "ADMIN";

    private static final String ADMIN_ROLE_ID = "ADM";

    private static final long AUTH_ID_TO_UPDATE = 6L;

    private static final long FIRST_AUTHORIZATION_ID = 1L;
    
    @Autowired
    private AuthorizationService authorisationService;
    
    @Autowired
    private UserService userService;
    
    @Autowired
    private ApplicationService appService;
    
    @Autowired
    private RoleService roleService;

    @Test
    public void testListAuthorizations() {
        assertTrue(CollectionUtils.isNotEmpty(authorisationService.listAuthorizations()));
    }
    
    @Test
    public void testFindAuthorization() {
        assertNotNull(authorisationService.find(FIRST_AUTHORIZATION_ID));
    }
    
    @Test
    public void testUpdateAuthorization() {
        Authorization authUpdate = authorisationService.find(AUTH_ID_TO_UPDATE);
        Role newRole = new Role(ADMIN_ROLE_ID, ADMIN_ROLE_NAME);
        authUpdate.setRole(newRole);
        assertEquals(ADMIN_ROLE_NAME, authorisationService.update(authUpdate, AUTH_ID_TO_UPDATE).getRole().getName());
        
    }
    
    @Test
    public void testCreateAuthorization() {
        assertNotNull(authorisationService.create(new Authorization(userService.find(FIRST_USER_ID), appService.find(TRELLO_KPI_AUID), roleService.find(ADMIN_ROLE_ID))));
    }
    
    @Test
    public void testRemoveAuthorization() {
        authorisationService.removeAuthorization(AUTHORIZATION_TO_REMOVE_ID);
        assertNull(authorisationService.find(AUTHORIZATION_TO_REMOVE_ID));
    }
}
