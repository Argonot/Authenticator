package org.argonot.authenticator.business.dto;

/**
 * User Data Transfer Object
 * 
 * @author Meidi
 *
 */
public class UserDTO {

    /**
     * User unique id
     */
    private long id;

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
     * User's avatar
     */
    private String avatar;

    /**
     * An error occured : impossible to get the user
     */
    private boolean error = false;

    /**
     * The error message
     */
    private String message;

    /**
     * Explicit error constructor
     * 
     * @param error
     * @param message
     */
    public UserDTO(boolean error, String message) {
        this.error = error;
        this.message = message;
    }

    /**
     * Default constructor
     */
    public UserDTO() {
    }

    /**
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            the email to set
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
     * @param password
     *            the password to set
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
     * @param auid
     *            the auid to set
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
     * @param ruid
     *            the ruid to set
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
     * @param name
     *            the name to set
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
     * @param surname
     *            the surname to set
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * @return the avatar
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * @param avatar
     *            the avatar to set
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the error
     */
    public boolean isError() {
        return error;
    }

    /**
     * @param error
     *            the error to set
     */
    public void setError(boolean error) {
        this.error = error;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }
}
