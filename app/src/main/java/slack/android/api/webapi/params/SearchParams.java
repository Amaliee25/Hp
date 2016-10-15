package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Search methods
 */
public class SearchParams extends Params {

    /**
     * Return matches sorted by either score or timestamp.
     * @param sort
     */
    public void setSort(String sort){
        put(SlackParamsConstants.SORT, sort);
    }

    /**
     * Change sort direction to ascending (asc) or descending (desc).
     * @param sortDir
     */
    public void setSortDir(String sortDir){
        put(SlackParamsConstants.SORT_DIR, sortDir);
    }

    /**
     * Pass a value of 1 to enable query highlight markers (see below).
     * @param isHighlight
     */
    public void setHighlight(boolean isHighlight){
        put(SlackParamsConstants.HIGHLIGHT, isHighlight);
    }

    /**
     * Number of items to return per page.
     * @param count
     */
    public void setCount(int count){
        put(SlackParamsConstants.COUNT, count);
    }

    /**
     * Page number of results to return.
     * @param page
     */
    public void setPage(int page){
        put(SlackParamsConstants.PAGE, page);
    }
}
