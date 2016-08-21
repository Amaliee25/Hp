package slack.android.api.webapi.response;

import slack.android.api.models.Channel;

import java.util.List;

public class ChannelListResponse extends BaseResponse {
    private List<Channel> channels;

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }
}
