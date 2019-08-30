package cloud.nathangood.camel;

/**
 * A simple message processor.
 */
public interface MessageProcessor {
    /**
     * This method accepts a {@see String} and returns a {@see String}, 
     * presumably after some sort of processing.
     * @param message Message as a {@see String}.
     * @return Processed message.
     */
    String transformMessage(String message);
}