package ir.sharif.vamdeh.webservices.pref;

import android.content.Context;
import android.content.SharedPreferences;

public class WebservicePrefSeting {

    private static WebservicePrefSeting instance;

    private SharedPreferences sharedPreferences;

    private WebservicePrefSeting(Context context) {
        sharedPreferences = context.getSharedPreferences(PrefCostance.SHARED_NAME, Context.MODE_PRIVATE);
    }

    public static WebservicePrefSeting getInstance(Context context) {
        if (instance == null) {
            instance = new WebservicePrefSeting(context);
        }
        return instance;
    }

    public static WebservicePrefSeting getInstanceWithoutContext() {
        if (instance == null) {
            throw new RuntimeException("Please set context first");
        }
        return instance;
    }

    public boolean isRegister() {
        return sharedPreferences.getBoolean(PrefCostance.IS_REGISTER, false);
    }

    public void setRegister(boolean register) {
        sharedPreferences.edit().putBoolean(PrefCostance.IS_REGISTER, register).apply();

    }

    public void saveKey(String key) {
        sharedPreferences.edit().putString(PrefCostance.SHARED_KEY, key).apply();

    }

    public String getKey() {
        return sharedPreferences.getString(PrefCostance.SHARED_KEY, "");
    }
}
