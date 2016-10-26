package slack.android.api.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;

import java.util.List;

public class SlackUtils {

    /**
     * Create Comma-separated String by list
     *
     * @param list List with ids (user, group, etc.)
     * @return Comma-separated String
     */
    @NonNull
    public static String join(List<String> list){
        if( (list != null) && !list.isEmpty() ){
            return TextUtils.join(",", list);
        }
        return "";
    }

    /**
     * Create Comma-separated String by array
     *
     * @param list array with ids (user, group, etc.)
     * @return Comma-separated String
     */
    @NonNull
    public static String join(String... list){
        if(list != null){
            return TextUtils.join(",", list);
        }
        return "";
    }
}
