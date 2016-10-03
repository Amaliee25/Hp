package slack.android.api.webapi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import slack.android.api.webapi.params.SlackParamsConstants;
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

    //TODO
    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_START_PARTIAL_UPLOAD)
    Call<BaseResponse> filesStartPartialUpload();

    //TODO
    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_UPLOAD)
    Call<FileResponse> filesUpload(@Field(SlackParamsConstants.FILENAME) String filename, @QueryMap Map<String, String> params);

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
    Call<BaseResponse> oauthAccess();

    // pins
    @GET(SlackWebApiConstants.PINS_ADD)
    Call<BaseResponse> pinsAdd();

    @GET(SlackWebApiConstants.PINS_LIST)
    Call<BaseResponse> pinsList();

    @GET(SlackWebApiConstants.PINS_REMOVE)
    Call<BaseResponse> pinsRemove();

    // reactions
    @GET(SlackWebApiConstants.REACTIONS_ADD)
    Call<BaseResponse> reactionsAdd();

    @GET(SlackWebApiConstants.REACTIONS_GET)
    Call<BaseResponse> reactionsGet();

    @GET(SlackWebApiConstants.REACTIONS_LIST)
    Call<BaseResponse> reactionsList();

    @GET(SlackWebApiConstants.REACTIONS_REMOVE)
    Call<BaseResponse> reactionsRemove();

    // reminders
    @GET(SlackWebApiConstants.REMINDERS_ADD)
    Call<BaseResponse> remindersAdd();

    @GET(SlackWebApiConstants.REMINDERS_COMPLETE)
    Call<BaseResponse> remindersComplete();

    @GET(SlackWebApiConstants.REMINDERS_DELETE)
    Call<BaseResponse> remindersDelete();

    @GET(SlackWebApiConstants.REMINDERS_INFO)
    Call<BaseResponse> remindersInfo();

    @GET(SlackWebApiConstants.REMINDERS_LIST)
    Call<BaseResponse> remindersList();

    // rtm
    @GET(SlackWebApiConstants.RTM_START)
    Call<BaseResponse> rtmStart();

    // search
    @GET(SlackWebApiConstants.SEARCH_ALL)
    Call<BaseResponse> searchAll();

    @GET(SlackWebApiConstants.SEARCH_FILES)
    Call<BaseResponse> searchFiles();

    @GET(SlackWebApiConstants.SEARCH_MESSAGES)
    Call<BaseResponse> searchMessages();

    // stars
    @GET(SlackWebApiConstants.STARS_ADD)
    Call<BaseResponse> starsAdd();

    @GET(SlackWebApiConstants.STARS_LIST)
    Call<BaseResponse> starsList();

    @GET(SlackWebApiConstants.STARS_REMOVE)
    Call<BaseResponse> starsRemove();

    // team
    @GET(SlackWebApiConstants.TEAM_ACCESS_LOGS)
    Call<BaseResponse> teamAccessLogs();

    @GET(SlackWebApiConstants.TEAM_BILLABLE_INFO)
    Call<BaseResponse> teamBillableInfo();

    @GET(SlackWebApiConstants.TEAM_INFO)
    Call<BaseResponse> teamInfo();

    @GET(SlackWebApiConstants.TEAM_INTEGRATION_LOGS)
    Call<BaseResponse> teamIntegrationLogs();

    // team.profile
    @GET(SlackWebApiConstants.TEAM_PROFILE_GET)
    Call<BaseResponse> teamProfileGet();

    // usergroups
    @GET(SlackWebApiConstants.USERGROUPS_CREATE)
    Call<BaseResponse> usergroupsCreate();

    @GET(SlackWebApiConstants.USERGROUPS_DISABLE)
    Call<BaseResponse> usergroupsDisable();

    @GET(SlackWebApiConstants.USERGROUPS_ENABLE)
    Call<BaseResponse> usergroupsEnable();

    @GET(SlackWebApiConstants.USERGROUPS_LIST)
    Call<BaseResponse> usergroupsList();

    @GET(SlackWebApiConstants.USERGROUPS_UPDATE)
    Call<BaseResponse> usergroupsUpdate();

    // usergroups.users
    @GET(SlackWebApiConstants.USERGROUPS_USERS_LIST)
    Call<BaseResponse> usergroupsUsersList();

    @GET(SlackWebApiConstants.USERGROUPS_USERS_UPDATE)
    Call<BaseResponse> usergroupsUsersUpdate();

    // users
    @GET(SlackWebApiConstants.USERS_GET_PRESENCE)
    Call<BaseResponse> usersGetPresence();

    @GET(SlackWebApiConstants.USERS_IDENTIFY)
    Call<BaseResponse> usersIdentify();

    @GET(SlackWebApiConstants.USERS_INFO)
    Call<BaseResponse> usersInfo();

    @GET(SlackWebApiConstants.USERS_LIST)
    Call<BaseResponse> usersList();

    @GET(SlackWebApiConstants.USERS_SET_ACTIVE)
    Call<BaseResponse> usersSetActive();

    @GET(SlackWebApiConstants.USERS_SET_PRESENCE)
    Call<BaseResponse> usersSetPresence();

    //users.profile
    @GET(SlackWebApiConstants.USERS_PROFILE_GET)
    Call<BaseResponse> usersProfileGet();

    @GET(SlackWebApiConstants.USERS_PROFILE_SET)
    Call<BaseResponse> usersProfileSet();
}
