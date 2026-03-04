package handlers;
import java.util.ArrayList;
import java.util.List;
import message.Message;

public class SuggestionHandler  extends  FeedbackHandler {
    private final List<String> suggestions = new ArrayList<>();
    
    @Override
    public void handleFeedback(Message feedback) {
        System.out.println("[SuggestionHandler] Received feedback of type: " + feedback.getType());

        if (feedback.getType() == message.MessageType.SUGGESTION) {
            System.out.println("[SuggestionHandler] Adding suggestion to the list.");
            suggestions.add(feedback.getContent());
            System.out.println("[SuggestionHandler] Current suggestions: " + suggestions + "\n");
        } else if (nextHandler != null) {
            System.out.println("[SuggestionHandler] Passing feedback to the next handler.\n");
            nextHandler.handleFeedback(feedback);
        }
    }
    
}
