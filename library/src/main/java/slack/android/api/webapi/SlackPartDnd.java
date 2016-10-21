package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.DndInfoParams;
import slack.android.api.webapi.params.DndTeamInfoParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.DndEndSnoozeResponse;
import slack.android.api.webapi.response.DndInfoResponse;
import slack.android.api.webapi.response.DndSetSnoozeResponse;
import slack.android.api.webapi.response.DndTeamInfoResponse;

public class SlackPartDnd extends BaseSlackPart {

    protected SlackPartDnd(SlackWebApiInterface service){
        super(service);
    }

    /**
     * Ends the user's currently scheduled Do Not Disturb session immediately.
     *
     * Requires scope: dnd:write
     *
     * @param callback
     */
    public void endDnd(Callback<BaseResponse> callback){
        service.dndEndDnd().enqueue(callback);
    }

    /**
     * Ends the current user's snooze mode immediately.
     *
     * Requires scope: dnd:write
     *
     * @param callback
     */
    public void endSnooze(Callback<DndEndSnoozeResponse> callback){
        service.dndEndSnooze().enqueue(callback);
    }

    /**
     * Provides information about a user's current Do Not Disturb settings.
     *
     * Requires scope: dnd:read
     *
     * @param params
     * @param callback
     */
    public void info(@NonNull DndInfoParams params, Callback<DndInfoResponse> callback){
        service.dndInfo(params.build()).enqueue(callback);
    }

    /**
     * Adjusts the snooze duration for a user's Do Not Disturb settings. If a snooze session is not
     * already active for the user, invoking this method will begin one for the specified duration.
     *
     * Requires scope: dnd:write
     *
     * @param minutes Number of minutes, from now, to snooze until.
     * @param callback
     */
    public void setSnooze(int minutes, Callback<DndSetSnoozeResponse> callback){
        service.dndSetSnooze(String.valueOf(minutes)).enqueue(callback);
    }

    /**
     * Provides information about the current Do Not Disturb settings for users of a Slack team.
     *
     * Requires scope: dnd:read
     *
     * @param params
     * @param callback
     */
    public void teamInfo(@NonNull DndTeamInfoParams params, Callback<DndTeamInfoResponse> callback){
        service.dndTeamInfo(params.build()).enqueue(callback);
    }
}
