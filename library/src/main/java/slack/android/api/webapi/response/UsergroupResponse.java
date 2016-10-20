package slack.android.api.webapi.response;

import slack.android.api.models.Usergroup;

public class UsergroupResponse extends BaseResponse {
    private Usergroup usergroup;

    public Usergroup getUsergroup() {
        return usergroup;
    }

    public void setUsergroup(Usergroup usergroup) {
        this.usergroup = usergroup;
    }
}
