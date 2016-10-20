package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Channels Create method
 */
public class ChannelCreateParams extends Params {

    /**
     * End of time range of messages to include in results.
     *
     * Default: now
     *
     * @param latest e.g.: 1234567890.123456
     */
    public void setLatest(String latest){
        put(SlackParamsConstants.LATEST, latest);
    }

    /**
     * Start of time range of messages to include in results.
     *
     * Default: 0
     *
     * @param oldest e.g.: 1234567890.123456
     */
    public void setOldest(String oldest){
        put(SlackParamsConstants.OLDEST, oldest);
    }

    /**
     * Include messages with latest or oldest timestamp in results.
     * @param inclusive
     */
    public void setInclusive(boolean inclusive){
        put(SlackParamsConstants.INCLUSIVE, inclusive);
    }

    /**
     * Number of messages to return, between 1 and 1000.
     *
     * Default: 100
     *
     * @param count
     */
    public void setCount(int count){
        put(SlackParamsConstants.COUNT, count, 1, 1000);
    }

    /**
     * Include unread_count_display in the output?
     * @param unreads
     */
    public void setUnreads(boolean unreads){
        put(SlackParamsConstants.UNREADS, unreads);
    }

}
