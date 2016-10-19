package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Team billable info method
 */
public class TeamBillableInfoParams extends Params {

    /**
     * A user to retrieve the billable information for. Defaults to all users.
     *
     * @param userId e.g. U1234567890
     */
    public void setUser(String userId){
        put(SlackParamsConstants.USER, userId);
    }
}
