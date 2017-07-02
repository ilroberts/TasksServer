package com.ilroberts.tasks.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Task {

    private final String id;
    private final String title;
    private final Date dueDate;
    private final String description;
    private final Date createdDate;

    public Task(String id, String title, Date dueDate, String description, Date createdDate) {
        this.id = id;
        this.title = title;
        this.dueDate = dueDate;
        this.description = description;
        this.createdDate = createdDate;
    }

    @JsonProperty
    public String getId() {
        return id;
    }

    @JsonProperty
    public String getTitle(){
        return title;
    }

    @JsonProperty
    public Date getDueDate(){
        return dueDate;
    }

    @JsonProperty
    public String getDescription(){
        return description;
    }

    @JsonProperty
    public Date getCreatedDate(){
        return createdDate;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(!(o instanceof Task)) return false;

        Task that = (Task) o;

        if(!getId().equals(that.getId())) return false;
        if(!getTitle().equals(that.getTitle())) return false;

        return true;
    }
}
