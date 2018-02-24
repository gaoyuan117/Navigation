package com.jzbwlkj.navigation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jzbwlkj.navigation.BaseApp;
import com.jzbwlkj.navigation.R;
import com.jzbwlkj.navigation.base.BaseActivity;
import com.jzbwlkj.navigation.retrofit.BaseObjObserver;
import com.jzbwlkj.navigation.retrofit.HttpResult;
import com.jzbwlkj.navigation.retrofit.RetrofitClient;
import com.jzbwlkj.navigation.retrofit.RxUtils;
import com.jzbwlkj.navigation.ui.bean.LoginBean;
import com.jzbwlkj.navigation.utils.SharedPreferencesUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.functions.Consumer;

public class LoginActivity extends BaseActivity {

    @BindView(R.id.et_login_user)
    EditText etLoginUser;
    @BindView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @BindView(R.id.tv_login_error_msg)
    TextView tvLoginErrorMsg;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void configViews() {

    }

    @OnClick(R.id.bt_login)
    public void onViewClicked() {
        login();
    }

    /**
     * 登录
     */
    private void login() {
        String phone = etLoginUser.getText().toString();
        String pwd = etLoginPwd.getText().toString();

        if (TextUtils.isEmpty(phone)) {
            showToastMsg(getResources().getString(R.string.please_input_phone));
            return;
        }

        if (TextUtils.isEmpty(pwd)) {
            showToastMsg(getResources().getString(R.string.please_input_pwd));
            return;
        }

        RetrofitClient.getInstance().createApi().login(phone, pwd)
                .compose(RxUtils.<LoginBean>io_main())
                .subscribe(new Consumer<LoginBean>() {
                    @Override
                    public void accept(LoginBean bean) throws Exception {
                        if (bean.getCode() == 200) {
                            SharedPreferencesUtil.getInstance().putString("login", new Gson().toJson(bean));
                            BaseApp.login = bean;
                            BaseApp.token = bean.getData().getToken();
                            BaseApp.phone = bean.getData().getUser_login();
                            toActivity(MainActivity.class);
                            showToastMsg("登录成功");
                            finish();
                        } else {
                            tvLoginErrorMsg.setVisibility(View.VISIBLE);
                        }
                    }
                });
    }
}
