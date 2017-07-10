package com.ilroberts.tasks.api;

import java.util.ArrayList;
import java.util.List;


public class APIResponse {

    private List<Task> tasks;

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public APIResponse() {

        this.tasks = new ArrayList<>();
    }

    public APIResponse(List<Task> tasks) {
        this.tasks = tasks;
    }
}
