package slack.android.api.webapi.response;

import slack.android.api.models.ApiTestArgs;

public class ApiTestResponse extends BaseResponse {
    private ApiTestArgs args;

    public ApiTestArgs getArgs() {
        return args;
    }

    public void setArgs(ApiTestArgs args) {
        this.args = args;
    }
}
