package cloud.nathangood.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * A simple route that picks a message up off the Kafka topic
 * and simply prints it out to the log.
 */
@Component
public class StreamToLogRoute extends RouteBuilder {

    /**
     * Configures the route.
     */
    @Override
    public void configure() throws Exception {
        from("{{kafka-endpoint}}")
            .to("log:fromStream")
            ;
    }
}