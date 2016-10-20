package slack.android.api.webapi;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import slack.android.api.webapi.params.SlackParamsConstants;
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
import slack.android.api.webapi.response.OauthAccessResponse;
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

public interface SlackWebApiInterface {

    // api
    @GET(SlackWebApiConstants.API_TEST)
    Call<ApiTestResponse> apiTest(@QueryMap Map<String, String> params);

    // auth
    @GET(SlackWebApiConstants.AUTH_REVOKE)
    Call<AuthRevokeResponse> authRevoke(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.AUTH_TEST)
    Call<AuthTestResponse> authTest();

    // bots
    @GET(SlackWebApiConstants.BOTS_INFO)
    Call<BotsInfoResponse> botInfo(@QueryMap Map<String, String> params);

    // channels
    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_ARCHIVE)
    Call<BaseResponse> channelsArchive(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_CREATE)
    Call<ChannelResponse> channelsCreate(@Field(SlackParamsConstants.NAME) String name, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.CHANNELS_HISTORY)
    Call<HistoryResponse> channelsHistory(@Field(SlackParamsConstants.CHANNEL) String channelId, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.CHANNELS_INFO)
    Call<ChannelResponse> channelsInfo(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_INVITE)
    Call<ChannelResponse> channelsInvite(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.USER) String user);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_JOIN)
    Call<ChannelResponse> channelsJoin(@Field(SlackParamsConstants.NAME) String name);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_KICK)
    Call<BaseResponse> channelsKick(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.USER) String user);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_LEAVE)
    Call<BaseResponse> channelsLeave(@Field(SlackParamsConstants.CHANNEL) String channel);

    @GET(SlackWebApiConstants.CHANNELS_LIST)
    Call<ChannelListResponse> channelsList(@QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_MARK)
    Call<BaseResponse> channelsMark(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.TS) String ts);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_RENAME)
    Call<ChannelResponse> channelsRename(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.NAME) String name);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_SET_PURPOSE)
    Call<ChannelPurposeResponse> channelsSetPurpose(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.PURPOSE) String purpose);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_SET_TOPIC)
    Call<ChannelTopicResponse> channelsSetTopic(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.TOPIC) String topic);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_UNARCHIVE)
    Call<BaseResponse> channelsUnarchive(@Field(SlackParamsConstants.CHANNEL) String channelId);

    // chat
    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHAT_DELETE)
    Call<ChatResponse> chatDelete(@Field(SlackParamsConstants.TS) String ts, @Field(SlackParamsConstants.CHANNEL) String channelId, @QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHAT_ME_MESSAGE)
    Call<ChatResponse> chatMeMessage(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.TEXT) String text);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHAT_POST_MESSAGE)
    Call<ChatPostResponse> chatPostMessage(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.TEXT) String text, @QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHAT_UPDATE)
    Call<ChatUpdateResponse> chatUpdate(@Field(SlackParamsConstants.TS) String ts, @Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.TEXT) String text, @QueryMap Map<String, String> params);

    // dnd (Do Not Disturb)
    @FormUrlEncoded
    @POST(SlackWebApiConstants.DND_END_DND)
    Call<BaseResponse> dndEndDnd();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.DND_END_SNOOZE)
    Call<DndEndSnoozeResponse> dndEndSnooze();

    @GET(SlackWebApiConstants.DND_INFO)
    Call<DndInfoResponse> dndInfo(@QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.DND_SET_SNOOZE)
    Call<DndSetSnoozeResponse> dndSetSnooze(@Field(SlackParamsConstants.NUM_MINUTES) String numMinutes);

    @GET(SlackWebApiConstants.DND_TEAM_INFO)
    Call<DndTeamInfoResponse> dndTeamInfo(@QueryMap Map<String, String> params);

    // emoji
    @GET(SlackWebApiConstants.EMOJI_LIST)
    Call<EmojiListResponse> emojList();

    // files.comments
    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_COMMENTS_ADD)
    Call<FileCommentResponse> filesCommentsAdd(@Field(SlackParamsConstants.FILE) String file, @Field(SlackParamsConstants.COMMENT) String comment, @QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_COMMENTS_DELETE)
    Call<BaseResponse> filesCommentsDelete(@Field(SlackParamsConstants.FILE) String file, @Field(SlackParamsConstants.ID) String id);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_COMMENTS_EDIT)
    Call<FileCommentResponse> filesCommentsEdit(@Field(SlackParamsConstants.FILE) String file, @Field(SlackParamsConstants.ID) String id, @Field(SlackParamsConstants.COMMENT) String comment);

    // files
    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_DELETE)
    Call<BaseResponse> filesDelete(@Field(SlackParamsConstants.FILE) String file);

    @GET(SlackWebApiConstants.FILES_INFO)
    Call<FileInfoResponse> filesInfo(@Field(SlackParamsConstants.FILE) String file, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.FILES_LIST)
    Call<FileListResponse> filesList(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.FILES_REVOKE_PUBLIC_URL)
    Call<FileResponse> filesRevokePublicUrl(@Field(SlackParamsConstants.FILE) String file);

    @GET(SlackWebApiConstants.FILES_SHARED_PUBLIC_URL)
    Call<FileInfoResponse> filesSharedPublicUrl(@Field(SlackParamsConstants.FILE) String file);

    @Multipart
    @POST(SlackWebApiConstants.FILES_UPLOAD)
    Call<FileResponse> filesUpload(@Part MultipartBody.Part file, @Field(SlackParamsConstants.FILENAME) String filename, @QueryMap Map<String, String> params);

    // group (team's private channels)
    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_ARCHIVE)
    Call<BaseResponse> groupsArchive(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_CLOSE)
    Call<GroupCloseResponse> groupsClose(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_CREATE)
    Call<GroupCreateResponse> groupsCreate(@Field(SlackParamsConstants.NAME) String name);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_CREATE_CHILD)
    Call<GroupCreateResponse> groupsCreateChild(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @GET(SlackWebApiConstants.GROUPS_HISTORY)
    Call<HistoryResponse> groupsHistory(@Field(SlackParamsConstants.CHANNEL) String channelId, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.GROUPS_INFO)
    Call<GroupCreateResponse> groupsInfo(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_INVITE)
    Call<GroupCreateResponse> groupsInvite(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.USER) String userId);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_KICK)
    Call<BaseResponse> groupsKick(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.USER) String userId);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_LEAVE)
    Call<BaseResponse> groupsLeave(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @GET(SlackWebApiConstants.GROUPS_LIST)
    Call<GroupListResponse> groupsList(@QueryMap Map<String, String> params);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_MARK)
    Call<BaseResponse> groupsMark(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.TS) String ts);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_OPEN)
    Call<BaseResponse> groupsOpen(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_RENAME)
    Call<GroupCreateResponse> groupsRename(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.NAME) String name);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_SET_PURPOSE)
    Call<ChannelPurposeResponse> groupsSetPurpose(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.PURPOSE) String purpose);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_SET_TOPIC)
    Call<ChannelTopicResponse> groupsSetTopic(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.TOPIC) String topic);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_UNARCHIVE)
    Call<BaseResponse> groupsUnarchive(@Field(SlackParamsConstants.CHANNEL) String channelId);

    // im (direct messages)
    @GET(SlackWebApiConstants.IM_CLOSE)
    Call<BaseResponse> imClose(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @GET(SlackWebApiConstants.IM_HISTORY)
    Call<HistoryResponse> imHistory(@Field(SlackParamsConstants.CHANNEL) String channelId, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.IM_LIST)
    Call<ImListResponse> imList();

    @GET(SlackWebApiConstants.IM_MARK)
    Call<BaseResponse> imMark(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.TS) String ts);

    @GET(SlackWebApiConstants.IM_OPEN)
    Call<ImOpenResponse> imOpen(@Field(SlackParamsConstants.USER) String userId, @QueryMap Map<String, String> params);

    // mipm (multiparty direct messages)
    @GET(SlackWebApiConstants.MPIM_CLOSE)
    Call<BaseResponse> mpimClose(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @GET(SlackWebApiConstants.MPIM_HISTORY)
    Call<HistoryResponse> mpimHistory(@Field(SlackParamsConstants.CHANNEL) String channelId, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.MPIM_LIST)
    Call<GroupListResponse> mpimList();

    @GET(SlackWebApiConstants.MPIM_MARK)
    Call<BaseResponse> mpimMark(@Field(SlackParamsConstants.CHANNEL) String channelId, @Field(SlackParamsConstants.TS) String ts);

    @GET(SlackWebApiConstants.MPIM_OPEN)
    Call<MpimCreateResponse> mpimOpen(@Field(SlackParamsConstants.USERS) String users);

    // oauth
    @GET(SlackWebApiConstants.OAUTH_ACCESS)
    Call<OauthAccessResponse> oauthAccess(@Field(SlackParamsConstants.CLIENT_ID) String clientId, @Field(SlackParamsConstants.CLIENT_SECRET) String clientSecret,
                                          @Field(SlackParamsConstants.CODE) String code, @QueryMap Map<String, String> params);

    // pins
    @GET(SlackWebApiConstants.PINS_ADD)
    Call<BaseResponse> pinsAdd(@Field(SlackParamsConstants.CHANNEL) String channelId, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.PINS_LIST)
    Call<PinListResponse> pinsList(@Field(SlackParamsConstants.CHANNEL) String channelId);

    @GET(SlackWebApiConstants.PINS_REMOVE)
    Call<BaseResponse> pinsRemove(@Field(SlackParamsConstants.CHANNEL) String channelId, @QueryMap Map<String, String> params);

    // reactions
    @GET(SlackWebApiConstants.REACTIONS_ADD)
    Call<BaseResponse> reactionsAdd(@Field(SlackParamsConstants.NAME) String name, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.REACTIONS_GET)
    Call<ReactionGetResponse> reactionsGet(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.REACTIONS_LIST)
    Call<ReactionListResponse> reactionsList(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.REACTIONS_REMOVE)
    Call<BaseResponse> reactionsRemove(@Field(SlackParamsConstants.NAME) String name, @QueryMap Map<String, String> params);

    // reminders
    @GET(SlackWebApiConstants.REMINDERS_ADD)
    Call<ReminderAddResponse> remindersAdd(@Field(SlackParamsConstants.TEXT) String text, @Field(SlackParamsConstants.TIME) String time, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.REMINDERS_COMPLETE)
    Call<BaseResponse> remindersComplete(@Field(SlackParamsConstants.REMINDER) String reminder);

    @GET(SlackWebApiConstants.REMINDERS_DELETE)
    Call<BaseResponse> remindersDelete(@Field(SlackParamsConstants.REMINDER) String reminder);

    @GET(SlackWebApiConstants.REMINDERS_INFO)
    Call<ReminderAddResponse> remindersInfo(@Field(SlackParamsConstants.REMINDER) String reminder);

    @GET(SlackWebApiConstants.REMINDERS_LIST)
    Call<ReminderListResponse> remindersList();

    // rtm
    @GET(SlackWebApiConstants.RTM_START)
    Call<RtmStartResponse> rtmStart(@QueryMap Map<String, String> params);

    // search
    @GET(SlackWebApiConstants.SEARCH_ALL)
    Call<SearchAllResponse> searchAll(@Field(SlackParamsConstants.QUERY) String query, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.SEARCH_FILES)
    Call<SearchFilesResponse> searchFiles(@Field(SlackParamsConstants.QUERY) String query, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.SEARCH_MESSAGES)
    Call<SearchMessagesResponse> searchMessages(@Field(SlackParamsConstants.QUERY) String query, @QueryMap Map<String, String> params);

    // stars
    @GET(SlackWebApiConstants.STARS_ADD)
    Call<BaseResponse> starsAdd(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.STARS_LIST)
    Call<StarListResponse> starsList(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.STARS_REMOVE)
    Call<BaseResponse> starsRemove(@QueryMap Map<String, String> params);

    // team
    @GET(SlackWebApiConstants.TEAM_ACCESS_LOGS)
    Call<AccessLogResponse> teamAccessLogs(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.TEAM_BILLABLE_INFO)
    Call<TeamBillableInfoResponse> teamBillableInfo(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.TEAM_INFO)
    Call<TeamInfoResponse> teamInfo();

    @GET(SlackWebApiConstants.TEAM_INTEGRATION_LOGS)
    Call<TeamIntegrationLogsResponse> teamIntegrationLogs(@QueryMap Map<String, String> params);

    // team.profile
    @GET(SlackWebApiConstants.TEAM_PROFILE_GET)
    Call<TeamProfileGetResponse> teamProfileGet(@QueryMap Map<String, String> params);

    // usergroups
    @GET(SlackWebApiConstants.USERGROUPS_CREATE)
    Call<UsergroupResponse> usergroupsCreate(@Field(SlackParamsConstants.NAME) String name, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.USERGROUPS_DISABLE)
    Call<UsergroupResponse> usergroupsDisable(@Field(SlackParamsConstants.USERGROUP) String usergroupId, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.USERGROUPS_ENABLE)
    Call<UsergroupResponse> usergroupsEnable(@Field(SlackParamsConstants.USERGROUP) String usergroupId, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.USERGROUPS_LIST)
    Call<UsergroupListResponse> usergroupsList(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.USERGROUPS_UPDATE)
    Call<UsergroupResponse> usergroupsUpdate(@Field(SlackParamsConstants.USERGROUP) String usergroupId, @QueryMap Map<String, String> params);

    // usergroups.users
    @GET(SlackWebApiConstants.USERGROUPS_USERS_LIST)
    Call<UsergroupUserListResponse> usergroupsUsersList(@Field(SlackParamsConstants.USERGROUP) String usergroupId, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.USERGROUPS_USERS_UPDATE)
    Call<UsergroupResponse> usergroupsUsersUpdate(@Field(SlackParamsConstants.USERGROUP) String usergroupId, @Field(SlackParamsConstants.USERS) String users, @QueryMap Map<String, String> params);

    // users
    @GET(SlackWebApiConstants.USERS_DELETE_PHOTO)
    Call<BaseResponse> usersDeletePhoto();

    @GET(SlackWebApiConstants.USERS_GET_PRESENCE)
    Call<UserGetPresenceResponse> usersGetPresence(@Field(SlackParamsConstants.USER) String user);

    @GET(SlackWebApiConstants.USERS_IDENTIFY)
    Call<UserIdentityResponse> usersIdentify();

    @GET(SlackWebApiConstants.USERS_INFO)
    Call<UserInfoResponse> usersInfo(@Field(SlackParamsConstants.USER) String user);

    @GET(SlackWebApiConstants.USERS_LIST)
    Call<UserListResponse> usersList(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.USERS_SET_ACTIVE)
    Call<BaseResponse> usersSetActive();

    @Multipart
    @POST(SlackWebApiConstants.USERS_SET_PHOTO)
    Call<BaseResponse> usersSetPhoto(@Part(SlackParamsConstants.IMAGE) RequestBody image, @QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.USERS_SET_PRESENCE)
    Call<BaseResponse> usersSetPresence(@Field(SlackParamsConstants.PRESENCE) String presence);

    //users.profile
    @GET(SlackWebApiConstants.USERS_PROFILE_GET)
    Call<UserProfileResponse> usersProfileGet(@QueryMap Map<String, String> params);

    @GET(SlackWebApiConstants.USERS_PROFILE_SET)
    Call<UserProfileResponse> usersProfileSet(@QueryMap Map<String, String> params);
}
