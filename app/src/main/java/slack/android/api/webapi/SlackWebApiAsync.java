package slack.android.api.webapi;

import android.support.annotation.NonNull;

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
import slack.android.api.webapi.params.BotsInfoParams;
import slack.android.api.webapi.params.ChannelCreateParams;
import slack.android.api.webapi.params.ChannelHistoryParams;
import slack.android.api.webapi.response.ApiTestResponse;
import slack.android.api.webapi.response.AuthRevokeResponse;
import slack.android.api.webapi.response.AuthTestResponse;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.BotsInfoResponse;
import slack.android.api.webapi.response.ChannelResponse;
import slack.android.api.webapi.response.ChannelHistoryResponse;

/**
 * Implement Slack Web Api. Use Retrofit to do it.
 */
public class SlackWebApiAsync {
    private static SlackWebApiInterface service;
    private final String token;
    private static OkHttpClient.Builder builder = new OkHttpClient.Builder();

    private static SlackWebApiAsync INSTANCE;

    public static SlackWebApiAsync getService(@NonNull String authToken){
        if(INSTANCE == null){
            INSTANCE = new SlackWebApiAsync(authToken);
        }
        return INSTANCE;
    }

    public SlackWebApiAsync(@NonNull final String authToken) {
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
     * @param params @see {@link slack.android.api.webapi.params.ApiTestParams}
     * @param callback
     */
    public void getApiTest(@NonNull ApiTestParams params, Callback<ApiTestResponse> callback){
        service.apiTest(params.build()).enqueue(callback);
    }

    /**
     * This method revokes an access token. Use it when you no longer need a token.
     * @see <a href="https://api.slack.com/methods/auth.revoke">https://api.slack.com/methods/auth.revoke</a>
     * @param params @see {@link slack.android.api.webapi.params.AuthRevokeParams}
     * @param callback
     */
    public void getAuthRevoke(@NonNull AuthRevokeParams params, Callback<AuthRevokeResponse> callback){
        service.authRevoke(params.build()).enqueue(callback);
    }

    /**
     * This method checks authentication and tells you who you are.
     *
     * Requires scope: identify
     *
     * @see <a href="https://api.slack.com/methods/auth.test">https://api.slack.com/methods/auth.test</a>
     * @param callback
     */
    public void getAuthTest(Callback<AuthTestResponse> callback){
        service.authTest().enqueue(callback);
    }

    /**
     * This method returns information about a bot user.
     * bot_id is returned from bot_message message events and in the response of methods like channels.history.
     * Use this method to look up the username and icons for those bot users.
     *
     * Requires scope: users:read
     *
     * @param params
     * @param callback
     */
    public void getBotsInfo(@NonNull BotsInfoParams params, Callback<BotsInfoResponse> callback){
        service.botInfo(params.build()).enqueue(callback);
    }

    /**
     * This method archives a channel.
     *
     * Requires scope: channels:write
     *
     * @param channelId Channel to archive
     * @param callback
     */
    public void getChannelsArchive(@NonNull String channelId, Callback<BaseResponse> callback){
        service.channelsArchive(channelId).enqueue(callback);
    }

    /**
     * This method is used to create a channel.
     *
     * Requires scope: channels:write
     *
     * Channel names can only contain lowercase letters, numbers, hyphens, and underscores, and
     * must be 21 characters or less. We will validate the submitted channel name and modify it
     * to meet the above criteria. When calling this method, we recommend storing the channel's
     * name value that is returned in the response.
     *
     * @param channelName Name of channel to create
     * @param params
     * @param callback
     */
    public void getChannelsCreate(@NonNull String channelName, @NonNull ChannelCreateParams params, Callback<ChannelResponse> callback){
        service.channelsCreate(channelName, params.build()).enqueue(callback);
    }

    /**
     * This method returns a portion of message events from the specified channel.
     *
     * Requires scope: channels:history
     *
     * @param channelId Channel to fetch history for.
     * @param params
     * @param callback
     */
    public void getChannelsHistory(@NonNull String channelId, @NonNull ChannelHistoryParams params, Callback<ChannelHistoryResponse> callback){
        service.channelsHistory(channelId, params.build()).enqueue(callback);
    }

    /**
     * This method returns information about a team channel.
     *
     * Requires scope: channel:read
     *
     * @param channelId Channel to get info on
     * @param callback
     */
    public void getChannelsInfo(@NonNull String channelId, Callback<ChannelResponse> callback){
        service.channelsInfo(channelId).enqueue(callback);
    }

    /**
     * This method is used to invite a user to a channel. The calling user must be a member of the channel.
     *
     * Requires scope: channel:write
     *
     * @param channelId Channel to invite user to.
     * @param userId User to invite to channel.
     * @param callback
     */
    public void getChannelsInvite(@NonNull String channelId, @NonNull String userId, Callback<ChannelResponse> callback){
        service.channelsInvite(channelId, userId).enqueue(callback);
    }

    /**
     * This method is used to join a channel. If the channel does not exist, it is created.
     *
     * Requires scope: channel:write
     *
     * @param channelName Name of channel to join
     * @param callback
     */
    public void getChannelsJoin(@NonNull String channelName, Callback<ChannelResponse> callback){
        service.channelsJoin(channelName).enqueue(callback);
    }

    /**
     * This method allows a user to remove another member from a team channel.
     *
     * Requires scope: channel:write
     *
     * @param channelId Channel to remove user from.
     * @param userId User to remove from channel.
     * @param callback
     */
    public void getChannelsKick(@NonNull String channelId, @NonNull String userId, Callback<BaseResponse> callback){
        service.channelsKick(channelId, userId).enqueue(callback);
    }

    /**
     * This method is used to leave a channel.
     *
     * @param channelId Channel to leave
     * @param callback
     */
    public void getChannelLeave(@NonNull String channelId, Callback<BaseResponse> callback){
        service.channelsLeave(channelId).enqueue(callback);
    }

}
