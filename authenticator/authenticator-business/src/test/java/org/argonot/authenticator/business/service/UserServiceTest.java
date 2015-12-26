package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends AbstractBusinessSpringContextTest {

    private static final long USER_TO_REMOVE_ID = 5L;
    
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
    
}
