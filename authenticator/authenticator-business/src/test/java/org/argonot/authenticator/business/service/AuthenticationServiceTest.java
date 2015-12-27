package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticationServiceTest extends AbstractBusinessSpringContextTest {

    private static final String RIGHT_EMAIL = "meidi.airouche@gmail.com";
    private static final String EMAIL_USER_LOCKED = "lockedUser@gmail.com";
    private static final String EMAIL_USER_UNAUTHORIZED = "userunauthorized@gmail.com";
    private static final String EMAIL_USER_TO_LOCK = "willbelocked@gmail.com";
    private static final String RIGHT_PASSWORD = "Test1.";
    private static final String WRONG_EMAIL = "wrongtest@argonot.org";
    private static final String WRONG_PASSWORD = "WrongTest1.";
    private static final String RIGHT_APP = "FRG";
    private static final String WRONG_APP = "ARS";

    @Autowired
    AuthenticationService authenticationService;

    @Test
    public void testAuthenticateUserSuccess() {
        assertNotNull(authenticationService.authenticateUser(RIGHT_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserFailureForEmail() {
        assertNull(authenticationService.authenticateUser(WRONG_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserFailureForPassword() {
        assertNull(authenticationService.authenticateUser(RIGHT_EMAIL, WRONG_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserFailureForApp() {
        assertNull(authenticationService.authenticateUser(RIGHT_EMAIL, RIGHT_PASSWORD, WRONG_APP));
    }

    @Test
    public void testAuthenticateExistingUserUnauthorizedFail() {
        assertNull(authenticationService.authenticateUser(EMAIL_USER_UNAUTHORIZED, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserWithLockStrategySuccess() {
        assertNotNull(authenticationService.authenticateUserWithLockStrategy(RIGHT_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserWithLockStrategyFailureForEmail() {
        assertNull(authenticationService.authenticateUserWithLockStrategy(WRONG_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserWithLockStrategyFailureForPassword() {
        assertNull(authenticationService.authenticateUserWithLockStrategy(RIGHT_EMAIL, WRONG_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserWithLockStrategyFailureForApp() {
        assertNull(authenticationService.authenticateUserWithLockStrategy(RIGHT_EMAIL, RIGHT_PASSWORD, WRONG_APP));
    }

    @Test
    public void testAuthenticateLockedUserWithLockStrategyFail() {
        assertNull(authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_LOCKED, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testTooMuchAuthenticationLockAccount() {
        authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_TO_LOCK, RIGHT_PASSWORD, WRONG_APP);
        authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_TO_LOCK, RIGHT_PASSWORD, WRONG_APP);
        authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_TO_LOCK, RIGHT_PASSWORD, WRONG_APP);
        assertNull(authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_TO_LOCK, RIGHT_PASSWORD, WRONG_APP));
    }
  
}
