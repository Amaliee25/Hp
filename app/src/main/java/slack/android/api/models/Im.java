package slack.android.api.models;

/**
 * Contains information about a direct message channel.
 */
public class Im {
    private String id;
    private boolean isIm;
    private String user;
    private long created;
    private boolean isUserDeleted;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isIm() {
        return isIm;
    }

    public void setIm(boolean im) {
        isIm = im;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public boolean isUserDeleted() {
        return isUserDeleted;
    }

    public void setUserDeleted(boolean userDeleted) {
        isUserDeleted = userDeleted;
    }
}
