package slack.android.api.webapi.response;

import slack.android.api.models.Comment;

public class FileCommentResponse extends BaseResponse {
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
