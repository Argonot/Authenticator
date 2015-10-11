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
    private static final String SESSION_ID = "sessionId";

    @Autowired
    AuthenticationService authentificationService;

    @Test
    public void testAuthentificationSuccess() {
        assertNotNull(authentificationService.authentificateUser(RIGHT_EMAIL, RIGHT_PASSWORD, RIGHT_APP, SESSION_ID));
    }

    @Test
    public void testAuthentificationFailureForEmail() {
        assertNull(authentificationService.authentificateUser(WRONG_EMAIL, RIGHT_PASSWORD, RIGHT_APP, SESSION_ID));
    }

    @Test
    public void testAuthentificationFailureForPassword() {
        assertNull(authentificationService.authentificateUser(RIGHT_EMAIL, WRONG_PASSWORD, RIGHT_APP, SESSION_ID));
    }

    @Test
    public void testAuthentificationFailureForApp() {
        assertNull(authentificationService.authentificateUser(RIGHT_EMAIL, RIGHT_PASSWORD, WRONG_APP, SESSION_ID));
    }

}
