package slack.android.api.webapi.response;

import java.util.List;

import slack.android.api.models.Message;

public class ChannelHistoryResponse extends BaseResponse {
    private String latest;
    private List<Message> messages;
    private boolean hasMore;

    public String getLatest() {
        return latest;
    }

    public void setLatest(String latest) {
        this.latest = latest;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public boolean isHasMore() {
        return hasMore;
    }

    public void setHasMore(boolean hasMore) {
        this.hasMore = hasMore;
    }
}
