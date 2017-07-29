package com.fc.fan.another.module.common;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.module.common.bean.LoginStatusBean;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;
import com.fc.fan.another.utils.PreferenceUtil;
import com.google.gson.Gson;

import butterknife.BindView;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

@SuppressWarnings("deprecation")
public class LoginActivity extends RxBaseActivity {
    public static final String TAG = "LoginActivity";

    @BindView(R.id.input_id)
    EditText _idText;
    @BindView(R.id.input_password)
    EditText _passwordText;
    @BindView(R.id.btn_login)
    Button _loginButton;
    @BindView(R.id.link_signup)
    TextView _signupLink;

    ProgressDialog progressDialog;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        _loginButton.setOnClickListener(view -> login());
        /*_signupLink.setOnClickListener(view -> {
            Intent intent = new Intent(this, SignUpActivity.class);
            startActivityForResult(intent, REQUEST_SIGNUP);
        })*/
        ;
    }

    @Override
    public void initToolBar() {

    }

    private void login() {
        if (!validate())
            return;

        _loginButton.setEnabled(false);

        progressDialog = new ProgressDialog(this, R.style.Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("登录中...");
        progressDialog.show();


        String email = _idText.getText().toString();
        String password = _passwordText.getText().toString();

        HttpUtils.getInstance()
                .create(ApiService.class, PreferenceUtil.baseUrl)
                .login(email, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handResult, throwable -> {
                    Log.e(TAG, throwable.getMessage());
                    progressDialog.hide();
                    _loginButton.setEnabled(true);
                    Toast.makeText(this, "登录失败，可能是因为没有网络", Toast.LENGTH_SHORT).show();
                });
    }

    private void handResult(LoginStatusBean bean) {
        progressDialog.hide();
        if (bean.getMsg() == 0) {
            Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
            _loginButton.setEnabled(true);
        } else {
            Gson gson = new Gson();
            Log.e(TAG, (bean.getUser() == null) + "");
            PreferenceUtil.putString("user", gson.toJson(bean.getUser()));
            PreferenceUtil.putBoolean("isLogin", true);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }

    public boolean validate() {
        boolean valid = true;

        String email = _idText.getText().toString();
        String password = _passwordText.getText().toString();

        if (email.isEmpty()) {
            _idText.setError("用户名不能为空");
            valid = false;
        }

        if (password.isEmpty()) {
            _passwordText.setError("密码不能为空");
            valid = false;
        }

        return valid;
    }

}
