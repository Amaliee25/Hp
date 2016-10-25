package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.StarAddParams;
import slack.android.api.webapi.params.StarListParams;
import slack.android.api.webapi.params.StarRemoveParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.StarListResponse;

public class SlackPartStars extends BaseSlackPart {

    protected SlackPartStars(SlackWebApiInterface service) {
        super(service);
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
    public void add(@NonNull StarAddParams params, Callback<BaseResponse> callback){
        service.starsAdd(params.build()).enqueue(callback);
    }

    /**
     * This method lists the items starred by the authed user.
     *
     * Requires scope: stars:read
     *
     * @param callback
     */
    public void list(Callback<StarListResponse> callback){
        list(null, callback);
    }

    /**
     * This method lists the items starred by the authed user.
     *
     * Requires scope: stars:read
     *
     * @param params
     * @param callback
     */
    public void list(StarListParams params, Callback<StarListResponse> callback){
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
    public void remove(@NonNull StarRemoveParams params, Callback<BaseResponse> callback){
        service.starsRemove(params.build()).enqueue(callback);
    }
}
