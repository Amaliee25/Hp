package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.ReactionAddParams;
import slack.android.api.webapi.params.ReactionGetParams;
import slack.android.api.webapi.params.ReactionListParams;
import slack.android.api.webapi.params.ReactionRemoveParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.ReactionGetResponse;
import slack.android.api.webapi.response.ReactionListResponse;

public class SlackPartReactions extends BaseSlackPart {

    protected SlackPartReactions(SlackWebApiInterface service) {
        super(service);
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
    public void add(@NonNull String name, @NonNull ReactionAddParams params, Callback<BaseResponse> callback){
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
    public void get(@NonNull ReactionGetParams params, Callback<ReactionGetResponse> callback){
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
    public void list(@NonNull ReactionListParams params, Callback<ReactionListResponse> callback){
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
    public void remove(@NonNull String name, @NonNull ReactionRemoveParams params, Callback<BaseResponse> callback){
        service.reactionsRemove(name, params.build()).enqueue(callback);
    }
}
