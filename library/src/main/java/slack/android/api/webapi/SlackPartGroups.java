package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.GroupListParams;
import slack.android.api.webapi.params.HistoryParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.ChannelPurposeResponse;
import slack.android.api.webapi.response.ChannelTopicResponse;
import slack.android.api.webapi.response.GroupCloseResponse;
import slack.android.api.webapi.response.GroupCreateResponse;
import slack.android.api.webapi.response.GroupListResponse;
import slack.android.api.webapi.response.HistoryResponse;

public class SlackPartGroups extends BaseSlackPart {

    protected SlackPartGroups(SlackWebApiInterface service){
        super(service);
    }

    /**
     * This method archives a private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to archive
     * @param callback
     */
    public void archive(@NonNull String channelId, Callback<BaseResponse> callback){
        service.groupsArchive(channelId).enqueue(callback);
    }

    /**
     * This method closes a private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to close.
     * @param callback
     */
    public void close(@NonNull String channelId, Callback<GroupCloseResponse> callback){
        service.groupsClose(channelId).enqueue(callback);
    }

    /**
     * This method creates a private channel.
     *
     * Requires scope: groups:write
     *
     * @param name Name of private channel to create
     * @param callback
     */
    public void create(@NonNull String name, Callback<GroupCreateResponse> callback){
        service.groupsCreate(name).enqueue(callback);
    }

    /**
     * This method takes an existing private channel and performs the following steps:
     *
     * Renames the existing private channel (from "example" to "example-archived").
     * Archives the existing private channel.
     * Creates a new private channel with the name of the existing private channel
     * Adds all members of the existing private channel to the new private channel.
     *
     * This is useful when inviting a new member to an existing private channel while hiding
     * all previous chat history from them. In this scenario you can call groups.createChild
     * followed by groups.invite.
     *
     * The new private channel will have a special parent_group property pointing to the original
     * archived private channel. This will only be returned for members of both private channels,
     * so will not be visible to any newly invited members.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to clone and archive.
     * @param callback
     */
    public void createChild(@NonNull String channelId, Callback<GroupCreateResponse> callback){
        service.groupsCreateChild(channelId).enqueue(callback);
    }

    /**
     * This method returns a portion of messages/events from the specified private channel.
     * To read the entire history for a private channel, call the method with no latest or
     * oldest arguments, and then continue paging using the instructions below.
     *
     * Requires scope: groups:history
     *
     * @param channelId Private channel to fetch history for.
     * @param callback
     */
    public void history(@NonNull String channelId, Callback<HistoryResponse> callback){
        history(channelId, null, callback);
    }

    /**
     * This method returns a portion of messages/events from the specified private channel.
     * To read the entire history for a private channel, call the method with no latest or
     * oldest arguments, and then continue paging using the instructions below.
     *
     * Requires scope: groups:history
     *
     * @param channelId Private channel to fetch history for.
     * @param params
     * @param callback
     */
    public void history(@NonNull String channelId, HistoryParams params, Callback<HistoryResponse> callback){
        service.groupsHistory(channelId, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method returns information about a private channel.
     *
     * Requires scope: groups:read
     *
     * @param channelId Private channel to get info on
     * @param callback
     */
    public void info(@NonNull String channelId, Callback<GroupCreateResponse> callback){
        service.groupsInfo(channelId).enqueue(callback);
    }

    /**
     * This method is used to invite a user to a private channel. The calling user must be a member
     * of the private channel.
     *
     * To invite a new member to a private channel without giving them access to the archives of
     * the private channel, call the groups.createChild method before inviting.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to invite user to.
     * @param userId User to invite.
     * @param callback
     */
    public void invite(@NonNull String channelId, @NonNull String userId, Callback<GroupCreateResponse> callback){
        service.groupsInvite(channelId, userId).enqueue(callback);
    }

    /**
     * This method allows a user to remove another member from a private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to remove user from.
     * @param userId User to remove from private channel.
     * @param callback
     */
    public void kick(@NonNull String channelId, @NonNull String userId, Callback<BaseResponse> callback){
        service.groupsKick(channelId, userId).enqueue(callback);
    }

    /**
     * This method is used to leave a private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to leave
     * @param callback
     */
    public void leave(@NonNull String channelId, Callback<BaseResponse> callback){
        service.groupsLeave(channelId).enqueue(callback);
    }

    /**
     * This method returns a list of private channels in the team that the caller is in and
     * archived groups that the caller was in. The list of (non-deactivated) members in each
     * private channel is also returned.
     *
     * Requires scope: groups:read
     *
     * @param callback
     */
    public void list(Callback<GroupListResponse> callback){
        list(null, callback);
    }

    /**
     * This method returns a list of private channels in the team that the caller is in and
     * archived groups that the caller was in. The list of (non-deactivated) members in each
     * private channel is also returned.
     *
     * Requires scope: groups:read
     *
     * @param params
     * @param callback
     */
    public void list(GroupListParams params, Callback<GroupListResponse> callback){
        service.groupsList(verifyParams(params)).enqueue(callback);
    }

    /**
     * This method moves the read cursor in a private channel.
     *
     * Requires scope: groups:read
     *
     * @param channelId Private channel to set reading cursor in.
     * @param ts Timestamp of the most recently seen message.
     * @param callback
     */
    public void mark(@NonNull String channelId, @NonNull String ts, Callback<BaseResponse> callback){
        service.groupsMark(channelId, ts).enqueue(callback);
    }

    /**
     * This method opens a private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to open.
     * @param callback
     */
    public void open(@NonNull String channelId, Callback<BaseResponse> callback){
        service.groupsOpen(channelId).enqueue(callback);
    }

    /**
     * This method renames a private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to rename
     * @param name New name for private channel.
     * @param callback
     */
    public void rename(@NonNull String channelId, @NonNull String name, Callback<GroupCreateResponse> callback){
        service.groupsRename(channelId, name).enqueue(callback);
    }

    /**
     * This method is used to change the purpose of a private channel. The calling user must be a
     * member of the private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to set the purpose of
     * @param purpose The new purpose
     * @param callback
     */
    public void setPurpose(@NonNull String channelId, @NonNull String purpose, Callback<ChannelPurposeResponse> callback){
        service.groupsSetPurpose(channelId, purpose).enqueue(callback);
    }

    /**
     * This method is used to change the topic of a private channel. The calling user must be a
     * member of the private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to set the topic of
     * @param topic The new topic
     * @param callback
     */
    public void setTopic(@NonNull String channelId, @NonNull String topic, Callback<ChannelTopicResponse> callback){
        service.groupsSetTopic(channelId, topic).enqueue(callback);
    }

    /**
     * This method unarchives a private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to unarchive
     * @param callback
     */
    public void unarchive(@NonNull String channelId, Callback<BaseResponse> callback){
        service.groupsUnarchive(channelId).enqueue(callback);
    }
}
