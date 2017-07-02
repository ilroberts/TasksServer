package com.ilroberts.tasks.resources;

import com.ilroberts.tasks.api.Task;
import com.ilroberts.tasks.dao.TaskDAO;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    private final TaskDAO taskDAO;

    public TaskResource(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GET
    public List<Task> getTasks() {

        return taskDAO.getAll();
    }

    @POST
    public Task addTask(@Valid Task task) {
        taskDAO.insert(task);

        return task;
    }
}
