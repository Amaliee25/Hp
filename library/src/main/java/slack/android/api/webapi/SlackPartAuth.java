package slack.android.api.webapi;

import retrofit2.Callback;
import slack.android.api.webapi.params.AuthRevokeParams;
import slack.android.api.webapi.response.AuthRevokeResponse;
import slack.android.api.webapi.response.AuthTestResponse;

public class SlackPartAuth extends BaseSlackPart {

    protected SlackPartAuth(SlackWebApiInterface service){
        super(service);
    }

    /**
     * This method revokes an access token. Use it when you no longer need a token.
     * @see <a href="https://api.slack.com/methods/auth.revoke">https://api.slack.com/methods/auth.revoke</a>
     * @param callback
     */
    public void revoke(Callback<AuthRevokeResponse> callback){
        revoke( null, callback );
    }

    /**
     * This method revokes an access token. Use it when you no longer need a token.
     * @see <a href="https://api.slack.com/methods/auth.revoke">https://api.slack.com/methods/auth.revoke</a>
     * @param params @see {@link slack.android.api.webapi.params.AuthRevokeParams}
     * @param callback
     */
    public void revoke(AuthRevokeParams params, Callback<AuthRevokeResponse> callback){
        service.authRevoke( verifyParams( params ) ).enqueue( callback );
    }

    /**
     * This method checks authentication and tells you who you are.
     *
     * Requires scope: identify
     *
     * @see <a href="https://api.slack.com/methods/auth.test">https://api.slack.com/methods/auth.test</a>
     * @param callback
     */
    public void test(Callback<AuthTestResponse> callback){
        service.authTest().enqueue( callback );
    }
}
