package slack.android.api.webapi.response;

public class AuthRevokeResponse extends BaseResponse {
    private Boolean revoked;

    public Boolean getRevoked() {
        return revoked;
    }

    public void setRevoked(Boolean revoked) {
        this.revoked = revoked;
    }
}
