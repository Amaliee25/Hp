package slack.android.api.webapi.response;

public class EmojiListResponse extends BaseResponse {
    private String emoji;

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }
}
