package quiz5;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInteractionManager {
    private CommunicationManager communicationManager;
    private List<JsonObject> chatHistory;
    private Gson gson;

    public UserInteractionManager(CommunicationManager communicationManager) {
        this.communicationManager = communicationManager;
        this.chatHistory = new ArrayList<>();
        this.gson = new Gson();
    }

    public void startChat() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Chatbot started. Type your message:");

        while (true) {
            String userMessage = scanner.nextLine();
            if (userMessage.equalsIgnoreCase("exit")) {
                break;
            }

            JsonObject currentMessage = new JsonObject();
            currentMessage.addProperty("role", "user");
            currentMessage.addProperty("message", userMessage);

            JsonObject response = communicationManager.sendMessage(chatHistory, currentMessage);

            if (response != null) {
                String chatbotMessage = response.get("message").getAsString();
                System.out.println("Chatbot: " + chatbotMessage);

                chatHistory.add(currentMessage);

                JsonObject botResponse = new JsonObject();
                botResponse.addProperty("role", "chatbot");
                botResponse.addProperty("message", chatbotMessage);
                chatHistory.add(botResponse);
            }
        }

        scanner.close();
    }
}
