package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api File List method
 */
public class FileListParams extends Params {

    /**
     * Filter files created by a single user.
     *
     * @param user
     */
    public void setUser(String user){
        params.put(SlackParamsConstants.USER, user);
    }

    /**
     * Filter files appearing in a specific channel, indicated by its ID.
     *
     * @param channel
     */
    public void setChannel(String channel){
        params.put(SlackParamsConstants.CHANNEL, channel);
    }

    /**
     * Filter files created after this timestamp (inclusive).
     *
     * @param tsFrom
     */
    public void setTsFrom(String tsFrom){
        params.put(SlackParamsConstants.TS_FROM, tsFrom);
    }

    /**
     * Filter files created before this timestamp (inclusive).
     *
     * @param tsTo
     */
    public void setTsTo(String tsTo){
        params.put(SlackParamsConstants.TS_TO, tsTo);
    }

    /**
     * Filter files by type:
     *
     * all - All files
     * spaces - Posts
     * snippets - Snippets
     * images - Image files
     * gdocs - Google docs
     * zips - Zip files
     * pdfs - PDF files
     *
     * You can pass multiple values in the types argument, like types=spaces,snippets.The default
     * value is all, which does not filter the list.
     *
     * @param types
     */
    public void setTypes(String types){
        params.put(SlackParamsConstants.TYPES, types);
    }

    /**
     * Number of items to return per page.
     *
     * Default: 100
     *
     * @param count
     */
    public void setCount(int count){
        if(count < 1){
            count = 1;
        }
        params.put(SlackParamsConstants.COUNT, String.valueOf(count));
    }

    /**
     * Page number of results to return.
     *
     * Default: 1
     *
     * @param page
     */
    public void setPage(int page){
        if(page < 1){
            page = 1;
        }
        params.put(SlackParamsConstants.PAGE, String.valueOf(page));
    }
}
