package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Dnd Team Info method
 */
public class DndTeamInfoParams extends Params {

    /**
     * Comma-separated list of users to fetch Do Not Disturb status for
     *
     * @param users
     */
    public void setUsers(String users){
        put(SlackParamsConstants.USERS, users);
    }
}
