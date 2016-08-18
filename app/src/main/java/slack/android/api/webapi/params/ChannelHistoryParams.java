package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Channels History method
 */
public class ChannelHistoryParams extends Params {

    /**
     * End of time range of messages to include in results.
     *
     * Default: now
     *
     * @param latest e.g.: 1234567890.123456
     */
    public void setLatest(String latest){
        params.put(SlackParamsConstants.LATEST, latest);
    }

    /**
     * Start of time range of messages to include in results.
     *
     * Default: 0
     *
     * @param oldest e.g.: 1234567890.123456
     */
    public void setOldest(String oldest){
        params.put(SlackParamsConstants.OLDEST, oldest);
    }

    /**
     * Include messages with latest or oldest timestamp in results.
     *
     * Default: 0
     *
     * @param inclusive
     */
    public void setInclusive(boolean inclusive){
        params.put(SlackParamsConstants.INCLUSIVE, inclusive ? "1" : "0");
    }

    /**
     * Number of messages to return, between 1 and 1000.
     *
     * Default: 100
     *
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
     *
     * Default: 0
     *
     * @param unread
     */
    public void setUnread(boolean unread){
        params.put(SlackParamsConstants.UNREADS, unread ? "1" : "0");
    }
}
