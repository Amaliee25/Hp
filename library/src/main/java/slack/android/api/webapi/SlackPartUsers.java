package slack.android.api.webapi;

import android.support.annotation.NonNull;

import java.io.File;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Callback;
import slack.android.api.webapi.params.UserListParams;
import slack.android.api.webapi.params.UserProfileGetParams;
import slack.android.api.webapi.params.UserProfileSetParams;
import slack.android.api.webapi.params.UserSetPhotoParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.UserGetPresenceResponse;
import slack.android.api.webapi.response.UserIdentityResponse;
import slack.android.api.webapi.response.UserInfoResponse;
import slack.android.api.webapi.response.UserListResponse;
import slack.android.api.webapi.response.UserProfileResponse;

public class SlackPartUsers extends BaseSlackPart {

    protected SlackPartUsers(SlackWebApiInterface service) {
        super(service);
    }

    /**
     * This method allows the user to delete their profile image. It will clear whatever image is currently set.
     *
     * To upload a new profile image, use the companion method users.setPhoto.
     *
     * Requires scope: users.profile:write
     *
     * @param callback
     */
    public void deletePhoto(Callback<BaseResponse> callback){
        service.usersDeletePhoto().enqueue(callback);
    }

    /**
     * This method lets you find out information about a user's presence.
     *
     * Requires scope: users:read
     *
     * @param userId User to get presence info on. Defaults to the authed user.
     * @param callback
     */
    public void presence(@NonNull String userId, Callback<UserGetPresenceResponse> callback){
        service.usersGetPresence(userId).enqueue(callback);
    }

    /**
     * After your Slack app is awarded an identity token through Sign in with Slack, use this
     * method to retrieve a user's identity.
     *
     * The returned fields depend on any additional authorization scopes you've requested.
     *
     * This method may only be used by tokens with the identity.basic scope, as provided in the
     * Sign in with Slack process.
     *
     * @param callback
     */
    public void identity(Callback<UserIdentityResponse> callback){
        service.usersIdentify().enqueue(callback);
    }

    /**
     * This method returns information about a team member.
     *
     * Requires scope: users:read
     *
     * @param userId User to get info on
     * @param callback
     */
    public void info(@NonNull String userId, Callback<UserInfoResponse> callback){
        service.usersInfo(userId).enqueue(callback);
    }

    /**
     * This method returns a list of all users in the team. This includes deleted/deactivated users.
     *
     * Requires scope: users:read
     *
     * @param callback
     */
    public void list(Callback<UserListResponse> callback){
        list(null, callback);
    }

    /**
     * This method returns a list of all users in the team. This includes deleted/deactivated users.
     *
     * Requires scope: users:read
     *
     * @param params
     * @param callback
     */
    public void list(@NonNull UserListParams params, Callback<UserListResponse> callback){
        service.usersList(params.build()).enqueue(callback);
    }

    /**
     * This method lets the slack messaging server know that the authenticated user is currently active.
     *
     * Requires scope: users:write
     *
     * @param callback
     */
    public void setActive(Callback<BaseResponse> callback){
        service.usersSetActive().enqueue(callback);
    }

    /**
     * This method allows the user to set their profile image. The caller can pass image data via
     * image.
     *
     * Providing a "crop box" with crop_x, crop_y, and crop_w is optional. Otherwise, the whole
     * image will be used. If cropping instructions are not specified and the source image is not
     * square, the image will be letterboxed, just like your favorite old laserdiscs.
     *
     * Please limit your images to a maximum size of 1024 by 1024 pixels. 512x512 pixels is the
     * minimum.
     *
     * To remove a profile image, use the companion method users.deletePhoto.
     *
     * Requires scope: users.profile:write
     *
     * @param imageContentType When providing the image parameter, provide your image data directly
     *                         but present its correct Content-type, such as image/gif, image/jpeg, image/png, etc.
     * @param file Image file
     * @param callback
     */
    public void setPhoto(@NonNull String imageContentType, @NonNull File file, Callback<BaseResponse> callback){
        setPhoto(imageContentType, file, null, callback);
    }

    /**
     * This method allows the user to set their profile image. The caller can pass image data via
     * image.
     *
     * Providing a "crop box" with crop_x, crop_y, and crop_w is optional. Otherwise, the whole
     * image will be used. If cropping instructions are not specified and the source image is not
     * square, the image will be letterboxed, just like your favorite old laserdiscs.
     *
     * Please limit your images to a maximum size of 1024 by 1024 pixels. 512x512 pixels is the
     * minimum.
     *
     * To remove a profile image, use the companion method users.deletePhoto.
     *
     * Requires scope: users.profile:write
     *
     * @param imageContentType When providing the image parameter, provide your image data directly
     *                         but present its correct Content-type, such as image/gif, image/jpeg, image/png, etc.
     * @param file Image file
     * @param params
     * @param callback
     */
    public void setPhoto(@NonNull String imageContentType, @NonNull File file, UserSetPhotoParams params, Callback<BaseResponse> callback){
        RequestBody body = RequestBody.create(MediaType.parse(imageContentType), file);

        service.usersSetPhoto(body, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method lets you set the calling user's manual presence.
     *
     * Requires scope: users:write
     *
     * @param presence Either auto or away
     * @param callback
     */
    public void setPresence(@NonNull String presence, Callback<BaseResponse> callback){
        service.usersSetPresence(presence).enqueue(callback);
    }

    /**
     * This method is used to get the profile information for a user.
     *
     * Requires scope: users.profile:read
     *
     * @param callback
     */
    public void profile(Callback<UserProfileResponse> callback){
        profile(null, callback);
    }

    /**
     * This method is used to get the profile information for a user.
     *
     * Requires scope: users.profile:read
     *
     * @param params
     * @param callback
     */
    public void profile(@NonNull UserProfileGetParams params, Callback<UserProfileResponse> callback){
        service.usersProfileGet(params.build()).enqueue(callback);
    }

    /**
     * This method is used to set the profile information for a user.
     *
     * Requires scope: users.profile:write
     *
     * @param params
     * @param callback
     */
    public void setProfile(@NonNull UserProfileSetParams params, Callback<UserProfileResponse> callback){
        service.usersProfileSet(params.build()).enqueue(callback);
    }
}
