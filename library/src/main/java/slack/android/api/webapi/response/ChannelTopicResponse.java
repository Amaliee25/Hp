package slack.android.api.webapi.response;

public class ChannelTopicResponse extends BaseResponse {
    private String topic;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
