package slack.android.api.webapi.response;

import slack.android.api.models.Team;

public class TeamInfoResponse extends BaseResponse {
    private Team team;

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
