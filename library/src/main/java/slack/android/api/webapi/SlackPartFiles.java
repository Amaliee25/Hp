package slack.android.api.webapi;

import android.support.annotation.NonNull;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Callback;
import slack.android.api.webapi.params.FileCommentAddParams;
import slack.android.api.webapi.params.FileInfoParams;
import slack.android.api.webapi.params.FileListParams;
import slack.android.api.webapi.params.FileUploadParams;
import slack.android.api.webapi.params.SlackParamsConstants;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.FileCommentResponse;
import slack.android.api.webapi.response.FileInfoResponse;
import slack.android.api.webapi.response.FileListResponse;
import slack.android.api.webapi.response.FileResponse;
import slack.android.api.webapi.utils.ProgressListener;
import slack.android.api.webapi.utils.ProgressRequestBody;

public class SlackPartFiles extends BaseSlackPart {

    protected SlackPartFiles(SlackWebApiInterface service){
        super(service);
    }

    /**
     * Add a comment to an existing file.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File to add a comment to.
     * @param comment Text of the comment to add.
     * @param callback
     */
    public void commentsAdd(@NonNull String fileId, @NonNull String comment, Callback<FileCommentResponse> callback){
        commentsAdd(fileId, comment, null, callback);
    }

    /**
     * Add a comment to an existing file.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File to add a comment to.
     * @param comment Text of the comment to add.
     * @param params
     * @param callback
     */
    public void commentsAdd(@NonNull String fileId, @NonNull String comment, FileCommentAddParams params, Callback<FileCommentResponse> callback){
        service.filesCommentsAdd(fileId, comment, verifyParams(params)).enqueue(callback);
    }

    /**
     * Delete an existing comment on a file. Only the original author of the comment or a Team
     * Administrator may delete a file comment.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File to delete a comment from.
     * @param commentId The comment to delete.
     * @param callback
     */
    public void commentsDelete(@NonNull String fileId, @NonNull String commentId, Callback<BaseResponse> callback){
        service.filesCommentsDelete(fileId, commentId).enqueue(callback);
    }

    /**
     * Edit an existing comment on a file. Only the user who created a comment may make edits.
     * Teams may configure a limited time window during which file comment edits are allowed.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File containing the comment to edit.
     * @param commentId The comment to edit.
     * @param comment Text of the comment to edit.
     * @param callback
     */
    public void commentsEdit(@NonNull String fileId, @NonNull String commentId, @NonNull String comment, Callback<FileCommentResponse> callback){
        service.filesCommentsEdit(fileId, commentId, comment).enqueue(callback);
    }

    /**
     * This method deletes a file from your team.
     *
     * Requires scope: files:write:user
     *
     * @param fileId ID of file to delete.
     * @param callback
     */
    public void delete(@NonNull String fileId, Callback<BaseResponse> callback){
        service.filesDelete(fileId).enqueue(callback);
    }

    /**
     * This method returns information about a file in your team.
     *
     * Requires scope: files:read
     *
     * @param fileId Specify a file by providing its ID.
     * @param callback
     */
    public void info(@NonNull String fileId, Callback<FileInfoResponse> callback){
        info(fileId, null, callback);
    }

    /**
     * This method returns information about a file in your team.
     *
     * Requires scope: files:read
     *
     * @param fileId Specify a file by providing its ID.
     * @param params
     * @param callback
     */
    public void info(@NonNull String fileId, FileInfoParams params, Callback<FileInfoResponse> callback){
        service.filesInfo(fileId, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method returns a list of files within the team. It can be filtered and sliced in various ways.
     *
     * Requires scope: files:read
     *
     * @param callback
     */
    public void list(Callback<FileListResponse> callback){
        list(null, callback);
    }

    /**
     * This method returns a list of files within the team. It can be filtered and sliced in various ways.
     *
     * Requires scope: files:read
     *
     * @param params
     * @param callback
     */
    public void list(FileListParams params, Callback<FileListResponse> callback){
        service.filesList(verifyParams(params)).enqueue(callback);
    }

    /**
     * This method disables public/external sharing for a file.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File to revoke
     * @param callback
     */
    public void revokePublicUrl(@NonNull String fileId, Callback<FileResponse> callback){
        service.filesRevokePublicUrl(fileId).enqueue(callback);
    }

    /**
     * This method enables public/external sharing for a file.
     *
     * Requires scope: files:write:user
     *
     * @param fileId File to share
     * @param callback
     */
    public void sharedPublicUrl(@NonNull String fileId, Callback<FileInfoResponse> callback){
        service.filesSharedPublicUrl(fileId).enqueue(callback);
    }

    /**
     * This method allows you to create or upload an existing file.
     *
     * Requires scope: files:write:user
     *
     * @param filename Filename of file.
     * @param params
     * @param callback
     */
    public void upload(@NonNull java.io.File file, @NonNull String filename, @NonNull FileUploadParams params, ProgressListener listener, Callback<FileResponse> callback){
        RequestBody fileToUpload = new ProgressRequestBody( RequestBody.create(MultipartBody.FORM, file), listener );
        MultipartBody.Part body = MultipartBody.Part.createFormData(SlackParamsConstants.FILE, filename, fileToUpload);

        service.filesUpload(body, filename, params.build()).enqueue(callback);
    }
}
