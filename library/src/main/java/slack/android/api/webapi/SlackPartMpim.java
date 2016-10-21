package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.HistoryParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.GroupListResponse;
import slack.android.api.webapi.response.HistoryResponse;
import slack.android.api.webapi.response.MpimCreateResponse;

public class SlackPartMpim extends BaseSlackPart {

    protected SlackPartMpim(SlackWebApiInterface service){
        super(service);
    }

    /**
     * This method closes a multiparty direct message channel.
     *
     * Requires scope: mpim:write
     *
     * @param channelId MPIM to close.
     * @param callback
     */
    public void close(@NonNull String channelId, Callback<BaseResponse> callback){
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
    public void history(@NonNull String channelId, @NonNull HistoryParams params, Callback<HistoryResponse> callback){
        service.mpimHistory(channelId, params.build()).enqueue(callback);
    }

    /**
     * This method returns a list of all multiparty direct message channels that the user has.
     *
     * Requires scope: mpim:read
     *
     * @param callback
     */
    public void list(Callback<GroupListResponse> callback){
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
    public void mark(@NonNull String channelId, @NonNull String ts, Callback<BaseResponse> callback){
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
    public void open(@NonNull String users, Callback<MpimCreateResponse> callback){
        service.mpimOpen(users).enqueue(callback);
    }
}
