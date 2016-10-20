package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api User List method
 */
public class UserListParams extends Params {

    /**
     * Whether to include presence data in the output
     * @param presence
     */
    public void setPresence(boolean presence){
        put(SlackParamsConstants.PRESENCE, presence);
    }
}
