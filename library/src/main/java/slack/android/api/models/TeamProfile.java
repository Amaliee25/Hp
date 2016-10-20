package slack.android.api.models;

import java.util.List;

public class TeamProfile {
    private List<TeamProfileField> fields;

    public List<TeamProfileField> getFields() {
        return fields;
    }

    public void setFields(List<TeamProfileField> fields) {
        this.fields = fields;
    }
}
