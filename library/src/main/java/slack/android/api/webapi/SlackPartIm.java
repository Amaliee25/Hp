package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.HistoryParams;
import slack.android.api.webapi.params.ImOpenParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.HistoryResponse;
import slack.android.api.webapi.response.ImListResponse;
import slack.android.api.webapi.response.ImOpenResponse;

public class SlackPartIm extends BaseSlackPart {

    protected SlackPartIm(SlackWebApiInterface service){
        super(service);
    }

    /**
     * This method closes a direct message channel.
     *
     * Requires scope: im:write
     *
     * @param channelId Direct message channel to close.
     * @param callback
     */
    public void close(@NonNull String channelId, Callback<BaseResponse> callback){
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
     * @param callback
     */
    public void history(@NonNull String channelId, Callback<HistoryResponse> callback){
        history(channelId, null, callback);
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
    public void history(@NonNull String channelId, HistoryParams params, Callback<HistoryResponse> callback){
        service.imHistory(channelId, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method returns a list of all im channels that the user has.
     *
     * Requires scope: im:read
     *
     * @param callback
     */
    public void list(Callback<ImListResponse> callback){
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
    public void mark(@NonNull String channelId, @NonNull String ts, Callback<BaseResponse> callback){
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
     * @param callback
     */
    public void open(@NonNull String userId, Callback<ImOpenResponse> callback){
        open(userId, null, callback);
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
    public void open(@NonNull String userId, ImOpenParams params, Callback<ImOpenResponse> callback){
        service.imOpen(userId, verifyParams(params)).enqueue(callback);
    }
}
