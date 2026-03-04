
import handlers.*;
import message.*;

public class Main {
    public static void main(String[] args) {

        // Create handlers
        FeedbackHandler compensationHandler = new CompensationHandler();
        FeedbackHandler suggestionHandler = new SuggestionHandler();
        FeedbackHandler generalHandler = new GeneralHandler();

        // Set up the chain of responsibility
        compensationHandler.setNextHandler(suggestionHandler);
        suggestionHandler.setNextHandler(generalHandler);

        System.out.println("\n--- Feedback System ---\n");

        Message feedback1 = new Message(MessageType.COMPENSATION, "I want a refund for my purchase.");
        compensationHandler.handleFeedback(feedback1);

        Message feedback2 = new Message(MessageType.SUGGESTION, "It would be great if you could add more payment options.");
        compensationHandler.handleFeedback(feedback2);

        Message feedback3 = new Message(MessageType.GENERAL, "I just wanted to say thank you for the great service!");
        compensationHandler.handleFeedback(feedback3);
    }
}
