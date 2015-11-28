package org.argonot.authenticator.business.repository;

import static org.junit.Assert.*;

import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRepositoryTest extends AbstractBusinessSpringContextTest {
    
    private static final int USER_ID = 1;
    private static final String USER_MAIL = "meidi.airouche@gmail.com";
    
    @Autowired
    UserRepository userRepository;

    @Test
    public void testFindUserByEmail() {
        assertTrue(userRepository.findByEmail(USER_MAIL).getId() == USER_ID);
    }

}
