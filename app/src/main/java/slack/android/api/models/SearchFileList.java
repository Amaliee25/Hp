package slack.android.api.models;

import java.util.List;

public class SearchFileList {
    private int total;
    private Pagination pagination;
    private Paging paging;

    private List<MatchFile> files;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }

    public List<MatchFile> getFiles() {
        return files;
    }

    public void setFiles(List<MatchFile> files) {
        this.files = files;
    }
}
