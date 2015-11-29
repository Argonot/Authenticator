/* This software is the exclusive property of Argonot.
 * © Argonot.fr 2015 - All rights reserved */

package org.argonot.authenticator.business.api.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


/**
 * <b>Application</b> stand for the relevant informations about any Argonot application
 * @author Meidi
 *
 */
@Entity
@Table(name = "applications")
public class Application {

    /**
     * Max length for String ID
     */
    private static final int STRING_ID_MAX_LENGTH = 3;

    /**
     * Application Unique Identifier
     */
    @Id
    @Column(name = "AUID", unique = true, nullable = false, length=STRING_ID_MAX_LENGTH)
    private String id;

    /**
     * The name of the group
     */
    @Column(nullable=false)
    private String name;

    /**
     * Applications concerned by authorizations
     */
    @OneToMany(mappedBy = "app", fetch = FetchType.EAGER)
    private Set<Authorization> authorizations;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Authorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(Set<Authorization> authorizations) {
        this.authorizations = authorizations;
    }

}
