package com.vms.driver.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.vms.driver.utils.DialogsUtils;
import com.vms.driver.utils.NetworkConnection;

import com.vms.driver.R;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private NetworkConnection connection;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        this.connection = new NetworkConnection(this);
    }

    public boolean isConnected() {
        return this.connection.isConnectingToInternet();
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    public void showDialog() {
        Dialog dialog2 = this.dialog;
        if (dialog2 == null) {
            this.dialog = DialogsUtils.showProgressDialog(this, "Loading data..");
        } else if (!dialog2.isShowing()) {
            this.dialog.show();
        }
    }

    public void hideDialog() {
        Dialog dialog2 = this.dialog;
        if (dialog2 != null && dialog2.isShowing()) {
            this.dialog.dismiss();
            this.dialog = null;
        }
    }


    @Override
    public void onClick(View v) {

    }
}
