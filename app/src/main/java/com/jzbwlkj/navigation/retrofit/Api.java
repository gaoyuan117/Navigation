package com.jzbwlkj.navigation.retrofit;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by admin on 2017/3/27.
 */

public interface Api {



    //登陆
    @FormUrlEncoded
    @POST("/api/Public/login")
    Observable<HttpResult<CommonBean>> register(@Field("mobile") String mobile,
                                                @Field("password") String password);

}