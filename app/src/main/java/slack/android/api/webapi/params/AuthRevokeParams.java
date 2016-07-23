package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Auth Revoke method
 */
public class AuthRevokeParams extends Params {

    /**
     * Set this argument to triggers a testing mode where the specified token will not actually
     * be revoked.
     * @param isTest Setting this parameter to true triggers a testing mode where the specified
     *               token will not actually be revoked.
     */
    public void setTest(boolean isTest){
        params.put(SlackParamsConstants.TEST, isTest ? "1" : "0");
    }
}
