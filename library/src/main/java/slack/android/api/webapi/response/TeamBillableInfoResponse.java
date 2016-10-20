package slack.android.api.webapi.response;

public class TeamBillableInfoResponse extends BaseResponse {

    private String billableInfo; //TODO fix this

    public String getBillableInfo() {
        return billableInfo;
    }

    public void setBillableInfo(String billableInfo) {
        this.billableInfo = billableInfo;
    }
}
