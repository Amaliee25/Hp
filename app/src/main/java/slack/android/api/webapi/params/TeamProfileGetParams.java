package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Team profile get method
 */
public class TeamProfileGetParams extends Params {

    /**
     * Filter by visibility.
     *
     * @param visibility
     */
    public void setVisibility(String visibility){
        put(SlackParamsConstants.VISIBILITY, visibility);
    }
}
