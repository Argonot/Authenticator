package org.argonot.authenticator.api.vo;

public class UserAvatarVO {
    
    private String avatarBase64;
    
    private CredentialsVO credentialsVO;

    /**
     * @return the avatarBase64
     */
    public String getAvatarBase64() {
        return avatarBase64;
    }

    /**
     * @param avatarBase64 the avatarBase64 to set
     */
    public void setAvatarBase64(String avatarBase64) {
        this.avatarBase64 = avatarBase64;
    }

    /**
     * @return the credentialsVO
     */
    public CredentialsVO getCredentialsVO() {
        return credentialsVO;
    }

    /**
     * @param credentialsVO the credentialsVO to set
     */
    public void setCredentialsVO(CredentialsVO credentialsVO) {
        this.credentialsVO = credentialsVO;
    }
    
}
