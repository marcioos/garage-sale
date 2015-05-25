package com.marcioos.garagesale;

import com.marcioos.garagesale.health.TemplateHealthCheck;
import com.marcioos.garagesale.resources.GarageSaleResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class GarageSaleApplication extends Application<GarageSaleConfiguration> {

    public static void main(String[] args) throws Exception {
        new GarageSaleApplication().run(args);
    }

    @Override
    public String getName() {
        return "garage-sale";
    }

    @Override
    public void initialize(Bootstrap<GarageSaleConfiguration> bootstrap) {
        super.initialize(bootstrap);
    }

    @Override
    public void run(GarageSaleConfiguration garageSaleConfiguration,
                    Environment environment) throws Exception {
        final GarageSaleResource resource = new GarageSaleResource(
                garageSaleConfiguration.getTemplate(), garageSaleConfiguration.getDefaultName());
        final TemplateHealthCheck healthCheck = new TemplateHealthCheck(garageSaleConfiguration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
    }
}
