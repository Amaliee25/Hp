package slack.android.api.models;

import java.util.List;

public class SearchMessageList {
    private int total;
    private Pagination pagination;
    private Paging paging;

    private List<MatchMessage> matches;

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

    public List<MatchMessage> getMatches() {
        return matches;
    }

    public void setMatches(List<MatchMessage> matches) {
        this.matches = matches;
    }
}
