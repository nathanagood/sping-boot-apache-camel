package cloud.nathangood.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple {@link RouteBuilder} implementation that creates
 * a route for sending a message to an endpoint on a timer.
 */
@Component
public class WriteToQueueRoute extends RouteBuilder {

    /**
     * Configures the route.
     */
    @Override
    public void configure() throws Exception {
        // See the application.properties file for the configuration for
        // both the timer.period and the rabbitmq-endpoint.
        from("timer:hello?period={{timer.period}}").routeId("hello").routeGroup("hello-group")
            .transform().method("transformBean", "transformMessage")
            .to("{{rabbitmq-enpoint}}")
            .to("log:fromTimer")
            ;
    }
}