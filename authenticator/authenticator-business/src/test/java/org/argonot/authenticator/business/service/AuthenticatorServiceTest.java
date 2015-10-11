package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.argonot.authenticator.business.service.AuthenticationService;
import org.argonot.authenticator.business.util.AbstractRepositoryTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthenticatorServiceTest extends AbstractRepositoryTest {

    private static final String RIGHT_EMAIL = "meidi.airouche@gmail.com";
    private static final String RIGHT_PASSWORD = "Test1.";
    private static final String WRONG_EMAIL = "wrongtest@argonot.org";
    private static final String WRONG_PASSWORD = "WrongTest1.";
    private static final String RIGHT_APP = "FRG";
    private static final String WRONG_APP = "ARS";

    @Autowired
    AuthenticationService authentificationService;

    @Test
    public void testAuthentificationSuccess() {
        assertNotNull(authentificationService.authenticateUser(RIGHT_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthentificationFailureForEmail() {
        assertNull(authentificationService.authenticateUser(WRONG_EMAIL, RIGHT_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthentificationFailureForPassword() {
        assertNull(authentificationService.authenticateUser(RIGHT_EMAIL, WRONG_PASSWORD, RIGHT_APP));
    }

    @Test
    public void testAuthentificationFailureForApp() {
        assertNull(authentificationService.authenticateUser(RIGHT_EMAIL, RIGHT_PASSWORD, WRONG_APP));
    }

}
