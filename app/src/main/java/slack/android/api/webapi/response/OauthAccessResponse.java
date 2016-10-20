package slack.android.api.webapi.response;

public class OauthAccessResponse extends BaseResponse {
    private String scope;

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
