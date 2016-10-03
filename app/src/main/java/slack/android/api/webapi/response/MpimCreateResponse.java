package slack.android.api.webapi.response;

import slack.android.api.models.Mpim;

public class MpimCreateResponse {
    private Mpim group;

    public Mpim getGroup() {
        return group;
    }

    public void setGroup(Mpim group) {
        this.group = group;
    }
}
