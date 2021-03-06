package com.marcioos.garagesale;

import com.marcioos.garagesale.core.helper.ItemsByCategoryHelper;
import com.marcioos.garagesale.dao.ItemDAO;
import com.marcioos.garagesale.resources.ItemResource;
import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;
import org.skife.jdbi.v2.DBI;

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
        bootstrap.addBundle(new MigrationsBundle<GarageSaleConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(GarageSaleConfiguration garageSaleConfiguration) {
                return garageSaleConfiguration.getDatabase();
            }
        });
        bootstrap.addBundle(new ViewBundle<>());
        bootstrap.addBundle(new AssetsBundle());
    }

    @Override
    public void run(GarageSaleConfiguration garageSaleConfiguration,
                    Environment environment) throws Exception {
        final DBI jdbi = createDBI(garageSaleConfiguration, environment);
        final ItemDAO itemDAO = jdbi.onDemand(ItemDAO.class);
        final ItemResource resource = new ItemResource(itemDAO, new ItemsByCategoryHelper());
        environment.jersey().register(resource);
    }

    private DBI createDBI(GarageSaleConfiguration garageSaleConfiguration, Environment environment) {
        final DBIFactory factory = new DBIFactory();
        return factory.build(environment, garageSaleConfiguration.getDatabase(), "h2");
    }
}
