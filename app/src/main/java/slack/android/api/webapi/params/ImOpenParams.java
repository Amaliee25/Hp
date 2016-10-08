package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Im Open method
 */
public class ImOpenParams extends Params{

    /**
     * Boolean, indicates you want the full IM channel definition in the response.
     *
     * @param isReturn e.g.: true
     */
    public void setReturnIm(boolean isReturn){
        put(SlackParamsConstants.RETURN_IM, isReturn);
    }
}
