package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Reaction Get method
 */
public class ReactionGetParams extends Params {

    /**
     * File to get reactions for.
     *
     * @param file
     */
    private void setFile(String file){
        params.put(SlackParamsConstants.FILE, file);
    }

    /**
     * File comment to get reactions for.
     *
     * @param fileComment
     */
    private void setFileComment(String fileComment){
        params.put(SlackParamsConstants.FILE_COMMENT, fileComment);
    }

    /**
     * Channel where the message to get reactions for was posted.
     *
     * @param channel
     */
    private void setChannel(String channel){
        params.put(SlackParamsConstants.CHANNEL, channel);
    }

    /**
     * Timestamp of the message to get reactions for.
     *
     * @param timestamp
     */
    private void setTimestamp(String timestamp){
        params.put(SlackParamsConstants.TIMESTAMP, timestamp);
    }

    /**
     * If true always return the complete reaction list.
     * @param isFull
     */
    private void setIsFull(boolean isFull){
        params.put(SlackParamsConstants.IS_FULL, isFull ? "1" : "0");
    }
}
