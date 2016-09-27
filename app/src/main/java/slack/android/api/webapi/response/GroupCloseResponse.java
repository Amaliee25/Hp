package slack.android.api.webapi.response;

public class GroupCloseResponse extends BaseResponse {
    private boolean noOp;
    private boolean alreadyClosed;

    public boolean isNoOp() {
        return noOp;
    }

    public void setNoOp(boolean noOp) {
        this.noOp = noOp;
    }

    public boolean isAlreadyClosed() {
        return alreadyClosed;
    }

    public void setAlreadyClosed(boolean alreadyClosed) {
        this.alreadyClosed = alreadyClosed;
    }
}
