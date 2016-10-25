package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.SearchParams;
import slack.android.api.webapi.response.SearchAllResponse;
import slack.android.api.webapi.response.SearchFilesResponse;
import slack.android.api.webapi.response.SearchMessagesResponse;

public class SlackPartSearch extends BaseSlackPart {

    protected SlackPartSearch(SlackWebApiInterface service) {
        super(service);
    }

    /**
     * This method allows users and applications to search both messages and files in a single call.
     *
     * Requires scope: search:read
     *
     * @param query Search query. May contains booleans, etc.
     * @param callback
     */
    public void all(@NonNull String query, Callback<SearchAllResponse> callback){
        all(query, null, callback);
    }

    /**
     * This method allows users and applications to search both messages and files in a single call.
     *
     * Requires scope: search:read
     *
     * @param query Search query. May contains booleans, etc.
     * @param params
     * @param callback
     */
    public void all(@NonNull String query, SearchParams params, Callback<SearchAllResponse> callback){
        service.searchAll(query, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method returns files matching a search query.
     *
     * Requires scope: search:read
     *
     * @param query Search query. May contains booleans, etc.
     * @param callback
     */
    public void files(@NonNull String query, Callback<SearchFilesResponse> callback){
        files(query, null, callback);
    }

    /**
     * This method returns files matching a search query.
     *
     * Requires scope: search:read
     *
     * @param query Search query. May contains booleans, etc.
     * @param params
     * @param callback
     */
    public void files(@NonNull String query, SearchParams params, Callback<SearchFilesResponse> callback){
        service.searchFiles(query, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method returns messages matching a search query.
     *
     * Requires scope: search:read
     *
     * @param query Search query. May contains booleans, etc.
     * @param callback
     */
    public void messages(@NonNull String query, Callback<SearchMessagesResponse> callback){
        messages(query, null, callback);
    }

    /**
     * This method returns messages matching a search query.
     *
     * Requires scope: search:read
     *
     * @param query Search query. May contains booleans, etc.
     * @param params
     * @param callback
     */
    public void messages(@NonNull String query, SearchParams params, Callback<SearchMessagesResponse> callback){
        service.searchMessages(query, verifyParams(params)).enqueue(callback);
    }
}
