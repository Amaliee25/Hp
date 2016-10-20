package slack.android.api.webapi.response;

import slack.android.api.models.UserIdentity;

public class UserIdentityResponse extends BaseResponse {
    private UserIdentity user;
    private String team;

    public UserIdentity getUser() {
        return user;
    }

    public void setUser(UserIdentity user) {
        this.user = user;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
