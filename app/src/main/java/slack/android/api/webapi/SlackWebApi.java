package slack.android.api.webapi;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import slack.android.api.webapi.params.ApiTestParams;
import slack.android.api.webapi.params.AuthRevokeParams;
import slack.android.api.webapi.response.ApiTestResponse;
import slack.android.api.webapi.response.AuthRevokeResponse;
import slack.android.api.webapi.response.AuthTestResponse;

/**
 * Implement Slack Web Api. Use Retrofit to do it.
 */
public class SlackWebApi {
    private static SlackWebApiInterface service;
    private final String token;
    private static OkHttpClient.Builder builder = new OkHttpClient.Builder();

    private static SlackWebApi INSTANCE;

    public static SlackWebApi getService(String authToken){
        if(INSTANCE == null){
            INSTANCE = new SlackWebApi(authToken);
        }
        return INSTANCE;
    }

    public SlackWebApi(final String authToken) {
        token = authToken;
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.interceptors().add(interceptor);
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                if (request.url().toString().startsWith(SlackWebApiConstants.SLACK_BASE_WEB_API_URL)) {
                    HttpUrl url = request.url().newBuilder().addQueryParameter("token", authToken).build();
                    request = request.newBuilder().url(url).build();
                }
                return chain.proceed(request);
            }
        });
        Retrofit retrofit = new Retrofit.Builder().baseUrl(SlackWebApiConstants.SLACK_BASE_WEB_API_URL).client(builder.build())
                .addConverterFactory(GsonConverterFactory.create()).build();
        service = retrofit.create(SlackWebApiInterface.class);
    }

    /**
     * This method helps you test your calling code.
     * @see <a href="https://api.slack.com/methods/api.test">https://api.slack.com/methods/api.test</a>
     * @param callback
     * @param params @see {@link slack.android.api.webapi.params.ApiTestParams}
     * @return
     */
    public void getApiTest(Callback<ApiTestResponse> callback, ApiTestParams params){
        service.apiTest(params.build()).enqueue(callback);
    }

    /**
     * This method revokes an access token. Use it when you no longer need a token.
     * @see <a href="https://api.slack.com/methods/auth.revoke">https://api.slack.com/methods/auth.revoke</a>
     * @param callback
     * @param params @see {@link slack.android.api.webapi.params.AuthRevokeParams}
     * @return
     */
    public void getAuthRevoke(Callback<AuthRevokeResponse> callback, AuthRevokeParams params){
        service.authRevoke(params.build()).enqueue(callback);
    }

    /**
     * This method checks authentication and tells you who you are.
     * @see <a href="https://api.slack.com/methods/auth.test">https://api.slack.com/methods/auth.test</a>
     * @return
     */
    public void getAuthTest(Callback<AuthTestResponse> callback){
        service.authTest().enqueue(callback);
    }
}
