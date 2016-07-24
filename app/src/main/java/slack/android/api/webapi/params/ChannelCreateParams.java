package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Channels Create method
 */
public class ChannelCreateParams extends Params {

    /**
     * End of time range of messages to include in results.
     * @param latest
     */
    public void setLatest(String latest){
        params.put(SlackParamsConstants.LATEST, latest);
    }

    /**
     * Start of time range of messages to include in results.
     * @param oldest
     */
    public void setOldest(String oldest){
        params.put(SlackParamsConstants.OLDEST, oldest);
    }

    /**
     * Include messages with latest or oldest timestamp in results.
     * @param inclusive
     */
    public void setInclusive(boolean inclusive){
        params.put(SlackParamsConstants.INCLUSIVE, inclusive ? "1" : "0");
    }

    /**
     * Number of messages to return, between 1 and 1000.
     * @param count
     */
    public void setCount(int count){
        if(count < 1){
            count = 1;
        }
        else if(count > 1000){
            count = 1000;
        }

        params.put(SlackParamsConstants.COUNT, String.valueOf(count));
    }

    /**
     * Include unread_count_display in the output?
     * @param unreads
     */
    public void setUnreads(boolean unreads){
        params.put(SlackParamsConstants.UNREADS, unreads ? "1" : "0");
    }

}
