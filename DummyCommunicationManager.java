package quiz5;

import com.google.gson.JsonObject;

import java.util.List;

public class DummyCommunicationManager extends CommunicationManager {
    @Override
    public JsonObject sendMessage(List<JsonObject> chatHistory, JsonObject currentMessage) {
        // Simulated responses for testing purposes
        JsonObject jsonResponse = new JsonObject();
        String userMessage = currentMessage.get("message").getAsString().toLowerCase();

        switch (userMessage) {
            case "hello":
                jsonResponse.addProperty("message", "Good day");
                break;
            case "what time is it?":
                jsonResponse.addProperty("message", "9:00 AM");
                break;
            case "i should go!":
                jsonResponse.addProperty("message", "Wait for me!");
                break;
            default:
                jsonResponse.addProperty("message", "I don't understand.");
                break;
        }

        return jsonResponse;
    }
}
