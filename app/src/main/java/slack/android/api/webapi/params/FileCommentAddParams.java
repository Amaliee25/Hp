package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api File Comment Add method
 */
public class FileCommentAddParams extends Params {

    /**
     * Channel id (encoded) of which location to associate with the new comment.
     *
     * @param channel
     */
    public void setChannel(String channel){
        put(SlackParamsConstants.CHANNEL, channel);
    }
}

