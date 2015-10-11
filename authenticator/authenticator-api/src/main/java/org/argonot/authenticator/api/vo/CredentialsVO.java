/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.api.vo;

/**
 * <b>CredentialsVO</b> is a container for authentications infos
 * @author Meidi
 *
 */
public class CredentialsVO {
    /**
     * User entered email
     */
    private String email;

    /**
     * User entered password
     */
    private String password;

    /**
     * Application requesting auth
     */
    private String auid;

    /**
     * User's name
     */
    private String name;

    /**
     * User's surname
     */
    private String surname;
    
    /**
     * User's unique token
     */
    private String tokenId;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAuid() {
        return auid;
    }

    public void setAuid(String auid) {
        this.auid = auid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

}
