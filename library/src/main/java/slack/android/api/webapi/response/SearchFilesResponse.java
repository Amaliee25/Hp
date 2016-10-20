package slack.android.api.webapi.response;

import slack.android.api.models.SearchFileList;

public class SearchFilesResponse extends BaseResponse{
    private String query;

    private SearchFileList files;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public SearchFileList getFiles() {
        return files;
    }

    public void setFiles(SearchFileList files) {
        this.files = files;
    }
}
