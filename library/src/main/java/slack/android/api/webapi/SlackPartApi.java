package slack.android.api.webapi;

import retrofit2.Callback;
import slack.android.api.webapi.params.ApiTestParams;
import slack.android.api.webapi.response.ApiTestResponse;

public class SlackPartApi extends BaseSlackPart {

    protected SlackPartApi(SlackWebApiInterface service){
        super(service);
    }

    /**
     * This method helps you test your calling code.
     *
     * @see <a href="https://api.slack.com/methods/api.test">https://api.slack.com/methods/api.test</a>
     *
     * @param callback @see {@link slack.android.api.webapi.response.ApiTestResponse}
     */
    public void test(Callback<ApiTestResponse> callback){
        test( null, callback );
    }

    /**
     * This method helps you test your calling code.
     *
     * @see <a href="https://api.slack.com/methods/api.test">https://api.slack.com/methods/api.test</a>
     *
     * @param params @see {@link slack.android.api.webapi.params.ApiTestParams}
     * @param callback @see {@link slack.android.api.webapi.response.ApiTestResponse}
     */
    public void test(ApiTestParams params, Callback<ApiTestResponse> callback){
        service.apiTest( verifyParams( params ) ).enqueue( callback );
    }
}
