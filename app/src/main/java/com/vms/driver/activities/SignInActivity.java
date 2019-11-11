package com.vms.driver.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.vms.driver.R;
import com.vms.driver.intent.IntentFactory;
import com.vms.driver.utils.PlatformUtils;

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
            switch(v.getId()){
                case R.id.btn_driver_signin:
                    startActivity(IntentFactory.returnDashBoardActivity(SignInActivity.this));
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    break;
                case R.id.tv_forgotpwd:
                    showInputDialog();
            }
    }

    /**
     * show forgot password dialog
     */
    protected void showInputDialog() {

        LayoutInflater layoutInflater = LayoutInflater.from(SignInActivity.this);
        View promptView = layoutInflater.inflate(R.layout.user_input_dialog_box, null);
        android.app.AlertDialog.Builder alertDialogBuilder = new android.app.AlertDialog.Builder(SignInActivity.this);
        alertDialogBuilder.setView(promptView);
        alertDialogBuilder.setTitle(" ");
        final EditText email = (EditText) promptView.findViewById(R.id.input_phone);
        alertDialogBuilder.setCancelable(true)
                .setNegativeButton(getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton(getString(R.string.btn_submit), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

        final AlertDialog alert = alertDialogBuilder.create();
        alert.show();
        alert.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (email.getText().toString().isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
                    email.setError(getString(R.string.mobile_number_error_mesage));
                } else {
                    email.setError(null);
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (email != null && SignInActivity.this != null) {
                                InputMethodManager imm = (InputMethodManager) SignInActivity.this
                                        .getSystemService(
                                                Context.INPUT_METHOD_SERVICE);
                                imm.hideSoftInputFromWindow(
                                        email.getWindowToken(), 0);
                                alert.cancel();
                            }
                        }
                    }, 300);
                }
            }
        });
        alert.setCancelable(false);
        alert.getButton(alert.BUTTON_POSITIVE).setTextColor(PlatformUtils.getColorWrapper(getApplicationContext(), R.color.gr1));
        alert.getButton(alert.BUTTON_NEGATIVE).setTextColor(PlatformUtils.getColorWrapper(getApplicationContext(), R.color.red_shade));
    }
}
