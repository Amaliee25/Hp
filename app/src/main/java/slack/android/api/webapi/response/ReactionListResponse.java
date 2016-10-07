package slack.android.api.webapi.response;

import slack.android.api.models.ReactionItem;

import java.util.List;

public class ReactionListResponse extends BaseResponse{
    private List<ReactionItem> items;

    public List<ReactionItem> getItems() {
        return items;
    }

    public void setItems(List<ReactionItem> items) {
        this.items = items;
    }
}
