package com.ilroberts.tasks;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class TasksApplication extends Application<TasksConfiguration> {


    public static void main(String[] args) throws Exception {
        new TasksApplication().run(args);
    }

    @Override
    public String getName() {
        return "tasks";
    }

    @Override
    public void initialize(Bootstrap<TasksConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(TasksConfiguration configuration,
                    Environment environment) {
        // nothing to do yet
    }

}
