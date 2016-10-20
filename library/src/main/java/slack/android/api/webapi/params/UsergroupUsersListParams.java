package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Usergroup Enable method
 */
public class UsergroupUsersListParams extends Params {

    /**
     * Allow results that involve disabled User Groups.
     *
     * @param includeDisabled
     */
    public void setIncludeDisabled(boolean includeDisabled){
        put(SlackParamsConstants.INCLUDE_DISABLED, includeDisabled);
    }
}
