package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.TeamAccessLogParams;
import slack.android.api.webapi.params.TeamBillableInfoParams;
import slack.android.api.webapi.params.TeamIntegrationLogsParams;
import slack.android.api.webapi.params.TeamProfileGetParams;
import slack.android.api.webapi.response.AccessLogResponse;
import slack.android.api.webapi.response.TeamBillableInfoResponse;
import slack.android.api.webapi.response.TeamInfoResponse;
import slack.android.api.webapi.response.TeamIntegrationLogsResponse;
import slack.android.api.webapi.response.TeamProfileGetResponse;

public class SlackPartTeam extends BaseSlackPart {

    protected SlackPartTeam(SlackWebApiInterface service) {
        super(service);
    }

    /**
     * This method is used to get the access logs for users on a team.
     *
     * Requires scope: admin
     *
     * @param callback
     */
    public void accessLogs(Callback<AccessLogResponse> callback){
        accessLogs(null, callback);
    }

    /**
     * This method is used to get the access logs for users on a team.
     *
     * Requires scope: admin
     *
     * @param params
     * @param callback
     */
    public void accessLogs(TeamAccessLogParams params, Callback<AccessLogResponse> callback){
        service.teamAccessLogs(verifyParams(params)).enqueue(callback);
    }

    /**
     * This method lists billable information for each user on the team. Currently this consists
     * solely of whether the user is subject to billing per Slack's Fair Billing policy.
     *
     * Requires scope: admin
     *
     * @param callback
     */
    public void billableInfo(Callback<TeamBillableInfoResponse> callback){
        billableInfo(null, callback);
    }

    /**
     * This method lists billable information for each user on the team. Currently this consists
     * solely of whether the user is subject to billing per Slack's Fair Billing policy.
     *
     * Requires scope: admin
     *
     * @param params
     * @param callback
     */
    public void billableInfo(TeamBillableInfoParams params, Callback<TeamBillableInfoResponse> callback){
        service.teamBillableInfo(verifyParams(params)).enqueue(callback);
    }

    /**
     * This method provides information about your team.
     *
     * Requires scope: team:read
     *
     * @param callback
     */
    public void info(Callback<TeamInfoResponse> callback){
        service.teamInfo().enqueue(callback);
    }

    /**
     * This method lists the integration activity logs for a team, including when integrations are
     * added, modified and removed. This method can only be called by Admins.
     *
     * Requires scope: admin
     *
     * @param callback
     */
    public void integrationLogs(Callback<TeamIntegrationLogsResponse> callback){
        integrationLogs(null, callback);
    }

    /**
     * This method lists the integration activity logs for a team, including when integrations are
     * added, modified and removed. This method can only be called by Admins.
     *
     * Requires scope: admin
     *
     * @param params
     * @param callback
     */
    public void integrationLogs(TeamIntegrationLogsParams params, Callback<TeamIntegrationLogsResponse> callback){
        service.teamIntegrationLogs(verifyParams(params)).enqueue(callback);
    }

    /**
     * This method is used to get the profile field definitions for this team.
     *
     * Requires scope: users.profile:get
     *
     * @param callback
     */
    public void profile(Callback<TeamProfileGetResponse> callback){
        profile(null, callback);
    }

    /**
     * This method is used to get the profile field definitions for this team.
     *
     * Requires scope: users.profile:get
     *
     * @param params
     * @param callback
     */
    public void profile(TeamProfileGetParams params, Callback<TeamProfileGetResponse> callback){
        service.teamProfileGet(verifyParams(params)).enqueue(callback);
    }

}
