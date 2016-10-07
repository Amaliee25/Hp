package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Pins Remove method
 */
public class PinRemoveParams extends Params {

    /**
     * File to un-pin.
     *
     * @param fileId
     */
    public void setFile(String fileId){
        params.put(SlackParamsConstants.FILE, fileId);
    }

    /**
     * File comment to un-pin.
     *
     * @param comment
     */
    public void setFileComment(String comment){
        params.put(SlackParamsConstants.FILE_COMMENT, comment);
    }

    /**
     * Timestamp of the message to un-pin.
     * @param ts
     */
    public void setTimestamp(String ts){
        params.put(SlackParamsConstants.TIMESTAMP, ts);
    }
}
