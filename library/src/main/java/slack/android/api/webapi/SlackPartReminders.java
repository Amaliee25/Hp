package slack.android.api.webapi;

import android.support.annotation.NonNull;

import retrofit2.Callback;
import slack.android.api.webapi.params.ReminderAddParams;
import slack.android.api.webapi.response.BaseResponse;
import slack.android.api.webapi.response.ReminderAddResponse;
import slack.android.api.webapi.response.ReminderListResponse;

public class SlackPartReminders extends BaseSlackPart {

    protected SlackPartReminders(SlackWebApiInterface service) {
        super(service);
    }

    /**
     * This method creates a reminder.
     *
     * Requires scope: reminders:write
     *
     * @param text The content of the reminder
     * @param time When this reminder should happen: the Unix timestamp (up to five years from now),
     *             the number of seconds until the reminder (if within 24 hours), or a natural language
     *             description (Ex. "in 15 minutes," or "every Thursday")
     * @param params
     * @param callback
     */
    public void add(@NonNull String text, @NonNull String time, @NonNull ReminderAddParams params, Callback<ReminderAddResponse> callback){
        service.remindersAdd(text, time, params.build()).enqueue(callback);
    }

    /**
     * This method completes a reminder.
     *
     * Requires scope: reminders:write
     *
     * @param reminderId The ID of the reminder to be marked as complete
     */
    public void complete(@NonNull String reminderId, Callback<BaseResponse> callback){
        service.remindersComplete(reminderId).enqueue(callback);
    }

    /**
     * This method deletes a reminder.
     *
     * Requires scope: reminders:write
     *
     * @param reminderId The ID of the reminder
     * @param callback
     */
    public void delete(@NonNull String reminderId, Callback<BaseResponse> callback){
        service.remindersDelete(reminderId).enqueue(callback);
    }

    /**
     * This method returns information about a reminder.
     *
     * Requires scope: reminders:read
     *
     * @param reminderId The ID of the reminder
     * @param callback
     */
    public void info(@NonNull String reminderId, Callback<ReminderAddResponse> callback){
        service.remindersInfo(reminderId).enqueue(callback);
    }

    /**
     * This method lists all reminders created by or for a given user.
     *
     * Requires scope: reminders:read
     *
     * @param callback
     */
    public void list(Callback<ReminderListResponse> callback){
        service.remindersList().enqueue(callback);
    }

}
