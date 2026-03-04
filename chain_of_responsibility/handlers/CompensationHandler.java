package handlers;
import java.util.Scanner;
import message.Message;

public class CompensationHandler extends  FeedbackHandler {
    Scanner scanner = new Scanner(System.in);
    
    @Override
    public void handleFeedback(Message feedback) {
        System.out.println("[CompensationHandler] Received feedback of type: " + feedback.getType());

        if (feedback.getType() == message.MessageType.COMPENSATION) {
            System.out.println("[CompensationHandler] Received compensation request. Please approve or reject the request.");
            System.out.println("[CompensationHandler] Compensation request details: \"" + feedback.getContent() + "\"");
            System.out.println("1. Approve\n2. Reject");
            System.out.print("Enter your choice: ");
            switch (scanner.nextInt()) {
                case 1 -> System.out.println("[CompensationHandler] Compensation request approved.\n");
                case 2 -> System.out.println("[CompensationHandler] Compensation request rejected.\n");
                default -> throw new AssertionError();
            }
        } else if (nextHandler != null) {
            System.out.println("[CompensationHandler] Passing feedback to the next handler.\n");
            nextHandler.handleFeedback(feedback);
        }
    }
    
}
