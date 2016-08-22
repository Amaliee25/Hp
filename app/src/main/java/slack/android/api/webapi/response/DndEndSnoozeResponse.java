package slack.android.api.webapi.response;

public class DndEndSnoozeResponse extends BaseResponse {
    private boolean dndEnabled;
    private long nextDndStartTs;
    private long nextDndEndTs;
    private boolean snoozeEnabled;

    public boolean isDndEnabled() {
        return dndEnabled;
    }

    public void setDndEnabled(boolean dndEnabled) {
        this.dndEnabled = dndEnabled;
    }

    public long getNextDndStartTs() {
        return nextDndStartTs;
    }

    public void setNextDndStartTs(long nextDndStartTs) {
        this.nextDndStartTs = nextDndStartTs;
    }

    public long getNextDndEndTs() {
        return nextDndEndTs;
    }

    public void setNextDndEndTs(long nextDndEndTs) {
        this.nextDndEndTs = nextDndEndTs;
    }

    public boolean isSnoozeEnabled() {
        return snoozeEnabled;
    }

    public void setSnoozeEnabled(boolean snoozeEnabled) {
        this.snoozeEnabled = snoozeEnabled;
    }
}
