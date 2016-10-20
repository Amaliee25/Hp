package slack.android.api.webapi;

import android.support.annotation.NonNull;

import java.io.File;
import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import slack.android.api.webapi.params.ApiTestParams;
import slack.android.api.webapi.params.AuthRevokeParams;
import slack.android.api.webapi.params.BotsInfoParams;
import slack.android.api.webapi.params.ChannelCreateParams;
import slack.android.api.webapi.params.ChannelListParams;
import slack.android.api.webapi.params.ChatParams;
import slack.android.api.webapi.params.ChatPostParams;
import slack.android.api.webapi.params.ChatUpdateParams;
import slack.android.api.webapi.params.DndInfoParams;
import slack.android.api.webapi.params.DndTeamInfoParams;
import slack.android.api.webapi.params.FileCommentAddParams;
import slack.android.api.webapi.params.FileInfoParams;
import slack.android.api.webapi.params.FileListParams;
import slack.android.api.webapi.params.FileUploadParams;
import slack.android.api.webapi.params.GroupListParams;
import slack.android.api.webapi.params.HistoryParams;
import slack.android.api.webapi.params.ImOpenParams;
import slack.android.api.webapi.params.PinAddParams;
import slack.android.api.webapi.params.PinRemoveParams;
import slack.android.api.webapi.params.ReactionAddParams;
import slack.android.api.webapi.params.ReactionGetParams;
import slack.android.api.webapi.params.ReactionListParams;
import slack.android.api.webapi.params.ReactionRemoveParams;
import slack.android.api.webapi.params.ReminderAddParams;
import slack.android.api.webapi.params.RtmStartParams;
import slack.android.api.webapi.params.SearchParams;
import slack.android.api.webapi.params.StarAddParams;
import slack.android.api.webapi.params.StarListParams;
import slack.android.api.webapi.params.StarRemoveParams;
import slack.android.api.webapi.params.TeamAccessLogParams;
import slack.android.api.webapi.params.TeamBillableInfoParams;
import slack.android.api.webapi.params.TeamIntegrationLogsParams;
import slack.android.api.webapi.params.TeamProfileGetParams;
import slack.android.api.webapi.params.UserListParams;
import slack.android.api.webapi.params.UserProfileGetParams;
import slack.android.api.webapi.params.UserProfileSetParams;
import slack.android.api.webapi.params.UserSetPhotoParams;
import slack.android.api.webapi.params.UsergroupCreateParams;
import slack.android.api.webapi.params.UsergroupDisableParams;
import slack.android.api.webapi.params.UsergroupEnableParams;
import slack.android.api.webapi.params.UsergroupUpdateParams;
import slack.android.api.webapi.params.UsergroupUserUpdateParams;
import slack.android.api.webapi.params.UsergroupUsersListParams;
import slack.android.api.webapi.params.UsergroupsListParams;
import slack.android.api.webapi.response.AccessLogResponse;
import slack.android.api.webapi.response.ApiTestResponse;
import slack.android.api.webapi.response.AuthRevokeResponse;
import slack.android.api.webapi.response.AuthTestResponse;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.BotsInfoResponse;
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
import slack.android.api.webapi.response.FileCommentResponse;
import slack.android.api.webapi.response.FileInfoResponse;
import slack.android.api.webapi.response.FileListResponse;
import slack.android.api.webapi.response.FileResponse;
import slack.android.api.webapi.response.GroupCloseResponse;
import slack.android.api.webapi.response.GroupCreateResponse;
import slack.android.api.webapi.response.GroupListResponse;
import slack.android.api.webapi.response.HistoryResponse;
import slack.android.api.webapi.response.ImListResponse;
import slack.android.api.webapi.response.ImOpenResponse;
import slack.android.api.webapi.response.MpimCreateResponse;
import slack.android.api.webapi.response.PinListResponse;
import slack.android.api.webapi.response.ReactionGetResponse;
import slack.android.api.webapi.response.ReactionListResponse;
import slack.android.api.webapi.response.ReminderAddResponse;
import slack.android.api.webapi.response.ReminderListResponse;
import slack.android.api.webapi.response.RtmStartResponse;
import slack.android.api.webapi.response.SearchAllResponse;
import slack.android.api.webapi.response.SearchFilesResponse;
import slack.android.api.webapi.response.SearchMessagesResponse;
import slack.android.api.webapi.response.StarListResponse;
import slack.android.api.webapi.response.TeamBillableInfoResponse;
import slack.android.api.webapi.response.TeamInfoResponse;
import slack.android.api.webapi.response.TeamIntegrationLogsResponse;
import slack.android.api.webapi.response.TeamProfileGetResponse;
import slack.android.api.webapi.response.UserGetPresenceResponse;
import slack.android.api.webapi.response.UserIdentityResponse;
import slack.android.api.webapi.response.UserInfoResponse;
import slack.android.api.webapi.response.UserListResponse;
import slack.android.api.webapi.response.UserProfileResponse;
import slack.android.api.webapi.response.UsergroupListResponse;
import slack.android.api.webapi.response.UsergroupResponse;
import slack.android.api.webapi.response.UsergroupUserListResponse;

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
    public void getChannelsHistory(@NonNull String channelId, @NonNull HistoryParams params, Callback<HistoryResponse> callback){
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

    /**
     * Add a comment to an existing file.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File to add a comment to.
     * @param comment Text of the comment to add.
     * @param params
     * @param callback
     */
    public void getFileCommentAdd(@NonNull String fileId, @NonNull String comment, @NonNull FileCommentAddParams params, Callback<FileCommentResponse> callback){
        service.filesCommentsAdd(fileId, comment, params.build()).enqueue(callback);
    }

    /**
     * Delete an existing comment on a file. Only the original author of the comment or a Team Administrator may delete a file comment.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File to delete a comment from.
     * @param commentId The comment to delete.
     * @param callback
     */
    public void getFileCommentDelete(@NonNull String fileId, @NonNull String commentId, Callback<BaseResponse> callback){
        service.filesCommentsDelete(fileId, commentId).enqueue(callback);
    }

    /**
     * Edit an existing comment on a file. Only the user who created a comment may make edits. Teams may configure a limited time window during which file comment edits are allowed.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File containing the comment to edit.
     * @param commentId The comment to edit.
     * @param comment Text of the comment to edit.
     * @param callback
     */
    public void getFileCommentEdit(@NonNull String fileId, @NonNull String commentId, @NonNull String comment, Callback<FileCommentResponse> callback){
        service.filesCommentsEdit(fileId, commentId, comment).enqueue(callback);
    }

    /**
     * This method deletes a file from your team.
     *
     * Requires scope: files:write:user
     *
     * @param fileId ID of file to delete.
     * @param callback
     */
    public void getFilesDelete(@NonNull String fileId, Callback<BaseResponse> callback){
        service.filesDelete(fileId).enqueue(callback);
    }

    /**
     * This method returns information about a file in your team.
     *
     * Requires scope: files:read
     *
     * @param fileId Specify a file by providing its ID.
     * @param params
     * @param callback
     */
    public void getFilesInfo(@NonNull String fileId, @NonNull FileInfoParams params, Callback<FileInfoResponse> callback){
        service.filesInfo(fileId, params.build()).enqueue(callback);
    }

    /**
     * This method returns a list of files within the team. It can be filtered and sliced in various ways.
     *
     * Requires scope: files:read
     *
     * @param params
     * @param callback
     */
    public void getFilesList(@NonNull FileListParams params, Callback<FileListResponse> callback){
        service.filesList(params.build()).enqueue(callback);
    }

    /**
     * This method disables public/external sharing for a file.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File to revoke
     * @param callback
     */
    public void getFilesRevokePublicUrl(@NonNull String fileId, Callback<FileResponse> callback){
        service.filesRevokePublicUrl(fileId).enqueue(callback);
    }

    /**
     * This method enables public/external sharing for a file.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File to share
     * @param callback
     */
    public void getFilesSharedPublicUrl(@NonNull String fileId, Callback<FileInfoResponse> callback){
        service.filesSharedPublicUrl(fileId).enqueue(callback);
    }

    /**
     * This method allows you to create or upload an existing file.
     *
     * Requires scope: files:write:user
     *
     * @param filename Filename of file.
     * @param params
     * @param callback
     */
    public void getFilesUpload(@NonNull String filename, @NonNull FileUploadParams params, Callback<FileResponse> callback){
        service.filesUpload(filename, params.build()).enqueue(callback);
    }

    /**
     * This method archives a private channel.
     *
     * Requires scope: groups:write
     *
     * @param channelId Private channel to archive
     * @param callback
     */
    public void getGroupsArchive(@NonNull String channelId, Callback<BaseResponse> callback){
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
    public void getGroupsClose(@NonNull String channelId, Callback<GroupCloseResponse> callback){
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
    public void getGroupsCreate(@NonNull String name, Callback<GroupCreateResponse> callback){
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
    public void getGroupsCreateChild(@NonNull String channelId, Callback<GroupCreateResponse> callback){
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
     * @param params
     * @param callback
     */
    public void getGroupsHistory(@NonNull String channelId, @NonNull HistoryParams params, Callback<HistoryResponse> callback){
        service.groupsHistory(channelId, params.build()).enqueue(callback);
    }

    /**
     * This method returns information about a private channel.
     *
     * Requires scope: groups:read
     *
     * @param channelId Private channel to get info on
     * @param callback
     */
    public void getGroupsInfo(@NonNull String channelId, Callback<GroupCreateResponse> callback){
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
    public void getGroupsInvite(@NonNull String channelId, @NonNull String userId, Callback<GroupCreateResponse> callback){
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
    public void getGroupsKick(@NonNull String channelId, @NonNull String userId, Callback<BaseResponse> callback){
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
    public void getGroupsLeave(@NonNull String channelId, Callback<BaseResponse> callback){
        service.groupsLeave(channelId).enqueue(callback);
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
    public void getGroupsList(@NonNull GroupListParams params, Callback<GroupListResponse> callback){
        service.groupsList(params.build()).enqueue(callback);
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
    public void getGroupsMark(@NonNull String channelId, @NonNull String ts, Callback<BaseResponse> callback){
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
    public void getGroupsOpen(@NonNull String channelId, Callback<BaseResponse> callback){
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
    public void getGroupsRename(@NonNull String channelId, @NonNull String name, Callback<GroupCreateResponse> callback){
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
    public void getGroupsSetPurpose(@NonNull String channelId, @NonNull String purpose, Callback<ChannelPurposeResponse> callback){
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
    public void getGroupsSetTopic(@NonNull String channelId, @NonNull String topic, Callback<ChannelTopicResponse> callback){
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
    public void getGroupsUnarchive(@NonNull String channelId, Callback<BaseResponse> callback){
        service.groupsUnarchive(channelId).enqueue(callback);
    }

    /**
     * This method closes a direct message channel.
     *
     * Requires scope: im:write
     *
     * @param channelId Direct message channel to close.
     * @param callback
     */
    public void getImClose(@NonNull String channelId, Callback<BaseResponse> callback){
        service.imClose(channelId).enqueue(callback);
    }

    /**
     * This method returns a portion of messages/events from the specified direct message channel.
     * To read the entire history for a direct message channel, call the method with no latest or
     * oldest arguments, and then continue paging using the instructions below.
     *
     * Requires scope: im:history
     *
     * @param channelId Direct message channel to fetch history for.
     * @param params
     * @param callback
     */
    public void getImHistory(@NonNull String channelId, @NonNull HistoryParams params, Callback<HistoryResponse> callback){
        service.imHistory(channelId, params.build()).enqueue(callback);
    }

    /**
     * This method returns a list of all im channels that the user has.
     *
     * Requires scope: im:read
     *
     * @param callback
     */
    public void getImList(Callback<ImListResponse> callback){
        service.imList().enqueue(callback);
    }

    /**
     * This method moves the read cursor in a direct message channel.
     *
     * Requires scope: im:write
     *
     * @param channelId Direct message channel to set reading cursor in.
     * @param ts Timestamp of the most recently seen message.
     * @param callback
     */
    public void getImMark(@NonNull String channelId, @NonNull String ts, Callback<BaseResponse> callback){
        service.imMark(channelId, ts).enqueue(callback);
    }

    /**
     * This method opens a direct message channel with another member of your Slack team.
     *
     * If the return_im argument was passed, the channel object will contain the
     * full channel definition:
     *
     * Requires scope: im:write
     *
     * @param userId User to open a direct message channel with.
     * @param params
     * @param callback
     */
    public void getImOpen(@NonNull String userId, @NonNull ImOpenParams params, Callback<ImOpenResponse> callback){
        service.imOpen(userId, params.build()).enqueue(callback);
    }

    /**
     * This method closes a multiparty direct message channel.
     *
     * Requires scope: mpim:write
     *
     * @param channelId MPIM to close.
     * @param callback
     */
    public void getMpimClose(@NonNull String channelId, Callback<BaseResponse> callback){
        service.mpimClose(channelId).enqueue(callback);
    }

    /**
     * This method returns a portion of messages/events from the specified multiparty direct
     * message channel. To read the entire history for a multiparty direct message, call the
     * method with no latest or oldest arguments, and then continue paging using the
     * instructions below.
     *
     * Requires scope: mpim:history
     *
     * @param channelId Multiparty direct message to fetch history for.
     * @param params
     * @param callback
     */
    public void getMpimHistory(@NonNull String channelId, @NonNull HistoryParams params, Callback<HistoryResponse> callback){
        service.mpimHistory(channelId, params.build()).enqueue(callback);
    }

    /**
     * This method returns a list of all multiparty direct message channels that the user has.
     *
     * Requires scope: mpim:read
     *
     * @param callback
     */
    public void getMpimList(Callback<GroupListResponse> callback){
        service.mpimList().enqueue(callback);
    }

    /**
     * This method moves the read cursor in a multiparty direct message channel.
     *
     * Requires scope: mpim:write
     *
     * @param channelId multiparty direct message channel to set reading cursor in.
     * @param ts Timestamp of the most recently seen message.
     * @param callback
     */
    public void getMpimMark(@NonNull String channelId, @NonNull String ts, Callback<BaseResponse> callback){
        service.mpimMark(channelId, ts).enqueue(callback);
    }

    /**
     * This method opens a multiparty direct message.
     * Opening a multiparty direct message takes a list of up-to 8 encoded user ids. If there is
     * no MPIM already created that includes that exact set of members, a new MPIM will be created.
     * Subsequent calls to mpim.open with the same set of users will return the already existing
     * MPIM conversation.
     *
     * Requires scope: mpim:write
     *
     * @param users Comma separated lists of users. The ordering of the users is preserved whenever
     *              a MPIM group is returned.
     *
     * @param callback
     */
    public void getMpimOpen(@NonNull String users, Callback<MpimCreateResponse> callback){
        service.mpimOpen(users).enqueue(callback);
    }

    /**
     * This method pins an item (file, file comment, channel message, or group message) to a
     * particular channel. The channel argument is required and one of file, file_comment,
     * or timestamp must also be specified.
     *
     * Requires scope: pins:write
     *
     * @param channelId Channel to pin the item in.
     * @param params
     * @param callback
     */
    public void getPinsAdd(@NonNull String channelId, @NonNull PinAddParams params, Callback<BaseResponse> callback){
        service.pinsAdd(channelId, params.build()).enqueue(callback);
    }

    /**
     * This method lists the items pinned to a channel.
     *
     * Requires scope: pins:read
     *
     * @param channelId Channel to get pinned items for.
     * @param callback
     */
    public void getPinList(@NonNull String channelId, Callback<PinListResponse> callback){
        service.pinsList(channelId).enqueue(callback);
    }

    /**
     * This method un-pins an item (file, file comment, channel message, or group message) from a
     * channel. The channel argument is required and one of file, file_comment, or timestamp must
     * also be specified.
     *
     * Requires scope: pins:write
     *
     * @param channelId Channel where the item is pinned to.
     * @param params
     * @param callback
     */
    public void getPinsRemove(@NonNull String channelId, @NonNull PinRemoveParams params, Callback<BaseResponse> callback){
        service.pinsRemove(channelId, params.build()).enqueue(callback);
    }

    /**
     * This method adds a reaction (emoji) to an item (file, file comment, channel message,
     * group message, or direct message). One of file, file_comment, or the combination of
     * channel and timestamp must be specified.
     *
     * Requires scope: reactions:write
     *
     * @param name Reaction (emoji) name.
     * @param params
     * @param callback
     */
    public void getReactionAdd(@NonNull String name, @NonNull ReactionAddParams params, Callback<BaseResponse> callback){
        service.reactionsAdd(name, params.build()).enqueue(callback);
    }

    /**
     * This method returns a list of all reactions for a single item (file, file comment,
     * channel message, group message, or direct message).
     *
     * Requires scope: reactions:read
     *
     * @param params
     * @param callback
     */
    public void getReactionGet(@NonNull ReactionGetParams params, Callback<ReactionGetResponse> callback){
        service.reactionsGet(params.build()).enqueue(callback);
    }

    /**
     * This method returns a list of all items (file, file comment, channel message, group message,
     * or direct message) reacted to by a user.
     *
     * Requires scope: reactions:read
     *
     * @param params
     * @param callback
     */
    public void getReactionList(@NonNull ReactionListParams params, Callback<ReactionListResponse> callback){
        service.reactionsList(params.build()).enqueue(callback);
    }

    /**
     * This method removes a reaction (emoji) from an item (file, file comment, channel message,
     * group message, or direct message). One of file, file_comment, or the combination of channel
     * and timestamp must be specified.
     *
     * Requires scope: reactions:write
     *
     * @param name Reaction (emoji) name.
     * @param params
     * @param callback
     */
    public void getReactionRemove(@NonNull String name, @NonNull ReactionRemoveParams params, Callback<BaseResponse> callback){
        service.reactionsRemove(name, params.build()).enqueue(callback);
    }

    /**
     * This method creates a reminder.
     *
     * Requires scope: reminders:write
     *
     * @param text The content of the reminder
     * @param time When this reminder should happen: the Unix timestamp (up to five years from now),
     *             the number of seconds until the reminder (if within 24 hours), or a natural language
     *             description (Ex. "in 15 minutes," or "every Thursday")
     * @param params
     * @param callback
     */
    public void getRemindersAdd(@NonNull String text, @NonNull String time, @NonNull ReminderAddParams params, Callback<ReminderAddResponse> callback){
        service.remindersAdd(text, time, params.build()).enqueue(callback);
    }

    /**
     * This method completes a reminder.
     *
     * Requires scope: reminders:write
     *
     * @param reminderId The ID of the reminder to be marked as complete
     */
    public void getRemindersComplete(@NonNull String reminderId, Callback<BaseResponse> callback){
        service.remindersComplete(reminderId).enqueue(callback);
    }

    /**
     * This method deletes a reminder.
     *
     * Requires scope: reminders:write
     *
     * @param reminderId The ID of the reminder
     * @param callback
     */
    public void getRemindersDelete(@NonNull String reminderId, Callback<BaseResponse> callback){
        service.remindersDelete(reminderId).enqueue(callback);
    }

    /**
     * This method returns information about a reminder.
     *
     * Requires scope: reminders:read
     *
     * @param reminderId The ID of the reminder
     * @param callback
     */
    public void getRemindersInfo(@NonNull String reminderId, Callback<ReminderAddResponse> callback){
        service.remindersInfo(reminderId).enqueue(callback);
    }

    /**
     * This method lists all reminders created by or for a given user.
     *
     * Requires scope: reminders:read
     *
     * @param callback
     */
    public void getRemindersList(Callback<ReminderListResponse> callback){
        service.remindersList().enqueue(callback);
    }

    /**
     * This method starts a Real Time Messaging API session.
     *
     * Requires scope: client
     *
     * @param params
     * @param callback
     */
    public void getRtmStart(@NonNull RtmStartParams params, Callback<RtmStartResponse> callback){
        service.rtmStart(params.build()).enqueue(callback);
    }

    /**
     * This method allows users and applications to search both messages and files in a single call.
     *
     * Requires scope: search:read
     *
     * @param query Search query. May contains booleans, etc.
     * @param params
     * @param callback
     */
    public void getSearchAll(@NonNull String query, @NonNull SearchParams params, Callback<SearchAllResponse> callback){
        service.searchAll(query, params.build()).enqueue(callback);
    }

    /**
     * This method returns files matching a search query.
     *
     * Requires scope: search:read
     *
     * @param query Search query. May contains booleans, etc.
     * @param params
     * @param callback
     */
    public void getSearchFiles(@NonNull String query, @NonNull SearchParams params, Callback<SearchFilesResponse> callback){
        service.searchFiles(query, params.build()).enqueue(callback);
    }

    /**
     * This method returns messages matching a search query.
     *
     * Requires scope: search:read
     *
     * @param query Search query. May contains booleans, etc.
     * @param params
     * @param callback
     */
    public void getSearchMessages(@NonNull String query, @NonNull SearchParams params, Callback<SearchMessagesResponse> callback){
        service.searchMessages(query, params.build()).enqueue(callback);
    }

    /**
     * This method adds a star to an item (message, file, file comment, channel, private group, or DM)
     * on behalf of the authenticated user. One of file, file_comment, channel, or the combination of
     * channel and timestamp must be specified.
     *
     * Requires scope: stars:write
     *
     * @param params
     * @param callback
     */
    public void getStarsAdd(@NonNull StarAddParams params, Callback<BaseResponse> callback){
        service.starsAdd(params.build()).enqueue(callback);
    }

    /**
     * This method lists the items starred by the authed user.
     *
     * Requires scope: stars:read
     *
     * @param params
     * @param callback
     */
    public void getStarsList(@NonNull StarListParams params, Callback<StarListResponse> callback){
        service.starsList(params.build()).enqueue(callback);
    }

    /**
     * This method removes a star from an item (message, file, file comment, channel, private group,
     * or DM) on behalf of the authenticated user. One of file, file_comment, channel, or the
     * combination of channel and timestamp must be specified.
     *
     * Requires scope: stars:write
     *
     * @param params
     * @param callback
     */
    public void getStarsRemove(@NonNull StarRemoveParams params, Callback<BaseResponse> callback){
        service.starsRemove(params.build()).enqueue(callback);
    }

    /**
     * This method is used to get the access logs for users on a team.
     *
     * Requires scope: admin
     *
     * @param params
     * @param callback
     */
    public void getTeamAccessLogs(@NonNull TeamAccessLogParams params, Callback<AccessLogResponse> callback){
        service.teamAccessLogs(params.build()).enqueue(callback);
    }

    /**
     * This method lists billable information for each user on the team. Currently this consists
     * solely of whether the user is subject to billing per Slack's Fair Billing policy.
     *
     * Requires scope: admin
     *
     * @param params
     * @param callback
     */
    public void getTeamBillableInfo(@NonNull TeamBillableInfoParams params, Callback<TeamBillableInfoResponse> callback){
        service.teamBillableInfo(params.build()).enqueue(callback);
    }

    /**
     * This method provides information about your team.
     *
     * Requires scope: team:read
     *
     * @param callback
     */
    public void getTeamInfo(Callback<TeamInfoResponse> callback){
        service.teamInfo().enqueue(callback);
    }

    /**
     * This method lists the integration activity logs for a team, including when integrations are
     * added, modified and removed. This method can only be called by Admins.
     *
     * Requires scope: admin
     *
     * @param params
     * @param callback
     */
    public void getTeamIntegrationLogs(@NonNull TeamIntegrationLogsParams params, Callback<TeamIntegrationLogsResponse> callback){
        service.teamIntegrationLogs(params.build()).enqueue(callback);
    }

    /**
     * This method is used to get the profile field definitions for this team.
     *
     * Requires scope: users.profile:get
     *
     * @param params
     * @param callback
     */
    public void getTeamProfile(@NonNull TeamProfileGetParams params, Callback<TeamProfileGetResponse> callback){
        service.teamProfileGet(params.build()).enqueue(callback);
    }

    /**
     * This method is used to create a User Group.
     *
     * Requires scope: usergroups:write
     *
     * @param name A name for the User Group. Must be unique among User Groups.
     * @param params
     * @param callback
     */
    public void getUsergroupCreate(@NonNull String name, @NonNull UsergroupCreateParams params, Callback<UsergroupResponse> callback){
        service.usergroupsCreate(name, params.build()).enqueue(callback);
    }

    /**
     * This method disables an existing User Group.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to disable.
     * @param params
     * @param callback
     */
    public void getUsergroupDisable(@NonNull String usergroupId, @NonNull UsergroupDisableParams params, Callback<UsergroupResponse> callback){
        service.usergroupsDisable(usergroupId, params.build()).enqueue(callback);
    }

    /**
     * This method enables a User Group which was previously disabled.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to enable.
     * @param params
     * @param callback
     */
    public void getUsergroupEnable(@NonNull String usergroupId, @NonNull UsergroupEnableParams params, Callback<UsergroupResponse> callback){
        service.usergroupsEnable(usergroupId, params.build()).enqueue(callback);
    }

    /**
     * This method returns a list of all User Groups in the team. This can optionally include
     * disabled User Groups.
     *
     * Requires scope: usergroups:read
     *
     * @param params
     * @param callback
     */
    public void getUsergroupList(@NonNull UsergroupsListParams params, Callback<UsergroupListResponse> callback) {
        service.usergroupsList(params.build()).enqueue(callback);
    }

    /**
     * This method updates the properties of an existing User Group.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to update.
     * @param params
     * @param callback
     */
    public void getUsergroupUpdate(@NonNull String usergroupId, @NonNull UsergroupUpdateParams params, Callback<UsergroupResponse> callback){
        service.usergroupsUpdate(usergroupId, params.build()).enqueue(callback);
    }

    /**
     * This method returns a list of all users within a User Group.
     *
     * Requires scope: usergroups:read
     *
     * @param usergroupId The encoded ID of the User Group to update.
     * @param params
     * @param callback
     */
    public void getUsergroupUserList(@NonNull String usergroupId, @NonNull UsergroupUsersListParams params, Callback<UsergroupUserListResponse> callback){
        service.usergroupsUsersList(usergroupId, params.build()).enqueue(callback);
    }

    /**
     * This method updates the list of users that belong to a User Group. This method replaces all
     * users in a User Group with the list of users provided in the users parameter.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to update.
     * @param users A comma separated string of encoded user IDs that represent the entire list of
     *              users for the User Group.
     * @param params
     * @param callback
     */
    public void getUsergroupUserUpdate(@NonNull String usergroupId, @NonNull String users, @NonNull UsergroupUserUpdateParams params, Callback<UsergroupResponse> callback){
        service.usergroupsUsersUpdate(usergroupId, users, params.build()).enqueue(callback);
    }

    /**
     * This method allows the user to delete their profile image. It will clear whatever image is currently set.
     *
     * To upload a new profile image, use the companion method users.setPhoto.
     *
     * Requires scope: users.profile:write
     *
     * @param callback
     */
    public void getUserDeletePhoto(Callback<BaseResponse> callback){
        service.usersDeletePhoto().enqueue(callback);
    }

    /**
     * This method lets you find out information about a user's presence.
     *
     * Requires scope: users:read
     *
     * @param userId User to get presence info on. Defaults to the authed user.
     * @param callback
     */
    public void getUserPresence(@NonNull String userId, Callback<UserGetPresenceResponse> callback){
       service.usersGetPresence(userId).enqueue(callback);
    }

    /**
     * After your Slack app is awarded an identity token through Sign in with Slack, use this
     * method to retrieve a user's identity.
     *
     * The returned fields depend on any additional authorization scopes you've requested.
     *
     * This method may only be used by tokens with the identity.basic scope, as provided in the
     * Sign in with Slack process.
     *
     * @param callback
     */
    public void getUserIdentity(Callback<UserIdentityResponse> callback){
        service.usersIdentify().enqueue(callback);
    }

    /**
     * This method returns information about a team member.
     *
     * Requires scope: users:read
     *
     * @param userId User to get info on
     * @param callback
     */
    public void getUserInfo(@NonNull String userId, Callback<UserInfoResponse> callback){
        service.usersInfo(userId).enqueue(callback);
    }

    /**
     * This method returns a list of all users in the team. This includes deleted/deactivated users.
     *
     * Requires scope: users:read
     *
     * @param params
     * @param callback
     */
    public void getUserList(@NonNull UserListParams params, Callback<UserListResponse> callback){
        service.usersList(params.build()).enqueue(callback);
    }

    /**
     * This method lets the slack messaging server know that the authenticated user is currently active.
     *
     * Requires scope: users:write
     *
     * @param callback
     */
    public void getUserSetActive(Callback<BaseResponse> callback){
        service.usersSetActive().enqueue(callback);
    }

    /**
     * This method allows the user to set their profile image. The caller can pass image data via
     * image.
     *
     * Providing a "crop box" with crop_x, crop_y, and crop_w is optional. Otherwise, the whole
     * image will be used. If cropping instructions are not specified and the source image is not
     * square, the image will be letterboxed, just like your favorite old laserdiscs.
     *
     * Please limit your images to a maximum size of 1024 by 1024 pixels. 512x512 pixels is the
     * minimum.
     *
     * To remove a profile image, use the companion method users.deletePhoto.
     *
     * Requires scope: users.profile:write
     *
     * @param imageContentType When providing the image parameter, provide your image data directly
     *                         but present its correct Content-type, such as image/gif, image/jpeg, image/png, etc.
     * @param file Image file
     * @param params
     * @param callback
     */
    public void getUserSetPhoto(@NonNull String imageContentType, @NonNull File file, @NonNull UserSetPhotoParams params, Callback<BaseResponse> callback){
        RequestBody body = RequestBody.create(MediaType.parse(imageContentType), file);

        service.usersSetPhoto(body, params.build()).enqueue(callback);
    }

    /**
     * This method lets you set the calling user's manual presence.
     *
     * Requires scope: users:write
     *
     * @param presence Either auto or away
     * @param callback
     */
    public void getUserSetPresence(@NonNull String presence, Callback<BaseResponse> callback){
        service.usersSetPresence(presence).enqueue(callback);
    }

    /**
     * This method is used to get the profile information for a user.
     *
     * Requires scope: users.profile:read
     *
     * @param params
     * @param callback
     */
    public void getUserProfile(@NonNull UserProfileGetParams params, Callback<UserProfileResponse> callback){
        service.usersProfileGet(params.build()).enqueue(callback);
    }

    /**
     * This method is used to set the profile information for a user.
     *
     * Requires scope: users.profile:write
     *
     * @param params
     * @param callback
     */
    public void getUserProfileSet(@NonNull UserProfileSetParams params, Callback<UserProfileResponse> callback){
        service.usersProfileSet(params.build()).enqueue(callback);
    }
}
