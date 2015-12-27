package org.argonot.authenticator.business.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.argonot.authenticator.business.entity.Application;
import org.argonot.authenticator.business.util.AbstractBusinessSpringContextTest;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationServiceTest extends AbstractBusinessSpringContextTest {
    
    private static final String APP_ID = "TST";
    private static final String APP_NAME = "TEST";
    private static final String EXISTING_APP_ID = "FRG";
    private static final String UPDATE_APP_ID = "UPD";
    private static final String UPDATE_APP_NAME = "UPDATE";
    private static final String APPLICATION_TO_REMOVE_ID = "RMV";
    
    private static final Application app = new Application();
    private static final Application existingApp = new Application();
    private static final Application updateApp = new Application();
    
    @Autowired
    ApplicationService applicationService;
    
    @BeforeClass
    public static void setUp() {
        app.setId(APP_ID);
        app.setName(APP_NAME);
        existingApp.setId(EXISTING_APP_ID);
        existingApp.setName(APP_NAME);
        updateApp.setId(UPDATE_APP_ID);
        updateApp.setName(UPDATE_APP_NAME);
    }

    @Test
    public void testListApplications() {
        assertTrue(CollectionUtils.isNotEmpty(applicationService.listApplications()));
    }
    
    @Test
    public void testCreateApplication() {
        assertNotNull(applicationService.create(app));
    }
    
    @Test
    public void testCreateExistingApplication() {
        assertNull(applicationService.create(existingApp));
    }
    
    @Test
    public void testUpdateApplication() {
        assertNotNull(applicationService.update(updateApp));
    }
    
    @Test
    public void testRemoveApplication() {
        applicationService.removeApplication(APPLICATION_TO_REMOVE_ID);
        assertNull(applicationService.find(APPLICATION_TO_REMOVE_ID));
    }
}
