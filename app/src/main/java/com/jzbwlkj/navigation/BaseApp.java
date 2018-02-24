package com.jzbwlkj.navigation;

import android.database.sqlite.SQLiteDatabase;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.text.TextUtils;

import com.jzbwlkj.navigation.ui.bean.LoginBean;
import com.jzbwlkj.navigation.utils.SharedPreferencesUtil;

import java.util.HashSet;
import java.util.Set;

import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.api.TagAliasCallback;

/**
 * Created by gaoyuan on 2018/1/7.
 */

public class BaseApp extends MultiDexApplication {

    private static BaseApp sInstance;
    public static String token;
    public static String phone;
    public static LoginBean login;

    @Override
    public void onCreate() {
        super.onCreate();

        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);

        MultiDex.install(this);
        sInstance = this;

        SharedPreferencesUtil.init(this, "data", MODE_PRIVATE);

        String phone = SharedPreferencesUtil.getInstance().getString("phone");
        if (!TextUtils.isEmpty(phone)) {
            Set<String> strings = new HashSet<>();
            strings.add(phone);
            JPushInterface.setAliasAndTags(this, phone, strings, new TagAliasCallback() {
                @Override
                public void gotResult(int i, String s, Set<String> set) {

                }
            });
        }
    }

    public static BaseApp getsInstance() {
        return sInstance;
    }


}
