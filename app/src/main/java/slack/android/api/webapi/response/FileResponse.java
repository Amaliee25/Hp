package slack.android.api.webapi.response;

import slack.android.api.models.File;

public class FileResponse extends BaseResponse {
    private File file;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
