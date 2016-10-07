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
        params.put(SlackParamsConstants.USER, user);
    }

    /**
     * If true always return the complete reaction list.
     *
     * @param isFull
     */
    private void setIsFulll(boolean isFull){
        params.put(SlackParamsConstants.IS_FULL, isFull ? "1" : "0" );
    }

    /**
     * Number of items to return per page.
     * @param value e.g. 100
     */
    private void setCount(int value){
        params.put(SlackParamsConstants.COUNT, String.valueOf(value));
    }

    /**
     * Page number of results to return.
     * @param value e.g. 1
     */
    private void setPage(int value){
        params.put(SlackParamsConstants.PAGE, String.valueOf(value));
    }
}
