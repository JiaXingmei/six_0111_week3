package com.example.six_0111_week3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.example.six_0111_week3.bean.ZcBean;
import com.example.six_0111_week3.login.presenter.LoginPresenter;
import com.example.six_0111_week3.login.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ZhuActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.zc_phone)
    EditText zcPhone;
    @BindView(R.id.zc_pwd)
    EditText zcPwd;
    @BindView(R.id.login_lgbt)
    Button loginLgbt;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
        loginPresenter.getpdata();
    }

    @Override
    public void GetLoginData(String data) {

    }

    @Override
    public void getvdata(Object object)
    {
        ZcBean zcBean = (ZcBean) object;

    }
}
