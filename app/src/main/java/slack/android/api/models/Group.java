package slack.android.api.models;

import java.util.List;

/**
 * A group object contains information about a private channel. Private channels were once
 * known as "private groups." Consider a group object the same thing as a private channel object.
 */
public class Group {
    private String          id;
    private String          name;
    private boolean         isGroup;
    private long            created;
    private String          creator;

    private boolean         isArchived;
    private boolean         isMpim;

    private List<String>    members;

    private Topic           topic;
    private Purpose         purpose;

    private String          lastRead;
    private Message         latest;
    private int             unreadCount;
    private int             unreadCountDisplay;

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

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public boolean isMpim() {
        return isMpim;
    }

    public void setMpim(boolean mpim) {
        isMpim = mpim;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Purpose getPurpose() {
        return purpose;
    }

    public void setPurpose(Purpose purpose) {
        this.purpose = purpose;
    }

    public String getLastRead() {
        return lastRead;
    }

    public void setLastRead(String lastRead) {
        this.lastRead = lastRead;
    }

    public Message getLatest() {
        return latest;
    }

    public void setLatest(Message latest) {
        this.latest = latest;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public int getUnreadCountDisplay() {
        return unreadCountDisplay;
    }

    public void setUnreadCountDisplay(int unreadCountDisplay) {
        this.unreadCountDisplay = unreadCountDisplay;
    }
}
