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
     * User role
     */
    private String ruid;

    /**
     * User's name
     */
    private String name;

    /**
     * User's surname
     */
    private String surname;

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the auid
     */
    public String getAuid() {
        return auid;
    }

    /**
     * @param auid the auid to set
     */
    public void setAuid(String auid) {
        this.auid = auid;
    }

    /**
     * @return the ruid
     */
    public String getRuid() {
        return ruid;
    }

    /**
     * @param ruid the ruid to set
     */
    public void setRuid(String ruid) {
        this.ruid = ruid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * @param surname the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

}
