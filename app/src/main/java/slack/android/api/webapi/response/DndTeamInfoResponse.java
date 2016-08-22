package slack.android.api.webapi.response;

import java.util.List;

public class DndTeamInfoResponse extends BaseResponse {
    private List<String> users; //TODO create object

    public List<String> getUsers() {
        return users;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
}
