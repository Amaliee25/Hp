package slack.android.api.webapi;

import retrofit2.Callback;
import slack.android.api.webapi.response.EmojiListResponse;

public class SlackPartEmoji extends BaseSlackPart {

    protected SlackPartEmoji(SlackWebApiInterface service){
        super(service);
    }

    /**
     * This method lists the custom emoji for a team.
     *
     * Requires scope: emoji:read
     *
     * @param callback
     */
    public void list(Callback<EmojiListResponse> callback){
        service.emojiList().enqueue(callback);
    }
}
