package slack.android.api.webapi.response;

public class ChannelPurposeResponse extends BaseResponse {
    private String purpose;

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }
}
