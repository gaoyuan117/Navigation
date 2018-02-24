package com.jzbwlkj.navigation.base;


import android.text.TextUtils;
import android.util.Log;

import com.google.gson.Gson;
import com.jzbwlkj.navigation.BaseApp;
import com.jzbwlkj.navigation.R;
import com.jzbwlkj.navigation.ui.activity.LoginActivity;
import com.jzbwlkj.navigation.ui.activity.MainActivity;
import com.jzbwlkj.navigation.ui.bean.LoginBean;
import com.jzbwlkj.navigation.utils.SharedPreferencesUtil;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class SplashActivity extends BaseActivity {


    private String token;

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        String s = SharedPreferencesUtil.getInstance().getString("login");
        if (!TextUtils.isEmpty(s)) {
            BaseApp.login = new Gson().fromJson(s, LoginBean.class);
        }

        Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        if (BaseApp.login == null) {
                            toActivity(LoginActivity.class);
                        } else {
                            BaseApp.token = BaseApp.login.getData().getToken();
                            BaseApp.phone = BaseApp.login.getData().getUser_login();
                            toActivity(MainActivity.class);
                        }
                        finish();
                    }
                });
    }

    @Override
    public void initData() {

    }

    @Override
    public void configViews() {

    }
}
