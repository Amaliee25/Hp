package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.UsergroupCreateParams;
import slack.android.api.webapi.params.UsergroupDisableParams;
import slack.android.api.webapi.params.UsergroupEnableParams;
import slack.android.api.webapi.params.UsergroupUpdateParams;
import slack.android.api.webapi.params.UsergroupUserUpdateParams;
import slack.android.api.webapi.params.UsergroupUsersListParams;
import slack.android.api.webapi.params.UsergroupsListParams;
import slack.android.api.webapi.response.UsergroupListResponse;
import slack.android.api.webapi.response.UsergroupResponse;
import slack.android.api.webapi.response.UsergroupUserListResponse;

public class SlackPartUsergroups extends BaseSlackPart {

    protected SlackPartUsergroups(SlackWebApiInterface service) {
        super(service);
    }

    /**
     * This method is used to create a User Group.
     *
     * Requires scope: usergroups:write
     *
     * @param name A name for the User Group. Must be unique among User Groups.
     * @param callback
     */
    public void create(@NonNull String name, Callback<UsergroupResponse> callback){
        create(name, null, callback);
    }

    /**
     * This method is used to create a User Group.
     *
     * Requires scope: usergroups:write
     *
     * @param name A name for the User Group. Must be unique among User Groups.
     * @param params
     * @param callback
     */
    public void create(@NonNull String name, UsergroupCreateParams params, Callback<UsergroupResponse> callback){
        service.usergroupsCreate(name, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method disables an existing User Group.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to disable.
     * @param callback
     */
    public void disable(@NonNull String usergroupId, Callback<UsergroupResponse> callback){
        disable(usergroupId, null, callback);
    }

    /**
     * This method disables an existing User Group.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to disable.
     * @param params
     * @param callback
     */
    public void disable(@NonNull String usergroupId, UsergroupDisableParams params, Callback<UsergroupResponse> callback){
        service.usergroupsDisable(usergroupId, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method enables a User Group which was previously disabled.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to enable.
     * @param callback
     */
    public void enable(@NonNull String usergroupId, Callback<UsergroupResponse> callback){
        enable(usergroupId, null, callback);
    }

    /**
     * This method enables a User Group which was previously disabled.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to enable.
     * @param params
     * @param callback
     */
    public void enable(@NonNull String usergroupId, UsergroupEnableParams params, Callback<UsergroupResponse> callback){
        service.usergroupsEnable(usergroupId, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method returns a list of all User Groups in the team. This can optionally include
     * disabled User Groups.
     *
     * Requires scope: usergroups:read
     *
     * @param callback
     */
    public void list(Callback<UsergroupListResponse> callback) {
        list(null, callback);
    }

    /**
     * This method returns a list of all User Groups in the team. This can optionally include
     * disabled User Groups.
     *
     * Requires scope: usergroups:read
     *
     * @param params
     * @param callback
     */
    public void list(UsergroupsListParams params, Callback<UsergroupListResponse> callback) {
        service.usergroupsList(verifyParams(params)).enqueue(callback);
    }

    /**
     * This method updates the properties of an existing User Group.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to update.
     * @param callback
     */
    public void update(@NonNull String usergroupId, Callback<UsergroupResponse> callback){
        update(usergroupId, null, callback);
    }

    /**
     * This method updates the properties of an existing User Group.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to update.
     * @param params
     * @param callback
     */
    public void update(@NonNull String usergroupId, UsergroupUpdateParams params, Callback<UsergroupResponse> callback){
        service.usergroupsUpdate(usergroupId, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method returns a list of all users within a User Group.
     *
     * Requires scope: usergroups:read
     *
     * @param usergroupId The encoded ID of the User Group to update.
     * @param callback
     */
    public void userList(@NonNull String usergroupId, Callback<UsergroupUserListResponse> callback){
        userList(usergroupId, null, callback);
    }

    /**
     * This method returns a list of all users within a User Group.
     *
     * Requires scope: usergroups:read
     *
     * @param usergroupId The encoded ID of the User Group to update.
     * @param params
     * @param callback
     */
    public void userList(@NonNull String usergroupId, UsergroupUsersListParams params, Callback<UsergroupUserListResponse> callback){
        service.usergroupsUsersList(usergroupId, verifyParams(params)).enqueue(callback);
    }

    /**
     * This method updates the list of users that belong to a User Group. This method replaces all
     * users in a User Group with the list of users provided in the users parameter.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to update.
     * @param users A comma separated string of encoded user IDs that represent the entire list of
     *              users for the User Group.
     * @param callback
     */
    public void userUpdate(@NonNull String usergroupId, @NonNull String users, Callback<UsergroupResponse> callback){
        userUpdate(usergroupId, users, null, callback);
    }

    /**
     * This method updates the list of users that belong to a User Group. This method replaces all
     * users in a User Group with the list of users provided in the users parameter.
     *
     * Requires scope: usergroups:write
     *
     * @param usergroupId The encoded ID of the User Group to update.
     * @param users A comma separated string of encoded user IDs that represent the entire list of
     *              users for the User Group.
     * @param params
     * @param callback
     */
    public void userUpdate(@NonNull String usergroupId, @NonNull String users, UsergroupUserUpdateParams params, Callback<UsergroupResponse> callback){
        service.usergroupsUsersUpdate(usergroupId, users, verifyParams(params)).enqueue(callback);
    }
}
