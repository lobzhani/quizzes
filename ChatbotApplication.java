package quiz5;

public class ChatbotApplication {
    public static void main(String[] args) {
        // Use DummyCommunicationManager for testing
        CommunicationManager communicationManager = new DummyCommunicationManager();
        UserInteractionManager userInteractionManager = new UserInteractionManager(communicationManager);
        userInteractionManager.startChat();
    }
}
