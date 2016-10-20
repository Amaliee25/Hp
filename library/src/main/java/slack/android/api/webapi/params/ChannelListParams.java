package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Channels List method
 */
public class ChannelListParams extends Params {

    /**
     * Don't return archived channels.
     *
     * Default: 0
     *
     * @param excludeArchived
     */
    public void setExcludeArchived(boolean excludeArchived){
        put(SlackParamsConstants.EXCLUDE_ARCHIVED, excludeArchived);
    }

}
