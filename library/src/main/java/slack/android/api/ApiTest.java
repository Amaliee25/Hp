package slack.android.api;

import slack.android.api.webapi.SlackWebApiAsync;

/**
 * Created by flaviokreis on 20/10/16.
 */
public class ApiTest {

    public void test(){
        SlackWebApiAsync async = SlackWebApiAsync.getService("test");
        async.api().test(null);
        async.auth().revoke(null);
        async.bots().botsInfo(null);
    }
}
