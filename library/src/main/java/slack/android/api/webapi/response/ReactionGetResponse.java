package slack.android.api.webapi.response;

import slack.android.api.models.Comment;
import slack.android.api.models.File;
import slack.android.api.models.Message;

public class ReactionGetResponse extends BaseResponse {
    private String type;
    private String channel;

    private Message message;
    private File file;
    private Comment comment;

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

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
