package slack.android.api.webapi;

import android.support.annotation.NonNull;

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
     * @param params
     * @param callback
     */
    public void start(@NonNull RtmStartParams params, Callback<RtmStartResponse> callback){
        service.rtmStart(params.build()).enqueue(callback);
    }
}
