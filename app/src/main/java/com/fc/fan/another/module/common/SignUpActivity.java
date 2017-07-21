package com.fc.fan.another.module.common;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.fc.fan.another.R;
import com.fc.fan.another.base.RxBaseActivity;
import com.fc.fan.another.utils.ApiService;
import com.fc.fan.another.utils.HttpUtils;

import butterknife.BindView;

/**
 * Created by fan on 7/12/17.
 */

public class SignUpActivity extends RxBaseActivity {
    public static final String TAG = SignUpActivity.class.getSimpleName();

    @BindView(R.id.btn_sign_up)
    AppCompatButton _signupButton;

    @BindView(R.id.input_email)
    EditText _emailText;

    @BindView(R.id.input_username)
    EditText _nameText;

    @BindView(R.id.input_password)
    EditText _passwordText;

    @BindView(R.id.link_login)
    TextView _loginLink;

    @Override
    public int getLayoutId() {
        return R.layout.activity_sign_up;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        _signupButton.setOnClickListener(view -> signUp());
        _loginLink.setOnClickListener(view -> {
            Log.e(TAG, "hah");
        });
    }

    private void signUp() {
        if (!validate())
            return;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        ProgressDialog progressDialog = new ProgressDialog(this, R.style.Theme_AppCompat_Dialog);
        progressDialog.setIndeterminate(true);
        progressDialog.setMessage("请稍后...");
        progressDialog.show();

    }

    public boolean validate() {
        boolean valid = true;

        String name = _nameText.getText().toString();
        String email = _emailText.getText().toString();
        String password = _passwordText.getText().toString();

        if (name.isEmpty() || name.length() < 4) {
            _nameText.setError("最少需4个字符");
            valid = false;
        }

        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailText.setError("请输入一个合法的邮箱");
            valid = false;
        }

        if (password.isEmpty() || password.length() < 6 || password.length() > 14) {
            _passwordText.setError("密码长度应在6-14个字符之间");
            valid = false;
        }

        return valid;
    }

    @Override
    public void initToolBar() {

    }
}
