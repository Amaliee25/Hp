package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Star Remove method
 */
public class StarRemoveParams extends Params {

    /**
     * File to remove star from.
     *
     * @param fileId e.g. F1234567890
     */
    public void setFile(String fileId){
        put(SlackParamsConstants.FILE, fileId);
    }

    /**
     * File comment to remove star from.
     *
     * @param commentId e.g. Fc1234567890
     */
    public void setFileComment(String commentId){
        put(SlackParamsConstants.FILE_COMMENT, commentId);
    }

    /**
     * Channel to remove star from, or channel where the message to remove star from was posted
     * (used with timestamp).
     *
     * @param channelId e.g. C1234567890
     */
    public void setChannel(String channelId){
        put(SlackParamsConstants.CHANNEL, channelId);
    }

    /**
     * Timestamp of the message to remove star from.
     *
     * @param ts e.g. 1234567890.123456
     */
    public void setTimestamp(String ts){
        put(SlackParamsConstants.TIMESTAMP, ts);
    }
}
