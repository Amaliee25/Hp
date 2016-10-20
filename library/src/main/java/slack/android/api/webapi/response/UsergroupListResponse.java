package slack.android.api.webapi.response;

import java.util.List;

import slack.android.api.models.Usergroup;

public class UsergroupListResponse extends BaseResponse {
    private List<Usergroup> usergroups;

    public List<Usergroup> getUsergroups() {
        return usergroups;
    }

    public void setUsergroups(List<Usergroup> usergroups) {
        this.usergroups = usergroups;
    }
}
