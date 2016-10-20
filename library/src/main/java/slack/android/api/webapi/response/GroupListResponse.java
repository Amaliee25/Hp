package slack.android.api.webapi.response;

import java.util.List;

import slack.android.api.models.Group;

public class GroupListResponse extends BaseResponse {
    private List<Group> groups;

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }
}
