package slack.android.api.webapi;

import java.util.HashMap;
import java.util.Map;

import slack.android.api.webapi.params.Params;

abstract class BaseSlackPart {
    SlackWebApiInterface service;

    public BaseSlackPart(SlackWebApiInterface service){
        this.service = service;
    }

    public Map<String, String> verifyParams(Params params){
        return (params != null) ? params.build() : new HashMap<String, String>();
    }

}
