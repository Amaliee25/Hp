package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Usergroup User Update method
 */
public class UsergroupUserUpdateParams extends Params {

    /**
     * Include the number of users in the User Group.
     *
     * @param includeCount
     */
    public void setIncludeCount(boolean includeCount){
        put(SlackParamsConstants.INCLUDE_COUNT, includeCount);
    }
}
