package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Reminder Add method
 */
public class ReminderAddParams extends Params {

    /**
     * The user who will receive the reminder. If no user is specified, the reminder will go to
     * user who created it.
     *
     * @param user e.g. U18888888
     */
    public void setUser(String user){
        put(SlackParamsConstants.USER, user);
    }
}
