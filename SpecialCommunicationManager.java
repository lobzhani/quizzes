package quiz6;

import com.google.gson.JsonObject;
import java.util.List;
import quiz5.CommunicationManager;

public class SpecialCommunicationManager extends CommunicationManager {
    private String commonServiceUrl;
    private String specialServiceUrl;

    public SpecialCommunicationManager(String commonServiceUrl, String specialServiceUrl) {
        this.commonServiceUrl = commonServiceUrl;
        this.specialServiceUrl = specialServiceUrl;
    }

    @Override
    public JsonObject sendMessage(List<JsonObject> chatHistory, JsonObject currentMessage) {
        String userMessage = currentMessage.get("message").getAsString().toLowerCase();
        String targetUrl = commonServiceUrl;

        if (userMessage.contains("help")) {
            targetUrl = specialServiceUrl;
        } else {
            for (JsonObject message : chatHistory) {
                if (message.get("message").getAsString().toLowerCase().contains("help")) {
                    targetUrl = specialServiceUrl;
                    break;
                }
            }
        }

        // Simulated sending to the target URL
        JsonObject jsonResponse = new JsonObject();
        jsonResponse.addProperty("message", "Response from " + targetUrl);

        return jsonResponse;
    }
}
