package com.example.com.moni.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.com.moni.MainActivity;
import com.example.com.moni.R;
import com.example.com.moni.bean.LoginBean;
import com.example.com.moni.contract.JDContract;
import com.example.com.moni.presenter.Presenter;
import com.google.gson.Gson;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity implements JDContract.JDView {

    @BindView(R.id.login_username)
    EditText loginUsername;
    @BindView(R.id.login_password)
    EditText loginPassword;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.register)
    Button register;
    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.login, R.id.register})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login://点击登录
                String password = loginPassword.getText().toString();
                String username = loginUsername.getText().toString();
                if (username.equals("")||username==null||password.equals("")||password==null){
                    Toast.makeText(this, "请完善数据", Toast.LENGTH_SHORT).show();
                    return;
                }
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put("mobile",username);
                hashMap.put("password",password);
                presenter = new Presenter(this);
                presenter.startPresenter(hashMap);
                break;
            case R.id.register://点击注册


                break;
        }
    }

    @Override
    public void success(String view) {
        Gson gson = new Gson();
        LoginBean loginBean = gson.fromJson(view, LoginBean.class);

        Toast.makeText(this,loginBean.msg , Toast.LENGTH_SHORT).show();
        if (loginBean.code.equals("0")){
           startActivity(new Intent(LoginActivity.this,MainActivity.class));
        }
    }

    @Override
    public void failure(String error) {

    }
}
