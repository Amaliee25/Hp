package slack.android.api.webapi.response;

import java.util.List;

import slack.android.api.models.User;

public class UserListResponse extends BaseResponse {
    private List<User> members;

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }
}
