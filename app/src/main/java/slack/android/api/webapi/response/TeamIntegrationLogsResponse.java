package slack.android.api.webapi.response;

import java.util.List;

import slack.android.api.models.IntegrationLog;
import slack.android.api.models.Paging;

public class TeamIntegrationLogsResponse extends BaseResponse {
    private List<IntegrationLog> logs;

    private Paging paging;

    public List<IntegrationLog> getLogs() {
        return logs;
    }

    public void setLogs(List<IntegrationLog> logs) {
        this.logs = logs;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
