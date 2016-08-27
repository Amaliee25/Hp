package slack.android.api.webapi.params;

/**
 * Set optional arguments to Slack Web Api File Upload method
 */
public class FileUploadParams extends Params {

    //TODO need implement it
    /**
     * File contents via multipart/form-data. If omitting this parameter, you must submit content.
     *
     * @param file
     */
    public void setFile(String file){
        params.put(SlackParamsConstants.FILE, file);
    }

    /**
     * File contents via a POST variable. If omitting this parameter, you must provide a file.
     *
     * @param content
     */
    public void setContent(String content){
        params.put(SlackParamsConstants.CONTENT, content);
    }

    /**
     * A file type identifier.
     *
     * @param filetype
     */
    public void setFiletype(String filetype){
        params.put(SlackParamsConstants.FILETYPE, filetype);
    }

    /**
     * Title of file.
     *
     * @param title
     */
    public void setTitle(String title){
        params.put(SlackParamsConstants.TITLE, title);
    }

    /**
     * Initial comment to add to file.
     *
     * @param initialComment
     */
    public void setInitialComment(String initialComment){
        params.put(SlackParamsConstants.INITIAL_COMMENT, initialComment);
    }

    /**
     * Comma-separated list of channel names or IDs where the file will be shared.
     *
     * @param channels
     */
    public void setChannels(String channels){
        params.put(SlackParamsConstants.CHANNELS, channels);
    }
}
