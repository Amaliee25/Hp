package slack.android.api.webapi.response;

import slack.android.api.models.User;

/**
 * Created by flaviokreis on 19/10/16.
 */
public class UserInfoResponse extends BaseResponse {
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
