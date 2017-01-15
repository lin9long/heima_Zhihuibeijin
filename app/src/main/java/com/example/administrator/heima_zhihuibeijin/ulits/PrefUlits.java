package com.example.administrator.heima_zhihuibeijin.ulits;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Administrator on 2017/1/15.
 */

public class PrefUlits {

    public static boolean getBoolean(Context ctx, String name, boolean defValue) {
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getBoolean(name, defValue);
    }

    public static void putBoolean(Context ctx, String name, boolean value) {
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putBoolean(name, value);
    }

    public static String getString(Context ctx, String name, String defValue) {
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getString(name, defValue);
    }

    public static void putString(Context ctx, String name, String value) {
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putString(name, value);
    }

    public static int getInt(Context ctx, String name, int defValue) {
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        return sp.getInt(name, defValue);
    }

    public static void putInt(Context ctx, String name, int value) {
        SharedPreferences sp = ctx.getSharedPreferences("config", Context.MODE_PRIVATE);
        sp.edit().putInt(name, value);
    }
}
