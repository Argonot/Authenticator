/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * <b>User</b> stand for the relevant informations about an Argonot user / member
 * @author Meidi
 *
 */
@Entity
@Table(name = "users")
public class User {

    /**
     * Unique User Identifier
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user", unique = true, nullable = false)
    private long id;

    /**
     * User's name
     */
    @Column(nullable=false)
    private String name;

    /**
     * User's surname
     */
    @Column(nullable=false)
    private String surname;

    /**
     * User birth date
     */
    @Column(nullable=false)
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date birth;

    /**
     * User Argonot email
     */
    @Column(unique = true, nullable=false)
    private String email;

    /**
     * User password
     */
    @Column(nullable=false)
    private String password;

    /**
     * User session Id
     */
    @Transient
    private String sessionId;

    /**
     * Users authorizations
     */
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private Set<Authorization> authorizations;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

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

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Set<Authorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(Set<Authorization> authorizations) {
        this.authorizations = authorizations;
    }

}
