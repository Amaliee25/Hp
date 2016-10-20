package slack.android.api.webapi.response;

import slack.android.api.models.SearchFileList;
import slack.android.api.models.SearchMessageList;

public class SearchAllResponse extends BaseResponse{
    private String query;

    private SearchMessageList messages;
    private SearchFileList files;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public SearchMessageList getMessages() {
        return messages;
    }

    public void setMessages(SearchMessageList messages) {
        this.messages = messages;
    }

    public SearchFileList getFiles() {
        return files;
    }

    public void setFiles(SearchFileList files) {
        this.files = files;
    }
}
