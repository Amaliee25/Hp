package slack.android.api.webapi.response;

import slack.android.api.models.Message;

public class ChatPostResponse extends ChatResponse {
    Message message;

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
