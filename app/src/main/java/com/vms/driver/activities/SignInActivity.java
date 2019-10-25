package com.vms.driver.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.vms.driver.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SignInActivity extends BaseActivity {

    @BindView(R.id.btn_driver_signin)
    Button btnSignIn;
    @BindView(R.id.et_driver_login_email)
    EditText etEmail;
    @BindView(R.id.et_driver_login_password)
    EditText etPassword;
    @BindView(R.id.login_title)
    TextView tvLoginTitle;
    @BindView(R.id.tv_forgotpwd)
    TextView tvForgotPassword;
    @BindView(R.id.txt_iagree)
    CheckBox tvTermsAndConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        ButterKnife.bind((Activity) this);
        this.tvForgotPassword.setOnClickListener(this);
        this.btnSignIn.setOnClickListener(this);
        this.tvTermsAndConditions.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    SignInActivity.this.btnSignIn.setEnabled(true);
                    SignInActivity.this.btnSignIn.setTextColor(SignInActivity.this.getResources().getColor(R.color.colorWhite));
                    SignInActivity.this.btnSignIn.setBackgroundResource(R.drawable.button_round_cornor_selector);
                    return;
                }
                SignInActivity.this.btnSignIn.setEnabled(false);
                SignInActivity.this.btnSignIn.setBackgroundResource(R.drawable.button_disable_backgroung);
                SignInActivity.this.btnSignIn.setTextColor(SignInActivity.this.getResources().getColor(R.color.colorLightDarkGray));
            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);

    }
}
