package slack.android.api.models;

public class MatchMessage {
    private String type;
    private String user;
    private String username;
    private String ts;
    private String team;

    private MatchMessageChannel channel;

    private String permalink;

    private MatchMessageNext previous;
    private MatchMessageNext previous2;
    private MatchMessageNext next;
    private MatchMessageNext next2;

    private String text;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTs() {
        return ts;
    }

    public void setTs(String ts) {
        this.ts = ts;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public MatchMessageChannel getChannel() {
        return channel;
    }

    public void setChannel(MatchMessageChannel channel) {
        this.channel = channel;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public MatchMessageNext getPrevious() {
        return previous;
    }

    public void setPrevious(MatchMessageNext previous) {
        this.previous = previous;
    }

    public MatchMessageNext getPrevious2() {
        return previous2;
    }

    public void setPrevious2(MatchMessageNext previous2) {
        this.previous2 = previous2;
    }

    public MatchMessageNext getNext() {
        return next;
    }

    public void setNext(MatchMessageNext next) {
        this.next = next;
    }

    public MatchMessageNext getNext2() {
        return next2;
    }

    public void setNext2(MatchMessageNext next2) {
        this.next2 = next2;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
