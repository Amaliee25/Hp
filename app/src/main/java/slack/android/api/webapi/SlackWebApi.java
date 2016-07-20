package slack.android.api.webapi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import slack.android.api.webapi.response.ApiTestResponse;
import slack.android.api.webapi.response.AuthRevokeResponse;
import slack.android.api.webapi.response.AuthTestResponse;
import slack.android.api.webapi.response.BotsInfoResponse;
import slack.android.api.webapi.response.ChannelArchiveResponse;
import slack.android.api.webapi.response.ChannelCreateResponse;

public interface SlackWebApi {

    @GET(SlackWebApiConstants.API_TEST)
    Call<ApiTestResponse> apiTest();

    @GET(SlackWebApiConstants.AUTH_REVOKE)
    Call<AuthRevokeResponse> authRevoke();

    @GET(SlackWebApiConstants.AUTH_TEST)
    Call<AuthTestResponse> authTest();

    @GET(SlackWebApiConstants.BOTS_INFO)
    Call<BotsInfoResponse> botInfo();

    @FormUrlEncoded
    @POST(SlackWebApiConstants.CHANNELS_ARCHIVE)
    Call<ChannelArchiveResponse> channelsArchive(@Field("channel") String channelId);

    @POST(SlackWebApiConstants.CHANNELS_CREATE)
    Call<ChannelCreateResponse> channelsCreate(@Field("name") String name);
}
