package com.durga.balaji66.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesStorage {

    private Context mContext;
    SharedPreferencesStorage(Context context)
    {
        this.mContext =context;
    }

    public void saveLoginDetails(String email, String password)
    {
        SharedPreferences preferences =  mContext.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =preferences.edit();
        editor.putString("email",email);
        editor.putString("password",password);
        editor.apply();
    }

    public String getEmail()
    {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        return sharedPreferences.getString("email","");
    }

    public boolean isUserLogout()
    {
        SharedPreferences sharedPreferences =mContext.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        boolean isEmailEmpty = sharedPreferences.getString("email","").isEmpty();
        boolean isPasswordEmpty = sharedPreferences.getString("password","").isEmpty();
        return isEmailEmpty||isPasswordEmpty;
    }

    public void clear()
    {
        SharedPreferences sharedPreferences =mContext.getSharedPreferences("LoginDetails",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove("email");
        editor.remove("password");
        editor.apply();
    }

}
