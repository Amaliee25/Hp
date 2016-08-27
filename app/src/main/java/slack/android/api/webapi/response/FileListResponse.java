package slack.android.api.webapi.response;

import java.util.List;

import slack.android.api.models.File;
import slack.android.api.models.Paging;

public class FileListResponse {
    private List<File> files;
    private Paging paging;

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
