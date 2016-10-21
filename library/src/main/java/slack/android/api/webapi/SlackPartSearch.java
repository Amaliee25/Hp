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
     * @param params
     * @param callback
     */
    public void all(@NonNull String query, @NonNull SearchParams params, Callback<SearchAllResponse> callback){
        service.searchAll(query, params.build()).enqueue(callback);
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
    public void files(@NonNull String query, @NonNull SearchParams params, Callback<SearchFilesResponse> callback){
        service.searchFiles(query, params.build()).enqueue(callback);
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
    public void messages(@NonNull String query, @NonNull SearchParams params, Callback<SearchMessagesResponse> callback){
        service.searchMessages(query, params.build()).enqueue(callback);
    }
}
