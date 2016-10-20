package slack.android.api.models;

public class Reminder {
    private String id;
    private String creator;
    private String user;
    private String text;
    private boolean recurring;
    private long time;
    private int completeTs;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isRecurring() {
        return recurring;
    }

    public void setRecurring(boolean recurring) {
        this.recurring = recurring;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public int getCompleteTs() {
        return completeTs;
    }

    public void setCompleteTs(int completeTs) {
        this.completeTs = completeTs;
    }
}
