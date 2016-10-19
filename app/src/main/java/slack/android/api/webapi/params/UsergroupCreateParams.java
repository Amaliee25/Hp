package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Usergroup Create method
 */
public class UsergroupCreateParams extends Params {

    /**
     * A mention handle. Must be unique among channels, users and User Groups.
     *
     * @param handle
     */
    public void setHandle(String handle){
        put(SlackParamsConstants.HANDLE, handle);
    }

    /**
     * A short description of the User Group.
     *
     * @param description
     */
    public void setDescription(String description){
        put(SlackParamsConstants.DESCRIPTION, description);
    }

    /**
     * A comma separated string of encoded channel IDs for which the User Group uses as a default.
     *
     * @param channels
     */
    public void setChannels(String channels){
        put(SlackParamsConstants.CHANNELS, channels);
    }

    /**
     * Include the number of users in each User Group.
     *
     * @param includeCount
     */
    public void setIncludeCount(boolean includeCount){
        put(SlackParamsConstants.INCLUDE_COUNT, includeCount);
    }
}
