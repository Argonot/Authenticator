package org.argonot.authenticator.api.controller;

import org.argonot.authenticator.api.vo.CredentialsVO;
import org.argonot.authenticator.utils.AbstractControllerTest;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AuthenticatorControllerTest extends AbstractControllerTest {
    
    private static final String HTTP_POST_METHOD = "POST";
    private static final String AUTHENTICATION_ROUTE = "/authenticator/authenticate/user";
    private static final ObjectMapper jsonMapper = new ObjectMapper();
    
    private static final CredentialsVO credentials = new CredentialsVO();
    
    @BeforeClass
    public static void setUpTest() {
        credentials.setAuid("FRG");
        credentials.setEmail("meidi.airouche@gmail.com");
        credentials.setPassword("Test1.");
    }

    @Test
    public void testAuthenticateUser() throws Exception {
        this.request.setContent(jsonMapper.writeValueAsBytes(credentials));
        this.testJsonObjectRoute(AUTHENTICATION_ROUTE, HTTP_POST_METHOD);
    }
}
