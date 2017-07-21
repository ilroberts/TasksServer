package com.ilroberts.tasks.resources;

import com.ilroberts.tasks.api.APIResponse;
import com.ilroberts.tasks.api.Task;
import com.ilroberts.tasks.dao.TaskDAO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/tasks")
@Api("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaskResource {

    private final TaskDAO taskDAO;

    public TaskResource(TaskDAO taskDAO) {
        this.taskDAO = taskDAO;
    }

    @GET
    @ApiOperation("retrieve all tasks")
    public APIResponse getTasks() {

        return new APIResponse(taskDAO.getAll());
    }

    @GET
    @Path("/{id}")
    public Task getTask(@PathParam("id") String id) {
        return taskDAO.findById(id);
    }

    @POST
    public Task addTask(@Valid Task task) {
        taskDAO.insert(task);
        return task;
    }

    @PUT
    @Path("/{id}")
    public Task update(@PathParam("id") String id, @Valid Task task) {
        Task updateTask = new Task(id, task.getTitle(), task.getDueDate(),task.getDescription(), task.getCreatedDate());
        taskDAO.update(updateTask);

        return updateTask;
    }

    @DELETE
    @Path("/{id}")
    public void delete(@PathParam("id") String id) {
        taskDAO.deleteById(id);
    }
}
