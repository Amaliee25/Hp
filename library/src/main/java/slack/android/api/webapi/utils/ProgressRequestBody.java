package slack.android.api.webapi.utils;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;

public class ProgressRequestBody extends RequestBody {

    private final RequestBody requestBody;
    private final ProgressListener progressListener;

    public ProgressRequestBody(RequestBody requestBody, ProgressListener progressListener) {
        this.requestBody = requestBody;
        this.progressListener = progressListener;
    }

    @Override
    public MediaType contentType() {
        return requestBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return requestBody.contentLength();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {
        final long totalBytes = contentLength();
        BufferedSink progressSink = Okio.buffer(new ForwardingSink( sink ) {
            private long bytesWritten = 0L;

            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                bytesWritten += byteCount;

                if( progressListener != null ){
                    progressListener.onProgressChange(( int )((bytesWritten * 100) / totalBytes));
                }

                super.write(source, byteCount);
            }
        });
        requestBody.writeTo(progressSink);
        progressSink.flush();
    }
}
