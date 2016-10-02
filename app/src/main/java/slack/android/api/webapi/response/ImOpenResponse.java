package slack.android.api.webapi.response;

import slack.android.api.models.Channel;

/**
 * Created by flaviokreis on 02/10/16.
 */
public class ImOpenResponse extends BaseResponse {
    private Channel channel;

    public Channel getChannel() {
        return channel;
    }

    public void setChannel(Channel channel) {
        this.channel = channel;
    }
}
