package slack.android.api.webapi.response;

import slack.android.api.models.AccessLog;
import slack.android.api.models.Paging;

import java.util.List;

public class AccessLogResponse extends BaseResponse {
    private List<AccessLog> logins;

    private Paging paging;

    public List<AccessLog> getLogins() {
        return logins;
    }

    public void setLogins(List<AccessLog> logins) {
        this.logins = logins;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
