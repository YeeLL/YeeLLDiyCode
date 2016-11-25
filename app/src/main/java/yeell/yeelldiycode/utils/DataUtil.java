package yeell.yeelldiycode.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by YeeLL on 11/25/16.
 */
public class DataUtil {
    public static String TOKEN = "token";

    private static DataUtil ourInstance = new DataUtil();

    public static DataUtil getInstance() {
        return ourInstance;
    }

    private DataUtil() {
    }

    /**
     * 存储token
     *
     * @param context
     * @param sharePreferenceName
     * @param token
     */
    public void saveToken(Context context, String sharePreferenceName, String token) {
        SharedPreferences sharePrefrence = context.getSharedPreferences(sharePreferenceName, context.MODE_PRIVATE);
        SharedPreferences.Editor editer = sharePrefrence.edit();
        editer.putString(sharePreferenceName, token);
        editer.commit();
    }

    /**
     * 获取token
     *
     * @param context
     * @param sharePreferenceName
     */
    public String getToken(Context context, String sharePreferenceName) {
        return context.getSharedPreferences(sharePreferenceName, context.MODE_PRIVATE).getString(TOKEN, "error");
    }


}
