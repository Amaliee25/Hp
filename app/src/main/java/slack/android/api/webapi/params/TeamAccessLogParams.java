package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Team access logs method
 */
public class TeamAccessLogParams extends Params {

    /**
     * Number of items to return per page.
     *
     * @param count e.g. 100
     */
    public void setCount(int count){
        put(SlackParamsConstants.COUNT, count, 1, 1000);
    }

    /**
     * Page number of results to return.
     *
     * @param page e.g. 1
     */
    public void setPage(int page){
        put(SlackParamsConstants.PAGE, page, 1, 100);
    }
}
