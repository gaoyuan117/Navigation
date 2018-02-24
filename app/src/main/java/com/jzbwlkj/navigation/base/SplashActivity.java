package com.jzbwlkj.navigation.base;


import com.jzbwlkj.navigation.BaseApp;
import com.jzbwlkj.navigation.R;
import com.jzbwlkj.navigation.ui.activity.MainActivity;
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
        token = SharedPreferencesUtil.getInstance().getString("token");
        BaseApp.phone = SharedPreferencesUtil.getInstance().getString("phone");
        BaseApp.token = token;

        Observable.timer(1, TimeUnit.SECONDS)
                .subscribe(new Consumer<Long>() {
                    @Override
                    public void accept(Long aLong) throws Exception {
                        toActivity(MainActivity.class);
                        finish();
                    }
                });
    }

    @Override
    public void initDatas() {

    }

    @Override
    public void configViews() {

    }
}
