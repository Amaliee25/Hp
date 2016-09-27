package slack.android.api.webapi.response;

import slack.android.api.models.Group;

public class GroupCreateResponse extends BaseResponse {
    private Group group;

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
