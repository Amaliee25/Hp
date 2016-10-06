package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Pins Add method
 */
public class PinAddParams extends Params {

    /**
     * File to pin.
     *
     * @param fileId
     */
    public void setFile(String fileId){
        params.put(SlackParamsConstants.FILE, fileId);
    }

    /**
     * File comment to pin.
     *
     * @param comment
     */
    public void setFileComment(String comment){
        params.put(SlackParamsConstants.FILE_COMMENT, comment);
    }

    /**
     * Timestamp of the message to pin.
     * @param ts
     */
    public void setTimestamp(String ts){
        params.put(SlackParamsConstants.TIMESTAMP, ts);
    }
}
