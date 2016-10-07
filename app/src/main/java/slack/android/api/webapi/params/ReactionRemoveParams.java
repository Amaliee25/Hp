package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Reaction Remove method
 */
public class ReactionRemoveParams extends Params{

    /**
     * File to remove reaction from.
     *
     * @param file
     */
    private void setFile(String file){
        params.put(SlackParamsConstants.FILE, file);
    }

    /**
     * File comment to remove reaction from.
     *
     * @param fileComment
     */
    private void setFileComment(String fileComment){
        params.put(SlackParamsConstants.FILE_COMMENT, fileComment);
    }

    /**
     * Channel where the message to remove reaction from was posted.
     *
     * @param channel
     */
    private void setChannel(String channel){
        params.put(SlackParamsConstants.CHANNEL, channel);
    }

    /**
     * Timestamp of the message to remove reaction from.
     *
     * @param timestamp
     */
    private void setTimestamp(String timestamp){
        params.put(SlackParamsConstants.TIMESTAMP, timestamp);
    }
}
