package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Usergroup List method
 */
public class UsergroupsListParams extends Params {

    /**
     * Include disabled User Groups.
     *
     * @param includeDisabled
     */
    public void setIncludeDisabled(boolean includeDisabled){
        put(SlackParamsConstants.INCLUDE_DISABLED, includeDisabled);
    }

    /**
     * Include the number of users in the User Group.
     *
     * @param includeCount
     */
    public void setIncludeCount(boolean includeCount){
        put(SlackParamsConstants.INCLUDE_COUNT, includeCount);
    }

    /**
     * Include the list of users for each User Group.
     *
     * @param includeUsers
     */
    public void setIncludeUsers(boolean includeUsers){
        put(SlackParamsConstants.INCLUDE_USERS, includeUsers);
    }
}
