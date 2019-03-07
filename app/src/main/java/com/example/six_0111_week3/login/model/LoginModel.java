package com.example.six_0111_week3.login.model;

import com.example.six_0111_week3.api.UserApi;
import com.example.six_0111_week3.bean.ZcBean;
import com.example.six_0111_week3.okhttp.OkHttp3;
import com.example.six_0111_week3.okhttp.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class LoginModel implements ILoginModel{

    private UserApi userApi;

    @Override
    public void GetData(String url, String name, String pwd, final LoginCallBack loginCallBack) {
        OkHttp3.okHttpPost(url, name, pwd, new OkHttp3.GetBackPost() {
            @Override
            public void getTrue(String succ) {
                loginCallBack.succ(succ);
            }
        });
    }

    //注册
    @Override
    public void getmdata(String phone, String pwd, final ZcCallBack zcCallBack)
    {
        userApi = RetrofitUtils.getInstance().create(UserApi.class);
        userApi.zc(phone,pwd)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ZcBean>() {
                    @Override
                    public void onNext(ZcBean value) {
                        zcCallBack.OnSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
