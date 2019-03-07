package com.example.six_0111_week3.api;

import com.example.six_0111_week3.bean.ZcBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface UserApi
{
    @POST("/small/user/v1/register")
    Observable<ZcBean> zc(@Field("phone")String phone,@Field("pwd")String pwd);

}
