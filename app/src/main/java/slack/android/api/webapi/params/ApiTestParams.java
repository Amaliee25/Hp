package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Test method
 */
public class ApiTestParams extends Params {

    /**
     * Set argument error response to return
     * @param error Error response to return
     */
    public void setError(String error){
        params.put(SlackParamsConstants.ERROR, error);
    }

    /**
     * Set argument example property to return
     * @param foo example property to return
     */
    public void setFoo(String foo){
        params.put(SlackParamsConstants.FOO, foo);
    }
}
