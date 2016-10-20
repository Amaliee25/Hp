package slack.android.api.webapi.response;

import slack.android.api.models.PinItem;

import java.util.List;

public class PinListResponse extends BaseResponse {
    private List<PinItem> items;

    public List<PinItem> getItems() {
        return items;
    }

    public void setItems(List<PinItem> items) {
        this.items = items;
    }
}
