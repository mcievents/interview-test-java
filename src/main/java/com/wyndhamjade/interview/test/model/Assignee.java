package com.wyndhamjade.interview.test.model;

import java.io.Serializable;
import java.util.Date;

public final class Assignee implements Serializable {
    private Long id;
    private String name;
    private String email;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(final String email) {
        this.email = email;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }
}
