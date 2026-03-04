package handlers;
import message.Message;

public class GeneralHandler extends FeedbackHandler {

    @Override
    public void handleFeedback(Message feedback) {
        System.out.println("[GeneralHandler] Received feedback of type: " + feedback.getType());

        System.out.println("[GeneralHandler] General feedback: " + feedback.getContent() + "\n");
    }
    
}
