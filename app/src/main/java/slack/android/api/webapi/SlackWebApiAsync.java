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
import slack.android.api.webapi.params.ChannelListParams;
import slack.android.api.webapi.params.ChatParams;
import slack.android.api.webapi.params.ChatPostParams;
import slack.android.api.webapi.params.ChatUpdateParams;
import slack.android.api.webapi.params.DndInfoParams;
import slack.android.api.webapi.params.DndTeamInfoParams;
import slack.android.api.webapi.response.ApiTestResponse;
import slack.android.api.webapi.response.AuthRevokeResponse;
import slack.android.api.webapi.response.AuthTestResponse;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.BotsInfoResponse;
import slack.android.api.webapi.response.ChannelHistoryResponse;
import slack.android.api.webapi.response.ChannelListResponse;
import slack.android.api.webapi.response.ChannelPurposeResponse;
import slack.android.api.webapi.response.ChannelResponse;
import slack.android.api.webapi.response.ChannelTopicResponse;
import slack.android.api.webapi.response.ChatPostResponse;
import slack.android.api.webapi.response.ChatResponse;
import slack.android.api.webapi.response.ChatUpdateResponse;
import slack.android.api.webapi.response.DndEndSnoozeResponse;
import slack.android.api.webapi.response.DndInfoResponse;
import slack.android.api.webapi.response.DndSetSnoozeResponse;
import slack.android.api.webapi.response.DndTeamInfoResponse;
import slack.android.api.webapi.response.EmojiListResponse;

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

    /**
     * This method returns a list of all channels in the team. This includes channels the caller
     * is in, channels they are not currently in, and archived channels but does not include private
     * channels. The number of (non-deactivated) members in each channel is also returned.
     *
     * Requires scope: channels:read
     *
     * @param params
     * @param callback
     */
    public void getChannelList(@NonNull ChannelListParams params, Callback<ChannelListResponse> callback){
        service.channelsList(params.build()).enqueue(callback);
    }

    /**
     * This method moves the read cursor in a channel.
     *
     * Requires scope: channels:write
     *
     * @param channelId Channel to set reading cursor in.
     * @param ts Timestamp of the most recently seen message.
     * @param callback
     */
    public void getChannelMark(@NonNull String channelId, @NonNull String ts, Callback<BaseResponse> callback){
        service.channelsMark(channelId, ts).enqueue(callback);
    }

    /**
     * This method renames a team channel.
     *
     * The only people who can rename a channel are Team Admins, or the person that originally
     * created the channel. Others will receive a "not_authorized" error.
     *
     * Requires scope: channels:write
     *
     * @param channelId Channel to rename
     * @param name New name for channel.
     * @param callback
     */
    public void getChannelRename(@NonNull String channelId, @NonNull String name, Callback<ChannelResponse> callback){
        service.channelsRename(channelId, name).enqueue(callback);
    }

    /**
     * This method is used to change the purpose of a channel. The calling user must be a member of the channel.
     *
     * Requires scope: channels:write
     *
     * @param channelId Channel to set the purpose of
     * @param purpose The new purpose
     * @param callback
     */
    public void getChannelSetPurpose(@NonNull String channelId, @NonNull String purpose, Callback<ChannelPurposeResponse> callback){
        service.channelsSetPurpose(channelId, purpose).enqueue(callback);
    }


    /**
     * This method is used to change the topic of a channel. The calling user must be a member of the channel.
     *
     * Requires scope: channels:write
     *
     * @param channelId Channel to set the purpose of
     * @param topic The new topic
     * @param callback
     */
    public void getChannelSetTopic(@NonNull String channelId, @NonNull String topic, Callback<ChannelTopicResponse> callback){
        service.channelsSetTopic(channelId, topic).enqueue(callback);
    }

    /**
     * This method unarchives a channel. The calling user is added to the channel.
     *
     * Requires scope: channels:write
     *
     * @param channelId Channel to unarchive
     * @param callback
     */
    public void getChannelUnarchive(@NonNull String channelId, Callback<BaseResponse> callback){
        service.channelsUnarchive(channelId).enqueue(callback);
    }

    /**
     * This method deletes a message from a channel.
     *
     * Requires scope: chat:write:bot or chat:write:user
     *
     * @param ts Timestamp of the message to be deleted.
     * @param channelId Channel containing the message to be deleted.
     * @param params
     * @param callback
     */
    public void getChatDelete(@NonNull String ts, @NonNull String channelId, @NonNull ChatParams params, Callback<ChatResponse> callback){
        service.chatDelete(ts, channelId, params.build()).enqueue(callback);
    }

    /**
     * This method sends a me message to a channel from the calling user.
     *
     * Requires scope: chat:write:user
     *
     * @param channelId Channel to send message to. Can be a public channel, private group or IM channel. Can be an encoded ID, or a name.
     * @param text Text of the message to send.
     * @param callback
     */
    public void getChatMeMessage(@NonNull String channelId, @NonNull String text, Callback<ChatResponse> callback){
        service.chatMeMessage(channelId, text).enqueue(callback);
    }

    /**
     * This method posts a message to a public channel, private channel, or direct message/IM channel.
     *
     * Requires scope: chat:write:bot or chat:write:user
     *
     * @param channelId Channel to send message to. Can be a public channel, private group or IM channel. Can be an encoded ID, or a name.
     * @param text Text of the message to send.
     * @param params
     * @param callback
     */
    public void getChatPostMessage(@NonNull String channelId, @NonNull String text, ChatPostParams params, Callback<ChatPostResponse> callback){
        service.chatPostMessage(channelId, text, params.build()).enqueue(callback);
    }

    /**
     * This method updates a message in a channel. Though related to chat.postMessage, some parameters of chat.update are handled differently.
     *
     * Requires scope: chat:write:bot or chat:write:user
     *
     * @param ts Timestamp of the message to be updated.
     * @param channelId Channel containing the message to be updated.
     * @param text New text for the message
     * @param params
     * @param callback
     */
    public void getChatUpdate(@NonNull String ts, @NonNull String channelId, @NonNull String text, ChatUpdateParams params, Callback<ChatUpdateResponse> callback){
        service.chatUpdate(ts, channelId, text, params.build()).enqueue(callback);
    }

    /**
     * Ends the user's currently scheduled Do Not Disturb session immediately.
     *
     * Requires scope: dnd:write
     *
     * @param callback
     */
    public void getDndEndDnd(Callback<BaseResponse> callback){
        service.dndEndDnd().enqueue(callback);
    }

    /**
     * Ends the current user's snooze mode immediately.
     *
     * Requires scope: dnd:write
     *
     * @param callback
     */
    public void getDndEndSnooze(Callback<DndEndSnoozeResponse> callback){
        service.dndEndSnooze().enqueue(callback);
    }

    /**
     * Provides information about a user's current Do Not Disturb settings.
     *
     * Requires scope: dnd:read
     *
     * @param params
     * @param callback
     */
    public void getDndInfo(@NonNull DndInfoParams params, Callback<DndInfoResponse> callback){
        service.dndInfo(params.build()).enqueue(callback);
    }

    /**
     * Adjusts the snooze duration for a user's Do Not Disturb settings. If a snooze session is not
     * already active for the user, invoking this method will begin one for the specified duration.
     *
     * Requires scope: dnd:write
     *
     * @param minutes Number of minutes, from now, to snooze until.
     * @param callback
     */
    public void getDndSetSnooze(int minutes, Callback<DndSetSnoozeResponse> callback){
        service.dndSetSnooze(String.valueOf(minutes)).enqueue(callback);
    }

    /**
     * Provides information about the current Do Not Disturb settings for users of a Slack team.
     *
     * Requires scope: dnd:read
     *
     * @param params
     * @param callback
     */
    public void getDndTeamInfo(@NonNull DndTeamInfoParams params, Callback<DndTeamInfoResponse> callback){
        service.dndTeamInfo(params.build()).enqueue(callback);
    }

    /**
     * This method lists the custom emoji for a team.
     *
     * Requires scope: emoji:read
     *
     * @param callback
     */
    public void getEmojiList(Callback<EmojiListResponse> callback){
        service.emojList().enqueue(callback);
    }
}
