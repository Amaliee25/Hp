package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Reaction Add method
 */
public class ReactionAddParams extends Params{

    /**
     * File to add reaction to.
     *
     * @param file
     */
    private void setFile(String file){
        params.put(SlackParamsConstants.FILE, file);
    }

    /**
     * File comment to add reaction to.
     *
     * @param fileComment
     */
    private void setFileComment(String fileComment){
        params.put(SlackParamsConstants.FILE_COMMENT, fileComment);
    }

    /**
     * Channel where the message to add reaction to was posted.
     *
     * @param channel
     */
    private void setChannel(String channel){
        params.put(SlackParamsConstants.CHANNEL, channel);
    }

    /**
     * Timestamp of the message to add reaction to.
     *
     * @param timestamp
     */
    private void setTimestamp(String timestamp){
        params.put(SlackParamsConstants.TIMESTAMP, timestamp);
    }
}
