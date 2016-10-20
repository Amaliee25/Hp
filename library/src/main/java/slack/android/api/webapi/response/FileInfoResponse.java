package slack.android.api.webapi.response;

import slack.android.api.models.Comment;
import slack.android.api.models.File;
import slack.android.api.models.Paging;

import java.util.List;

public class FileInfoResponse extends BaseResponse {
    private File file;
    private List<Comment> comments;
    private Paging paging;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
