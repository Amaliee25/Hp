package slack.android.api.webapi;

import android.support.annotation.NonNull;

import java.util.HashMap;

import retrofit2.Callback;
import slack.android.api.webapi.params.ChannelCreateParams;
import slack.android.api.webapi.params.ChannelListParams;
import slack.android.api.webapi.params.HistoryParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.ChannelListResponse;
import slack.android.api.webapi.response.ChannelPurposeResponse;
import slack.android.api.webapi.response.ChannelResponse;
import slack.android.api.webapi.response.ChannelTopicResponse;
import slack.android.api.webapi.response.HistoryResponse;

/**
 * Created by flaviokreis on 20/10/16.
 */
public class SlackPartChannels extends BaseSlackPart {

    protected SlackPartChannels(SlackWebApiInterface service){
        super(service);
    }

    /**
     * This method archives a channel.
     *
     * Requires scope: channels:write
     *
     * @param channelId Channel to archive
     * @param callback
     */
    public void archive(@NonNull String channelId, Callback<BaseResponse> callback){
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
     * @param callback
     */
    public void create(@NonNull String channelName, Callback<ChannelResponse> callback){
        create(channelName, null, callback);
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
    public void create(@NonNull String channelName, ChannelCreateParams params, Callback<ChannelResponse> callback){
        service.channelsCreate(channelName, (params != null) ? params.build() : new HashMap<String, String>()).enqueue(callback);
    }

    /**
     * This method returns a portion of message events from the specified channel.
     *
     * Requires scope: channels:history
     *
     * @param channelId Channel to fetch history for.
     * @param callback
     */
    public void history(@NonNull String channelId, Callback<HistoryResponse> callback){
        history(channelId, null, callback);
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
    public void history(@NonNull String channelId, HistoryParams params, Callback<HistoryResponse> callback){
        service.channelsHistory(channelId, (params != null) ? params.build() : new HashMap<String, String>()).enqueue(callback);
    }

    /**
     * This method returns information about a team channel.
     *
     * Requires scope: channel:read
     *
     * @param channelId Channel to get info on
     * @param callback
     */
    public void info(@NonNull String channelId, Callback<ChannelResponse> callback){
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
    public void invite(@NonNull String channelId, @NonNull String userId, Callback<ChannelResponse> callback){
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
    public void join(@NonNull String channelName, Callback<ChannelResponse> callback){
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
    public void kick(@NonNull String channelId, @NonNull String userId, Callback<BaseResponse> callback){
        service.channelsKick(channelId, userId).enqueue(callback);
    }

    /**
     * This method is used to leave a channel.
     *
     * @param channelId Channel to leave
     * @param callback
     */
    public void leave(@NonNull String channelId, Callback<BaseResponse> callback){
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
    public void list(@NonNull ChannelListParams params, Callback<ChannelListResponse> callback){
        service.channelsList((params != null) ? params.build() : new HashMap<String, String>()).enqueue(callback);
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
    public void mark(@NonNull String channelId, @NonNull String ts, Callback<BaseResponse> callback){
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
    public void rename(@NonNull String channelId, @NonNull String name, Callback<ChannelResponse> callback){
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
    public void setPurpose(@NonNull String channelId, @NonNull String purpose, Callback<ChannelPurposeResponse> callback){
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
    public void setTopic(@NonNull String channelId, @NonNull String topic, Callback<ChannelTopicResponse> callback){
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
    public void unarchive(@NonNull String channelId, Callback<BaseResponse> callback){
        service.channelsUnarchive(channelId).enqueue(callback);
    }

}
