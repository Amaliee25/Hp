package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Oauth Access method
 */
public class OauthAccessParams extends Params {

    /**
     * This must match the originally submitted URI (if one was sent).
     *
     * @param uri e.g. http://example.com
     */
    public void setRedirectUri(String uri){
        put(SlackParamsConstants.REDIRECT_URI, uri);
    }
}
