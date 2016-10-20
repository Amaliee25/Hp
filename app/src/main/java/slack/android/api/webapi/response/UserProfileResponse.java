package slack.android.api.webapi.response;

import slack.android.api.models.Profile;

public class UserProfileResponse extends BaseResponse {
    private Profile profile;

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }
}
