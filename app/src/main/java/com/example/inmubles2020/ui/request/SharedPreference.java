package com.example.inmubles2020.ui.request;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    private static SharedPreferences sp;

    public static SharedPreferences conectar(Context context) {
        if (sp == null) {
            sp = context.getSharedPreferences("datos", 0);
        }
        return sp;
    }

    public static String traerToken(Context context)
    {
        SharedPreferences sp = conectar(context);
        String token = sp.getString("token", null);
        return token;
    }

    public static void guardarToken(Context context, String token)
    {
        SharedPreferences sp = conectar(context);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("token",token);
        editor.commit();

    }
}
