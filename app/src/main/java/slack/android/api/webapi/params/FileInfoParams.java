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
        if(count < 1){
            count = 1;
        }
        params.put(SlackParamsConstants.COUNT, String.valueOf(count));
    }

    /**
     * Page number of results to return.
     *
     * Default: 1
     *
     * @param page
     */
    public void setPage(int page){
        if(page < 1){
            page = 1;
        }
        params.put(SlackParamsConstants.PAGE, String.valueOf(page));
    }

}
