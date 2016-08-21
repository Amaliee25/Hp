package slack.android.api.webapi.response;

public class ChatResponse extends BaseResponse {

    private String channel;
    private String ts;

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }
}
