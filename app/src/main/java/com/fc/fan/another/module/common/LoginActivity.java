package com.fc.fan.another.module.common;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by fan on 7/12/17.
 */

public class LoginActivity extends RxBaseActivity {
    private static final int REQUEST_SIGNUP = 0;
    public static final String TAG = "LoginActivity";

    @BindView(R.id.input_id)
    EditText _idlText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        _loginButton.setOnClickListener(view -> login());
        _signupLink.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivityForResult(intent, REQUEST_SIGNUP);
        });
    }

    @Override
    public void initToolBar() {

    }

    private void login() {
        if (!validate())
            return;

        _loginButton.setEnabled(false);

        ProgressDialog progressDialog = new ProgressDialog(this, R.style.Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("登录中...");
        progressDialog.show();


        String id = _idlText.getText().toString();
        String password = _passwordText.getText().toString();

        HttpUtils.getInstance()
                .create(ApiService.class, "http://10.0.0.14:8080/")
                .test(id, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(responseBody -> {
                    Log.e(TAG, responseBody.string());
                }, throwable -> {
                    Log.e(TAG, throwable.getMessage());
                }, () -> {
                    Log.e(TAG, "获取成功");
                    progressDialog.hide();
                });
    }

    public boolean validate() {
        boolean valid = true;

        String id = _idlText.getText().toString();
        String password = _passwordText.getText().toString();

        if (id.isEmpty()) {
            _idlText.setError("职工号不能为空");
            valid = false;
        }

        if (password.isEmpty()) {
            _passwordText.setError("密码不能为空");
            valid = false;
        }

        return valid;
    }

}