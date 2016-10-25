package slack.android.api.webapi;

import retrofit2.Callback;
import slack.android.api.webapi.params.RtmStartParams;
import slack.android.api.webapi.response.RtmStartResponse;

public class SlackPartRtm extends BaseSlackPart {

    protected SlackPartRtm(SlackWebApiInterface service) {
        super(service);
    }

    /**
     * This method starts a Real Time Messaging API session.
     *
     * Requires scope: client
     *
     * @param callback
     */
    public void start(Callback<RtmStartResponse> callback){
        start(null, callback);
    }

    /**
     * This method starts a Real Time Messaging API session.
     *
     * Requires scope: client
     *
     * @param params
     * @param callback
     */
    public void start(RtmStartParams params, Callback<RtmStartResponse> callback){
        service.rtmStart(verifyParams(params)).enqueue(callback);
    }
}
