package com.ilroberts.tasks;

import com.hubspot.dropwizard.guice.GuiceBundle;
import com.ilroberts.tasks.api.Task;
import com.ilroberts.tasks.dao.TaskDAO;
import com.ilroberts.tasks.resources.TaskResource;
import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.skife.jdbi.v2.DBI;

import java.util.List;

public class TasksApplication extends Application<TasksConfiguration> {


    private GuiceBundle<TasksConfiguration> guiceBundle;

    public static void main(String[] args) throws Exception {
        new TasksApplication().run(args);
    }

    @Override
    public String getName() {
        return "tasks";
    }

    @Override
    public void initialize(Bootstrap<TasksConfiguration> bootstrap) {

        guiceBundle = GuiceBundle.<TasksConfiguration>newBuilder()
                .addModule(new TasksModule())
                .setConfigClass(TasksConfiguration.class)
                .build();

        bootstrap.addBundle(guiceBundle);

        bootstrap.addBundle(new SwaggerBundle<TasksConfiguration>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(TasksConfiguration configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
    }

    @Override
    public void run(TasksConfiguration configuration,
                    Environment environment) {

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        final TaskDAO dao = jdbi.onDemand(TaskDAO.class);

        environment.jersey().register(new TaskResource(dao));
    }

}
