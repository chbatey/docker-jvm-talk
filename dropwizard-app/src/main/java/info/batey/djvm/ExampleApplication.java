package info.batey.djvm;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class ExampleApplication extends Application<Config> {

    public static void main(String[] args) throws Exception {
        new ExampleApplication().run(args);
    }

    @Override
    public void run(Config configuration, Environment environment) throws Exception {
        environment.jersey().register(new Service());
    }
}
