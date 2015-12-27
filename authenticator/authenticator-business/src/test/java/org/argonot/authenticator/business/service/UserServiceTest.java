package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;

import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends AbstractBusinessSpringContextTest {

    private static final long LOCKED_USER_ID = 2L;
    private static final long USER_TO_REMOVE_ID = 5L;
    private static final long UNKNOWN_USER_ID = 9999L;
    
    @Autowired
    UserService userService;
    
    @Autowired
    AuthorizationService authService;

    @Test
    public void testListUsers() {
        assertTrue(CollectionUtils.isNotEmpty(userService.listUsers()));
    }

    @Test
    public void testRemovedUserDoesntExistsAnymore() {
        assertTrue(userService.removeUser(USER_TO_REMOVE_ID));
    }
    
    @Test
    public void testRemoveUnknownUser() {
        assertFalse(userService.removeUser(UNKNOWN_USER_ID));
    }
   
    @Test
    public void testUnlockUser() {
        userService.unlockUser(LOCKED_USER_ID);
        assertFalse(userService.find(LOCKED_USER_ID).isLocked());
    }
    
}
