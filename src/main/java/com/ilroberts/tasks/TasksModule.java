package com.ilroberts.tasks;

import com.google.inject.AbstractModule;
import com.ilroberts.tasks.controller.TasksController;
import com.ilroberts.tasks.controller.TasksControllerImpl;

public class TasksModule extends AbstractModule {

    @Override
    protected void configure() {

        bind(TasksController.class).toInstance(new TasksControllerImpl());
    }
}
