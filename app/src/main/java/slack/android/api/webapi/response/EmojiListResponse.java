package slack.android.api.webapi.response;

/**
 * Created by flaviokreis on 22/08/16.
 */
public class EmojiListResponse extends BaseResponse {
    private String emoji;

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
