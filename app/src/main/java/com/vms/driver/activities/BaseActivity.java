package com.vms.driver.activities;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.vms.driver.R;
import com.vms.driver.utils.NetworkConnection;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    private NetworkConnection connection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }

    public boolean isConnected() {
        return this.connection.isConnectingToInternet();
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {

    }
}
