package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api File Info method
 */
public class FileInfoParams extends Params {

    /**
     * Number of items to return per page.
     *
     * Default: 100
     *
     * @param count
     */
    public void setCount(int count){
        put(SlackParamsConstants.COUNT, count, 1, 1000);
    }

    /**
     * Page number of results to return.
     *
     * Default: 1
     *
     * @param page
     */
    public void setPage(int page){
        put(SlackParamsConstants.PAGE, page);
    }

}
