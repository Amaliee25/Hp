package slack.android.api.webapi.response;

import slack.android.api.models.Bot;

public class BotsInfoResponse extends BaseResponse {
    private Bot bot;

    public Bot getBot() {
        return bot;
    }

    public void setBot(Bot bot) {
        this.bot = bot;
    }
}
