package slack.android.api.models;

public class Purpose {
    private String  value;
    private String  creator;
    private long    lastSet;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public long getLastSet() {
        return lastSet;
    }

    public void setLastSet(long lastSet) {
        this.lastSet = lastSet;
    }
}
