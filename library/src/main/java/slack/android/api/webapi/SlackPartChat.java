package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.ChatParams;
import slack.android.api.webapi.params.ChatPostParams;
import slack.android.api.webapi.params.ChatUpdateParams;
import slack.android.api.webapi.response.ChatPostResponse;
import slack.android.api.webapi.response.ChatResponse;
import slack.android.api.webapi.response.ChatUpdateResponse;

public class SlackPartChat extends BaseSlackPart {

    protected SlackPartChat(SlackWebApiInterface service){
        super(service);
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
    public void delete(@NonNull String ts, @NonNull String channelId, @NonNull ChatParams params, Callback<ChatResponse> callback){
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
    public void meMessage(@NonNull String channelId, @NonNull String text, Callback<ChatResponse> callback){
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
    public void postMessage(@NonNull String channelId, @NonNull String text, ChatPostParams params, Callback<ChatPostResponse> callback){
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
    public void update(@NonNull String ts, @NonNull String channelId, @NonNull String text, ChatUpdateParams params, Callback<ChatUpdateResponse> callback){
        service.chatUpdate(ts, channelId, text, params.build()).enqueue(callback);
    }
}
