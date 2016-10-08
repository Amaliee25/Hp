package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Chat methods
 */
public class ChatParams extends Params {

    /**
     * Pass true to delete the message as the authed user. Bot users in this context are considered authed users.
     *
     * @param asUser
     */
    public void setAsUser(boolean asUser){
        put(SlackParamsConstants.AS_USER, asUser);
    }

}
