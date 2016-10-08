package slack.android.api.webapi.response;

import slack.android.api.models.Reminder;

public class ReminderAddResponse extends BaseResponse {
    private Reminder reminder;

    public Reminder getReminder() {
        return reminder;
    }

    public void setReminder(Reminder reminder) {
        this.reminder = reminder;
    }
}
