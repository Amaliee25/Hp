package slack.android.api.webapi.response;

import java.util.List;

public class UsergroupUserListResponse extends BaseResponse {
    private List<String> users;

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
