package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Dnd Info method
 */
public class DndInfoParams extends Params {

    /**
     * User to fetch status for (defaults to current user)
     *
     * @param user
     */
    public void setUser(String user){
        params.put(SlackParamsConstants.USER, user);
    }
}
