package com.ilroberts.tasks.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Task {

    @JsonProperty
    private String id = "";

    @JsonProperty
    private String title = "";

    @JsonProperty
    private Date dueDate = null;

    @JsonProperty
    private String description ="";

    @JsonProperty
    private Date createdDate = null;

    public Task() {

    }

    public Task(String id, String title, Date dueDate, String description, Date createdDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.createdDate = createdDate;
        this.dueDate = dueDate;
    }

    public String getId() {
        return id;
    }

    public String getTitle(){
        return title;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public String getDescription(){
        return description;
    }

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
