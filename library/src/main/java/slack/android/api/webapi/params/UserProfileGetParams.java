package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api User Profile Get method
 */
public class UserProfileGetParams extends Params {

    /**
     * This method is used to get the profile information for a user.
     *
     * @param userId e.g. U1234567890
     */
    public void setUser(String userId){
        put(SlackParamsConstants.USER, userId);
    }

    /**
     * Include labels for each ID in custom profile fields
     *
     * @param includeLabels
     */
    public void setIncludeLabels(boolean includeLabels){
        put(SlackParamsConstants.INCLUDE_LABELS, includeLabels);
    }
}
