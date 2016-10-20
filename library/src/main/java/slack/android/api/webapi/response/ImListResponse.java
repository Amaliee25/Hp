package slack.android.api.webapi.response;

import slack.android.api.models.Im;

import java.util.List;

public class ImListResponse extends BaseResponse {
    private List<Im> ims;

    public List<Im> getIms() {
        return ims;
    }

    public void setIms(List<Im> ims) {
        this.ims = ims;
    }
}
