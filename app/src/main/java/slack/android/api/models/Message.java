package slack.android.api.models;

import java.util.List;

/**
 * A message was sent to a channel
 */
public class Message {
    private String type;
    private String channel;
    private String user;
    private String text;
    private String ts;
    private Boolean isStarred;
    private MessageEdited edited;
    private String subtype;
    private Boolean hidden;
    private String deletedTs;
    private String eventTs;
    private List<Reaction> reactions;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
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

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public Boolean getStarred() {
        return isStarred;
    }

    public void setStarred(Boolean starred) {
        isStarred = starred;
    }

    public MessageEdited getEdited() {
        return edited;
    }

    public void setEdited(MessageEdited edited) {
        this.edited = edited;
    }

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public String getDeletedTs() {
        return deletedTs;
    }

    public void setDeletedTs(String deletedTs) {
        this.deletedTs = deletedTs;
    }

    public String getEventTs() {
        return eventTs;
    }

    public void setEventTs(String eventTs) {
        this.eventTs = eventTs;
    }

    public List<Reaction> getReactions() {
        return reactions;
    }

    public void setReactions(List<Reaction> reactions) {
        this.reactions = reactions;
    }
}
