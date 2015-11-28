package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.argonot.authenticator.business.service.AuthenticationService;
import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticatorServiceTest extends AbstractBusinessSpringContextTest {

    private static final String RIGHT_EMAIL = "meidi.airouche@gmail.com";
    private static final String RIGHT_PASSWORD = "Test1.";
    private static final String WRONG_EMAIL = "wrongtest@argonot.org";
    private static final String WRONG_PASSWORD = "WrongTest1.";
    private static final String RIGHT_APP = "FRG";
    private static final String WRONG_APP = "ARS";

    @Autowired
    AuthenticationService authentificationService;

    @Test
    public void testAuthenticateUserSuccess() {
        assertNotNull(authentificationService.authenticateUser(RIGHT_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserFailureForEmail() {
        assertNull(authentificationService.authenticateUser(WRONG_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserFailureForPassword() {
        assertNull(authentificationService.authenticateUser(RIGHT_EMAIL, WRONG_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserFailureForApp() {
        assertNull(authentificationService.authenticateUser(RIGHT_EMAIL, RIGHT_PASSWORD, WRONG_APP));
    }
    
    @Test
    public void testAuthenticateUserWithLockStrategySuccess() {
        assertNotNull(authentificationService.authenticateUserWithLockStrategy(RIGHT_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserWithLockStrategyFailureForEmail() {
        assertNull(authentificationService.authenticateUserWithLockStrategy(WRONG_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserWithLockStrategyFailureForPassword() {
        assertNull(authentificationService.authenticateUserWithLockStrategy(RIGHT_EMAIL, WRONG_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthenticateUserWithLockStrategyFailureForApp() {
        assertNull(authentificationService.authenticateUserWithLockStrategy(RIGHT_EMAIL, RIGHT_PASSWORD, WRONG_APP));
    }

}
