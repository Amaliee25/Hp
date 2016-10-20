package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api User Set Photo method
 */
public class UserSetPhotoParams extends Params {

    /**
     * X coordinate of top-left corner of crop box
     *
     * @param cropX e.g. 10
     */
    public void setCropX(int cropX){
        put(SlackParamsConstants.CROP_X, cropX);
    }

    /**
     * Y coordinate of top-left corner of crop box
     *
     * @param cropY e.g. 20
     */
    public void setCropY(int cropY){
        put(SlackParamsConstants.CROP_Y, cropY);
    }

    /**
     * Width/height of crop box (always square)
     *
     * @param cropW e.g. 100
     */
    public void setCropW(int cropW){
        put(SlackParamsConstants.CROP_W, cropW);
    }
}
