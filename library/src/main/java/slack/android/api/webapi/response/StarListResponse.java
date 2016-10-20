package slack.android.api.webapi.response;

import java.util.List;

import slack.android.api.models.Paging;
import slack.android.api.models.StarItem;

public class StarListResponse extends BaseResponse{
    private List<StarItem> items;

    private Paging paging;

    public List<StarItem> getItems() {
        return items;
    }

    public void setItems(List<StarItem> items) {
        this.items = items;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
}
