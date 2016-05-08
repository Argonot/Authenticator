package org.argonot.authenticator.api.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Access to the environment variables
 * @author Meidi
 *
 */
@Component
public class EnvironmentVariables {

    @Value("${avatar.upload.folder}")
    private String avatarUploadFolder;
    
    @Value("${avatar.upload.url}")
    private String avatarUploadUrl;

    /**
     * @return the avatarUploadFolder
     */
    public String getAvatarUploadFolder() {
        return avatarUploadFolder;
    }

    /**
     * @return the avatarUploadUrl
     */
    public String getAvatarUploadUrl() {
        return avatarUploadUrl;
    }
    
}
