package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.argonot.authenticator.business.entity.User;
import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceTest extends AbstractBusinessSpringContextTest {

    private static final String EXPECTED_USER_AVATAR_URL = "http://localhost:8080/authenticator-api/resources/anonymous_200.gif";
    private static final String LOCAL_AUTHENTICATOR_URL = "http://localhost:8080/authenticator-api";
    private static final String NEW_USER_EMAIL = "newUser@gmail.com";
    private static final String NEW_USER_NAME = "newUserName";
    private static final String NEW_USER_SURNAME = "newUserSurname";
    private static final String SUBSCRIBING_USER_EMAIL = "subscribingUser@gmail.com";
    private static final String SUBSCRIBING_USER_NAME = "subscribingUserName";
    private static final String SUBSCRIBING_USER_SURNAME = "subscribingUserSurname";
    private static final String SUBSCRIBING_AVATAR_USER_EMAIL = "subscribingUser@gmail.com";
    private static final String SUBSCRIBING_AVATAR_USER_NAME = "subscribingUserName";
    private static final String SUBSCRIBING_AVATAR_USER_SURNAME = "subscribingUserSurname";
    private static final String UPDATE_USER_EMAIL = "updateuser@gmail.com";
    private static final String UPDATE_USER_NAME = "UpdateUserName";
    private static final String USER_PASSWORD = "Test1.";
    private static final long UPDATE_USER_ID = 6L;
    private static final String UPDATE_USER_NEW_SURNAME = "test";
    private static final String EXISTING_USER_EMAIL = "meidi.airouche@gmail.com";
    private static final long LOCKED_USER_ID = 2L;
    private static final long USER_TO_REMOVE_ID = 4L;
    private static final long UNKNOWN_USER_ID = 9999L;
    private static final String FORGE_APP_AUID = "FRG";
    private static final String APP_AUID_WITH_NO_AUTH_FOR_USER = "TKP";
    private static final String USER_ROLE_RUID = "USR";
    private static final String ADMIN_ROLE_RUID = "ADM";
    
    private static final User newUser = new User();
    private static final User subscribingUser = new User();
    private static final User subscribingUserForAvatar = new User();
    private static final User updateUser = new User();
    
    @Autowired
    UserService userService;
    
    @Autowired
    AuthorizationService authService;
    
    @Before
    public void setUpTests() {
        newUser.setEmail(NEW_USER_EMAIL);
        newUser.setName(NEW_USER_NAME);
        newUser.setSurname(NEW_USER_SURNAME);
        newUser.setPassword(USER_PASSWORD);
        
        subscribingUser.setEmail(SUBSCRIBING_USER_EMAIL);
        subscribingUser.setName(SUBSCRIBING_USER_NAME);
        subscribingUser.setSurname(SUBSCRIBING_USER_SURNAME);
        subscribingUser.setPassword(USER_PASSWORD);
        
        subscribingUserForAvatar.setEmail(SUBSCRIBING_AVATAR_USER_EMAIL);
        subscribingUserForAvatar.setName(SUBSCRIBING_AVATAR_USER_NAME);
        subscribingUserForAvatar.setSurname(SUBSCRIBING_AVATAR_USER_SURNAME);
        subscribingUserForAvatar.setPassword(USER_PASSWORD);

        updateUser.setEmail(UPDATE_USER_EMAIL);
        updateUser.setName(UPDATE_USER_NAME);
        updateUser.setSurname(UPDATE_USER_NEW_SURNAME);
        updateUser.setPassword(USER_PASSWORD);
    }

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

    @Test
    public void testCreateUser() {
        assertNotNull(userService.create(newUser));
    }

    @Test
    public void testSubscribeUser() {
        assertNotNull(userService.subscribe(subscribingUser, FORGE_APP_AUID, USER_ROLE_RUID,
                LOCAL_AUTHENTICATOR_URL));
    }

    @Test
    public void testSubscribeUserAlreadyExistToNewApp() {
        subscribingUser.setEmail(EXISTING_USER_EMAIL);
        assertNotNull(userService.subscribe(subscribingUser, APP_AUID_WITH_NO_AUTH_FOR_USER, USER_ROLE_RUID,
                LOCAL_AUTHENTICATOR_URL));
    }

    @Test
    public void testSubscribeUserAlreadyExistsWithAuthorization() {
        subscribingUser.setEmail(EXISTING_USER_EMAIL);
        assertNull(userService.subscribe(subscribingUser, FORGE_APP_AUID, ADMIN_ROLE_RUID, LOCAL_AUTHENTICATOR_URL));
    }

    @Test
    public void testUpdateUser() {
        assertEquals(UPDATE_USER_NEW_SURNAME, userService.update(updateUser, UPDATE_USER_ID).getSurname());
    }

    @Test
    public void testUpdateUnexistingUser() {
        assertNull(userService.update(updateUser, UNKNOWN_USER_ID));
    }

    @Test
    public void testUserAvatarUrlStructure() {
        userService.subscribe(subscribingUserForAvatar, FORGE_APP_AUID, ADMIN_ROLE_RUID, LOCAL_AUTHENTICATOR_URL);
        assertEquals(EXPECTED_USER_AVATAR_URL,
                subscribingUserForAvatar.getAvatar());
    }

}
