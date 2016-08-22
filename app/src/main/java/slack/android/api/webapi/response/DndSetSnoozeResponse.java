package slack.android.api.webapi.response;

public class DndSetSnoozeResponse extends BaseResponse {
    private boolean snoozeEnabled;
    private long snoozeEndTime;
    private long snoozeRemaining;

    public boolean isSnoozeEnabled() {
        return snoozeEnabled;
    }

    public void setSnoozeEnabled(boolean snoozeEnabled) {
        this.snoozeEnabled = snoozeEnabled;
    }

    public long getSnoozeEndTime() {
        return snoozeEndTime;
    }

    public void setSnoozeEndTime(long snoozeEndTime) {
        this.snoozeEndTime = snoozeEndTime;
    }

    public long getSnoozeRemaining() {
        return snoozeRemaining;
    }

    public void setSnoozeRemaining(long snoozeRemaining) {
        this.snoozeRemaining = snoozeRemaining;
    }
}
