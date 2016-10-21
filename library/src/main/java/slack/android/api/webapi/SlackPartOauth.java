package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.OauthAccessParams;
import slack.android.api.webapi.response.OauthAccessResponse;

public class SlackPartOauth extends BaseSlackPart {

    protected SlackPartOauth(SlackWebApiInterface service) {
        super(service);
    }

    /**
     * This method allows you to exchange a temporary OAuth code for an API access token. This is used as part of the OAuth authentication flow.
     *
     * As discussed in RFC 6749 it is possible to supply the Client ID and Client Secret using the
     * HTTP Basic authentication scheme. If HTTP Basic authentication is used you do not need to
     * supply the client_id and client_secret parameters as part of the request.
     *
     * Keep your tokens secure. Do not share tokens with users or anyone else.
     *
     * @param clientId Issued when you created your application.
     * @param clientSecret Issued when you created your application.
     * @param code The code param returned via the OAuth callback.
     * @param params
     * @param callback
     */
    public void access(@NonNull String clientId, @NonNull String clientSecret,
                            @NonNull String code, @NonNull OauthAccessParams params, Callback<OauthAccessResponse> callback){
        service.oauthAccess(clientId, clientSecret, code, params.build()).enqueue(callback);
    }
}
