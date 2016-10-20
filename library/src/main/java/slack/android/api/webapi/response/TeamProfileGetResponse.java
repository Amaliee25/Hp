package slack.android.api.webapi.response;

import slack.android.api.models.TeamProfile;

public class TeamProfileGetResponse {
    private TeamProfile profile;

    public TeamProfile getProfile() {
        return profile;
    }

    public void setProfile(TeamProfile profile) {
        this.profile = profile;
    }
}
