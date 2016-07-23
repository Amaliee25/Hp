package slack.android.api.webapi.params;

import java.util.HashMap;
import java.util.Map;

/**
 * Set a list of optional params to use in a slack web api methods.
 */
public abstract class Params {
    Map<String, String> params;

    public Params(){
        params = new HashMap<>();
    }

    public Map<String, String> build(){
        return params;
    }

}
