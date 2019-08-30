package cloud.nathangood.camel;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

/**
 * 
 */
@Component
public class QueueToStreamRoute extends RouteBuilder {

    /**
     * 
     */
    @Override
    public void configure() throws Exception {
        from("{{rabbitmq-enpoint}}")
            // If you'd like to see yet another way to transform
            // the message inline, uncomment out this next line...
            // .transform(body().append(" (transformed)"))
            .to("{{kafka-enpoint}}")
            ;
    }
}