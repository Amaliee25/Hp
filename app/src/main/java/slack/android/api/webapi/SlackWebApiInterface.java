package slack.android.api.webapi;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;
import slack.android.api.webapi.response.ApiTestResponse;
import slack.android.api.webapi.response.AuthRevokeResponse;
import slack.android.api.webapi.response.AuthTestResponse;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.BotsInfoResponse;
import slack.android.api.webapi.response.ChannelCreateResponse;

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
    Call<BotsInfoResponse> botInfo();

    // channels
    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_ARCHIVE)
    Call<BaseResponse> channelsArchive(@Field("channel") String channelId);

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_CREATE)
    Call<ChannelCreateResponse> channelsCreate(@Field("name") String name);

    @GET(SlackWebApiConstants.CHANNELS_HISTORY)
    Call<BaseResponse> channelsHistory();

    @GET(SlackWebApiConstants.CHANNELS_INFO)
    Call<BaseResponse> channelsInfo();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_INVITE)
    Call<BaseResponse> channelsInvite();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_JOIN)
    Call<BaseResponse> channelsJoin();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_KICK)
    Call<BaseResponse> channelsKick();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_LEAVE)
    Call<BaseResponse> channelsLeave();

    @GET(SlackWebApiConstants.CHANNELS_LIST)
    Call<BaseResponse> channelsList();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_MARK)
    Call<BaseResponse> channelsMark();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_RENAME)
    Call<BaseResponse> channelsRename();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_SET_PURPOSE)
    Call<BaseResponse> channelsSetPurpose();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_SET_TOPIC)
    Call<BaseResponse> channelsSetTopic();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_UNARCHIVE)
    Call<BaseResponse> channelsUnarchive();

    // chat
    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHAT_DELETE)
    Call<BaseResponse> chatDelete();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHAT_ME_MESSAGE)
    Call<BaseResponse> chatMeMessage();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHAT_POST_MESSAGE)
    Call<BaseResponse> chatPostMessage();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHAT_UPDATE)
    Call<BaseResponse> chatUpdate();

    // dnd (Do Not Disturb)
    @FormUrlEncoded
    @POST(SlackWebApiConstants.DND_END_DND)
    Call<BaseResponse> dndEndDnd();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.DND_END_SNOOZE)
    Call<BaseResponse> dndEndSnooze();

    @GET(SlackWebApiConstants.DND_INFO)
    Call<BaseResponse> dndInfo();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.DND_SET_SNOOZE)
    Call<BaseResponse> dndSetSnooze();

    @GET(SlackWebApiConstants.DND_TEAM_INFO)
    Call<BaseResponse> dndTeamInfo();

    // emoji
    @GET(SlackWebApiConstants.EMOJI_LIST)
    Call<BaseResponse> emojList();

    // files.comments
    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_COMMENTS_ADD)
    Call<BaseResponse> filesCommentsAdd();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_COMMENTS_DELETE)
    Call<BaseResponse> filesCommentsDelete();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_COMMENTS_EDIT)
    Call<BaseResponse> filesCommentsEdit();

    // files
    @FormUrlEncoded
    @POST(SlackWebApiConstants.FILES_DELETE)
    Call<BaseResponse> filesDelete();

    @GET(SlackWebApiConstants.FILES_INFO)
    Call<BaseResponse> filesInfo();

    @GET(SlackWebApiConstants.FILES_LIST)
    Call<BaseResponse> filesList();

    @GET(SlackWebApiConstants.FILES_REVOKE_PUBLIC_URL)
    Call<BaseResponse> filesRevokePublicUrl();

    @GET(SlackWebApiConstants.FILES_SHARED_PUBLIC_URL)
    Call<BaseResponse> filesSharedPublicUrl();

    @GET(SlackWebApiConstants.FILES_START_PARTIAL_UPLOAD)
    Call<BaseResponse> filesStartPartialUpload();

    @GET(SlackWebApiConstants.FILES_UPLOAD)
    Call<BaseResponse> filesUpload();

    // group (team's private channels)
    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_ARCHIVE)
    Call<BaseResponse> groupsArchive();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_CLOSE)
    Call<BaseResponse> groupsClose();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_CREATE)
    Call<BaseResponse> groupsCreate();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_CREATE_CHILD)
    Call<BaseResponse> groupsCreateChild();

    @GET(SlackWebApiConstants.GROUPS_HISTORY)
    Call<BaseResponse> groupsHistory();

    @GET(SlackWebApiConstants.GROUPS_INFO)
    Call<BaseResponse> groupsInfo();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_INVITE)
    Call<BaseResponse> groupsInvite();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_KICK)
    Call<BaseResponse> groupsKick();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_LEAVE)
    Call<BaseResponse> groupsLeave();

    @GET(SlackWebApiConstants.GROUPS_LIST)
    Call<BaseResponse> groupsList();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_MARK)
    Call<BaseResponse> groupsMark();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_OPEN)
    Call<BaseResponse> groupsOpen();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_RENAME)
    Call<BaseResponse> groupsRename();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_SET_PURPOSE)
    Call<BaseResponse> groupsSetPurpose();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_SET_TOPIC)
    Call<BaseResponse> groupsSetTopic();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.GROUPS_UNARCHIVE)
    Call<BaseResponse> groupsUnarchive();

    // im (direct messages)
    @GET(SlackWebApiConstants.IM_CLOSE)
    Call<BaseResponse> imClose();

    @GET(SlackWebApiConstants.IM_HISTORY)
    Call<BaseResponse> imHistory();

    @GET(SlackWebApiConstants.IM_LIST)
    Call<BaseResponse> imList();

    @GET(SlackWebApiConstants.IM_MARK)
    Call<BaseResponse> imMark();

    @GET(SlackWebApiConstants.IM_OPEN)
    Call<BaseResponse> imOpen();

    // mipm (multiparty direct messages)
    @GET(SlackWebApiConstants.MPIM_CLOSE)
    Call<BaseResponse> mpimClose();

    @GET(SlackWebApiConstants.MPIM_HISTORY)
    Call<BaseResponse> mpimHistory();

    @GET(SlackWebApiConstants.MPIM_LIST)
    Call<BaseResponse> mpimList();

    @GET(SlackWebApiConstants.MPIM_MARK)
    Call<BaseResponse> mpimMark();

    @GET(SlackWebApiConstants.MPIM_OPEN)
    Call<BaseResponse> mpimOpen();

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
