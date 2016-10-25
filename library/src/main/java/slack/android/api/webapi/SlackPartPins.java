package slack.android.api.webapi;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import retrofit2.Callback;
import slack.android.api.webapi.params.PinAddParams;
import slack.android.api.webapi.params.PinRemoveParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.PinListResponse;

public class SlackPartPins extends BaseSlackPart {

    protected SlackPartPins(SlackWebApiInterface service) {
        super(service);
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
    public void add(@NonNull String channelId, @NonNull PinAddParams params, Callback<BaseResponse> callback){
        service.pinsAdd(channelId, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method lists the items pinned to a channel.
     *
     * Requires scope: pins:read
     *
     * @param channelId Channel to get pinned items for.
     * @param callback
     */
    public void list(@NonNull String channelId, Callback<PinListResponse> callback){
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
    public void remove(@NonNull String channelId, @NonNull PinRemoveParams params, Callback<BaseResponse> callback){
        service.pinsRemove(channelId, verifyParams(params)).enqueue(callback);
    }
}
