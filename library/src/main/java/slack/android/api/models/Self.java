package slack.android.api.models;

public class Self {
    private String id;
    private String name;
    private String created;
    private String manualPresence;
    //TODO add prefs;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getManualPresence() {
        return manualPresence;
    }

    public void setManualPresence(String manualPresence) {
        this.manualPresence = manualPresence;
    }
}
