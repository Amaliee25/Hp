package slack.android.api.webapi.response;

import slack.android.api.models.Channel;

public class ImOpenResponse extends BaseResponse {
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
