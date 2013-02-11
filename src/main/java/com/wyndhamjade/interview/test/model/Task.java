package com.wyndhamjade.interview.test.model;

import java.io.Serializable;
import java.util.Date;

public final class Task implements Serializable {
    private Long id;
    private String description;
    private Assignee assignee;
    private Date due;
    private Date completedAt;
    private Date createdAt;

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(final Assignee assignee) {
        this.assignee = assignee;
    }

    public Date getDue() {
        return due;
    }

    public void setDue(final Date due) {
        this.due = due;
    }

    public Date getCompletedAt() {
        return completedAt;
    }

    public void setCompletedAt(final Date completedAt) {
        this.completedAt = completedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }
}
