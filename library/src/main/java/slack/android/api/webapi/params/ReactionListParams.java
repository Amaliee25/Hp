package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Reaction Get method
 */
public class ReactionListParams extends Params {

    /**
     * Show reactions made by this user. Defaults to the authed user.
     * @param user e.g. U1234567890
     */
    private void serUser(String user){
        put(SlackParamsConstants.USER, user);
    }

    /**
     * If true always return the complete reaction list.
     *
     * @param isFull
     */
    private void setIsFulll(boolean isFull){
        put(SlackParamsConstants.IS_FULL, isFull);
    }

    /**
     * Number of items to return per page.
     * @param count e.g. 100
     */
    private void setCount(int count){
        put(SlackParamsConstants.COUNT, count, 1, 1000);
    }

    /**
     * Page number of results to return.
     * @param page e.g. 1
     */
    private void setPage(int page){
        put(SlackParamsConstants.PAGE, page);
    }
}
