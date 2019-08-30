package cloud.nathangood.camel;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

/**
 * This configuration is demonstrating how processing beans could 
 * be initialized in one configuration.
 */
@Configuration
public class ProcessorConfig {

    /**
     * Creates a simple processor that forces the string to 
     * uppercase.
     */
    @Bean
    // The order here tells Spring in what order to add the bean
    // to the collection.
    @Order(1)
    public MessageProcessor upperCaseProcessor() {
        // This code here is taking advantage of a language feature
        // introduced in Java 8, which means that I can just write
        // a quick Lambda function to do the work. If this needs to
        // be an interface with many methods on it or if you feel 
        // otherwise that it would  be more testable using actual
        // objects, that can be done as well.
        return (m -> m.toUpperCase());
    }

    /**
     * Creates a simple processor that reverses the string.
     * @return
     */
    @Order(2)
    @Bean 
    public MessageProcessor reverseStringProcessor() {
        return (m -> new StringBuilder(m).reverse().toString());
    }

    /**
     * Creates a simple processor that makes every other word 
     * the word "moo".
     * @return
     */
    @Order(3)
    @Bean
    public MessageProcessor makeEverySecondWordMooProcessor() {
        // A little more coding in the lambda expression...
        return (m -> {
            String[] words = m.split(" ");
            List<String> processedWords = new ArrayList<>();
            
            for (int i = 0; i < words.length; i++) {
                processedWords.add(i % 2 != 0 ? "moo" : words[i]);
            }
            
            return String.join(" ", processedWords);
        });
    }

}