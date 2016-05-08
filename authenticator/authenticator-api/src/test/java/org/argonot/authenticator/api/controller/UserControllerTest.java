package org.argonot.authenticator.api.controller;

import org.argonot.authenticator.api.utils.AbstractControllerTest;
import org.argonot.authenticator.api.vo.CredentialsVO;
import org.junit.Before;
import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class UserControllerTest extends AbstractControllerTest {
    
    private static final String SUBSCRIBER_EMAIL = "subscriber@gmail.com";
    private static final String SUBSCRIBER_NAME = "subscriberName";
    private static final String SUBSCRIBER_SURNAME = "subscriberSurname";
    private static final String USER_PASSWORD = "Test1.";
    private static final String AUID = "FRG";
    private static final String RUID = "USR";
    private static final String UPDATER_EMAIL = "updater@gmail.com";
    private static final String UPDATER_NAME = "updaterName";
    private static final String UPDATER_SURNAME = "updaterSurname";
    private static final String SUBSCRIBE_ROUTE = "/users/subscribe";
    private static final String UPDATE_ROUTE = "/users/update/8";
    private static final String UPDATE_AVATAR_ROUTE = "/users/avatar/upload";

    private static final ObjectMapper jsonMapper = new ObjectMapper();
    private static final CredentialsVO subscriberCredentials = new CredentialsVO();
    private static final CredentialsVO updaterCredentials = new CredentialsVO();
    private static final String USER_EMAIL = "meidi.airouche@gmail.com";
    private static final String APP_ID = "FRG";
    private static final String HTTP_POST_METHOD = "POST";
    private static final String AUTHENTICATION_ROUTE = "/users/authenticate";
    private static final String SECURE_AUTHENTICATION_ROUTE = "/users/authenticate/strong";

    private static final CredentialsVO credentials = new CredentialsVO();
    
    @Before
    public void setUpTests() {
        credentials.setAuid(APP_ID);
        credentials.setEmail(USER_EMAIL);
        credentials.setPassword(USER_PASSWORD);

        subscriberCredentials.setAuid(AUID);
        subscriberCredentials.setRuid(RUID);
        subscriberCredentials.setEmail(SUBSCRIBER_EMAIL);
        subscriberCredentials.setPassword(USER_PASSWORD);
        subscriberCredentials.setName(SUBSCRIBER_NAME);
        subscriberCredentials.setSurname(SUBSCRIBER_SURNAME);

        updaterCredentials.setAuid(AUID);
        updaterCredentials.setRuid(RUID);
        updaterCredentials.setEmail(UPDATER_EMAIL);
        updaterCredentials.setPassword(USER_PASSWORD);
        updaterCredentials.setName(UPDATER_NAME);
        updaterCredentials.setSurname(UPDATER_SURNAME);
    }

    @Test
    public void testAuthenticateUser() throws Exception {
        this.request.setContent(jsonMapper.writeValueAsBytes(credentials));
        this.testJsonObjectRoute(AUTHENTICATION_ROUTE, HTTP_POST_METHOD);
    }

    @Test
    public void testSecureAuthenticateUser() throws Exception {
        this.request.setContent(jsonMapper.writeValueAsBytes(credentials));
        this.testJsonObjectRoute(SECURE_AUTHENTICATION_ROUTE, HTTP_POST_METHOD);
    }

    @Test
    public void testSubscribeUser() throws Exception{
        this.request.setContent(jsonMapper.writeValueAsBytes(subscriberCredentials));
        this.testJsonObjectRoute(SUBSCRIBE_ROUTE, HTTP_POST_METHOD);
    }

    @Test
    public void testUpdateUser() throws Exception {
        this.request.setContent(jsonMapper.writeValueAsBytes(updaterCredentials));
        this.testJsonObjectRoute(UPDATE_ROUTE, HTTP_POST_METHOD);
    }
    
    @Test
    public void testUpdateUserAvatar() throws Exception {
        this.request.setContent(jsonMapper.writeValueAsBytes(""));
        this.request.setContent(jsonMapper.writeValueAsBytes(updaterCredentials));
        this.testJsonObjectRoute(UPDATE_AVATAR_ROUTE, HTTP_POST_METHOD);
    }

}
