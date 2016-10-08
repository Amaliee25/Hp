package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Bots Info method
 */
public class BotsInfoParams extends Params {

    /**
     * Bot user to get info on
     * @param bot Bot user to get info on
     */
    public void setBot(String bot){
        put(SlackParamsConstants.BOT, bot);
    }
}
