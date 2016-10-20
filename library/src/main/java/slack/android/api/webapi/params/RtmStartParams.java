package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api Rtm Start method
 */
public class RtmStartParams extends Params {

    /**
     * Return timestamp only for latest message object of each channel (improves performance).
     * @param isSimpleLatest
     */
    private void setSimpleLatest(boolean isSimpleLatest){
        put(SlackParamsConstants.SIMPLE_LATEST, isSimpleLatest);
    }

    /**
     * Skip unread counts for each channel (improves performance).
     * @param isNoUnreads
     */
    private void setNoUnreads(boolean isNoUnreads){
        put(SlackParamsConstants.NO_UNREADS, isNoUnreads);
    }

    /**
     * Returns MPIMs to the client in the API response.
     * @param isMpimAware
     */
    private void setMpimAware(boolean isMpimAware){
        put(SlackParamsConstants.MPIM_AWARE, isMpimAware);
    }
}
