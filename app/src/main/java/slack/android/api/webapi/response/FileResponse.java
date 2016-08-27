package slack.android.api.webapi.response;

import slack.android.api.models.File;

/**
 * Created by flaviokreis on 27/08/16.
 */
public class FileResponse extends BaseResponse {
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
