package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api User Profile Set method
 */
public class UserProfileSetParams extends Params {

    /**
     * This method is used to set the profile information for a user.
     *
     * @param userId e.g. U1234567890
     */
    public void setUser(String userId){
        put(SlackParamsConstants.USER, userId);
    }

    /**
     * Collection of key:value pairs presented as a URL-encoded JSON hash.
     *
     * @param profile e.g. 	{ first_name: "John", ... }
     */
    public void setProfile(String profile){
        put(SlackParamsConstants.PROFILE, profile);
    }

    /**
     * Name of a single key to set. Usable only if profile is not passed.
     *
     * @param name e.g. first_name
     */
    public void setName(String name){
        put(SlackParamsConstants.NAME, name);
    }

    /**
     * Value to set a single key to. Usable only if profile is not passed.
     *
     * @param value e.g. John
     */
    public void setValue(String value){
        put(SlackParamsConstants.VALUE, value);
    }
}
