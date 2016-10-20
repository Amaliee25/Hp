package slack.android.api.webapi.response;

public class ChatUpdateResponse extends ChatResponse {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
