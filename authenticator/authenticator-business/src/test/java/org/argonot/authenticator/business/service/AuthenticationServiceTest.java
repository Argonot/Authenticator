package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

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
        assertTrue(authenticationService.authenticateUser(WRONG_EMAIL, RIGHT_PASSWORD, RIGHT_APP).isError());
    }

    @Test
    public void testAuthenticateUserFailureForPassword() {
        assertTrue(authenticationService.authenticateUser(RIGHT_EMAIL, WRONG_PASSWORD, RIGHT_APP).isError());
    }

    @Test
    public void testAuthenticateUserFailureForApp() {
        assertTrue(authenticationService.authenticateUser(RIGHT_EMAIL, RIGHT_PASSWORD, WRONG_APP).isError());
    }

    @Test
    public void testAuthenticateExistingUserUnauthorizedFail() {
        assertTrue(
                authenticationService.authenticateUser(EMAIL_USER_UNAUTHORIZED, RIGHT_PASSWORD, RIGHT_APP).isError());
    }

    @Test
    public void testAuthenticateUserWithLockStrategySuccess() {
        assertNotNull(authenticationService.authenticateUserWithLockStrategy(RIGHT_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserWithLockStrategyFailureForEmail() {
        assertTrue(authenticationService.authenticateUserWithLockStrategy(WRONG_EMAIL, RIGHT_PASSWORD, RIGHT_APP)
                .isError());
    }

    @Test
    public void testAuthenticateUserWithLockStrategyFailureForPassword() {
        assertTrue(authenticationService.authenticateUserWithLockStrategy(RIGHT_EMAIL, WRONG_PASSWORD, RIGHT_APP)
                .isError());
    }

    @Test
    public void testAuthenticateUserWithLockStrategyFailureForApp() {
        assertTrue(authenticationService.authenticateUserWithLockStrategy(RIGHT_EMAIL, RIGHT_PASSWORD, WRONG_APP)
                .isError());
    }

    @Test
    public void testAuthenticateLockedUserWithLockStrategyFail() {
        assertTrue(authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_LOCKED, RIGHT_PASSWORD, RIGHT_APP)
                .isError());
    }

    @Test
    public void testTooMuchAuthenticationLockAccount() {
        authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_TO_LOCK, RIGHT_PASSWORD, WRONG_APP);
        authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_TO_LOCK, RIGHT_PASSWORD, WRONG_APP);
        authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_TO_LOCK, RIGHT_PASSWORD, WRONG_APP);
        assertTrue(authenticationService.authenticateUserWithLockStrategy(EMAIL_USER_TO_LOCK, RIGHT_PASSWORD, WRONG_APP)
                .isError());
    }
  
}
