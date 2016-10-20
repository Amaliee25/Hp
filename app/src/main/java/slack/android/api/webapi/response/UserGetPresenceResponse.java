package slack.android.api.webapi.response;

/**
 * Created by flaviokreis on 19/10/16.
 */
public class UserGetPresenceResponse extends BaseResponse {
    private String presence;
    private boolean online;
    private boolean autoAway;
    private boolean manualAway;
    private int connectionCount;
    private long lastActivity;

    public String getPresence() {
        return presence;
    }

    public void setPresence(String presence) {
        this.presence = presence;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public boolean isAutoAway() {
        return autoAway;
    }

    public void setAutoAway(boolean autoAway) {
        this.autoAway = autoAway;
    }

    public boolean isManualAway() {
        return manualAway;
    }

    public void setManualAway(boolean manualAway) {
        this.manualAway = manualAway;
    }

    public int getConnectionCount() {
        return connectionCount;
    }

    public void setConnectionCount(int connectionCount) {
        this.connectionCount = connectionCount;
    }

    public long getLastActivity() {
        return lastActivity;
    }

    public void setLastActivity(long lastActivity) {
        this.lastActivity = lastActivity;
    }
}
