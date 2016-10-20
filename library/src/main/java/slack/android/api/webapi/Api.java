package slack.android.api.webapi;

import java.util.HashMap;

import retrofit2.Callback;
import slack.android.api.webapi.params.ApiTestParams;
import slack.android.api.webapi.response.ApiTestResponse;

public class Api {
    private SlackWebApiInterface service;

    protected Api(SlackWebApiInterface service){
        this.service = service;
    }

    /**
     * This method helps you test your calling code.
     * @see <a href="https://api.slack.com/methods/api.test">https://api.slack.com/methods/api.test</a>
     * @param callback
     */
    public void test(Callback<ApiTestResponse> callback){
        test(null, callback);
    }

    /**
     * This method helps you test your calling code.
     * @see <a href="https://api.slack.com/methods/api.test">https://api.slack.com/methods/api.test</a>
     * @param params @see {@link slack.android.api.webapi.params.ApiTestParams}
     * @param callback
     */
    public void test(ApiTestParams params, Callback<ApiTestResponse> callback){
        service.apiTest((params != null) ? params.build() : new HashMap<String, String>()).enqueue(callback);
    }
}
