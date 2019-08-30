package cloud.nathangood.camel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * A component that is used to transform (process) messages.
 */
@Component("transformBean")
public class TransformBean {

    @Value("${greeting}")
    private String say;

    @Autowired(required = false)
    private List<MessageProcessor> processors;

    /**
     * Transforms the message by applying all of the processors that
     * have been configured ({@see #processors}). 
     * 
     * @param body The incoming message
     * @return The processed result
     */
    public String transformMessage(String body) {
        String result = say;

        // This is an EXTREMELY rudimentary example of how processors
        // or filters might be chained together to transform a message.
        // For performance, you could check some variables and then 
        // bail out if the message is not what you expect to prevent
        // unnecessary processing. The optimal solution, however, might
        // be to use some business rules.
        for (MessageProcessor processor : processors) {
            result = processor.transformMessage(result);
        }

        return result; 
    }

}