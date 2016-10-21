package slack.android.api.webapi;

import retrofit2.Callback;
import slack.android.api.webapi.params.BotsInfoParams;
import slack.android.api.webapi.response.BotsInfoResponse;

/**
 * Created by flaviokreis on 20/10/16.
 */
public class SlackPartBots extends BaseSlackPart {

    protected SlackPartBots(SlackWebApiInterface service){
        super(service);
    }

    /**
     * This method returns information about a bot user.
     * bot_id is returned from bot_message message events and in the response of methods like channels.history.
     * Use this method to look up the username and icons for those bot users.
     *
     * Requires scope: users:read
     *
     * @param callback
     */
    public void info(Callback<BotsInfoResponse> callback){
        info( null, callback );
    }

    /**
     * This method returns information about a bot user.
     * bot_id is returned from bot_message message events and in the response of methods like channels.history.
     * Use this method to look up the username and icons for those bot users.
     *
     * Requires scope: users:read
     *
     * @param params
     * @param callback
     */
    public void info(BotsInfoParams params, Callback<BotsInfoResponse> callback){
        service.botInfo( verifyParams( params ) ).enqueue(callback);
    }
}
