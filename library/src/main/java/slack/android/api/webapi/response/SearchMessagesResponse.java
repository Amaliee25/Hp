package slack.android.api.webapi.response;

import slack.android.api.models.SearchMessageList;

public class SearchMessagesResponse extends BaseResponse{
    private String query;

    private SearchMessageList messages;

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
}
