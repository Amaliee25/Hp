package slack.android.api.models;

public class StarItem {
    private String type;

    private String channel;

    private Message message;
    private File file;
    private Comment fileComment;
    private Im im;
    private Group group;

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

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public Comment getFileComment() {
        return fileComment;
    }

    public void setFileComment(Comment fileComment) {
        this.fileComment = fileComment;
    }

    public Im getIm() {
        return im;
    }

    public void setIm(Im im) {
        this.im = im;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
