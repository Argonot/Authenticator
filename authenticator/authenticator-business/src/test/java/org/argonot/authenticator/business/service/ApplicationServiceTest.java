package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationServiceTest extends AbstractBusinessSpringContextTest {

    @Autowired
    ApplicationService applicationService;

    @Test
    public void testListApplications() {
        assertTrue(CollectionUtils.isNotEmpty(applicationService.listApplications()));
    }
}
