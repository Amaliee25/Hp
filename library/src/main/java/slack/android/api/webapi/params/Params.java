package slack.android.api.webapi.params;

import java.util.HashMap;
import java.util.Map;

/**
 * Set a list of optional params to use in a slack web api methods.
 */
public abstract class Params {
    private Map<String, String> params;

    public Params(){
        params = new HashMap<>();
    }

    public Map<String, String> build(){
        return params;
    }

    void put(String key, String value){
        params.put(key, value);
    }

    void put(String key, boolean value){
        params.put(key, value ? "1" : "0");
    }

    void put(String key, int value){
        params.put(key, String.valueOf(value));
    }

    void put(String key, int value, int min, int max){
        if(value < min){
            value = min;
        }
        else if(value > max){
            value = max;
        }

        put(key, value);
    }

}
