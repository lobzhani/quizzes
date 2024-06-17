package quiz5;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.List;

public class CommunicationManager {
    public JsonObject sendMessage(List<JsonObject> chatHistory, JsonObject currentMessage) {
        JsonObject requestBody = new JsonObject();
        JsonArray historyArray = new JsonArray();
        for (JsonObject message : chatHistory) {
            historyArray.add(message);
        }
        requestBody.add("chatHistory", historyArray);
        requestBody.add("currentMessage", currentMessage);

        // Here you would implement the real HTTP POST request to the remote service.
        // For demonstration, we use a dummy response.
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("message", "This is a dummy response");

        return jsonResponse;
    }
}
