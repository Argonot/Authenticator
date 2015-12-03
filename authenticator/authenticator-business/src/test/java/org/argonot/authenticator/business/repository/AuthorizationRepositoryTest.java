package org.argonot.authenticator.business.repository;

import static org.junit.Assert.*;

import org.argonot.authenticator.business.entity.Application;
import org.argonot.authenticator.business.entity.User;
import org.argonot.authenticator.business.repository.AuthorizationRepository;
import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AuthorizationRepositoryTest extends AbstractBusinessSpringContextTest {
    
    private static final String APP_ID = "FRG";
    private static final long USER_ID = 1L;
    private static final User user = new User();
    private static final Application app = new Application();
    
    @Autowired
    AuthorizationRepository authorizationRepository;
    
    @BeforeClass
    public static void setUpTests() {
        user.setId(USER_ID);
        app.setId(APP_ID);
    }

    @Test
    public void testFindByUserAndApp() {
        assertNotNull(authorizationRepository.findByUserAndApp(user, app));
    }

}
