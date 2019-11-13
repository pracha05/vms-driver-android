package com.vms.driver.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.vms.driver.R;
import com.vms.driver.intent.IntentFactory;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashBoardActivity extends BaseActivity {

    private AppBarConfiguration mAppBarConfiguration;
    @BindView(R.id.switch_onoff)
    Switch switch_onoff;
    @BindView(R.id.tv_onoff)
    TextView tv_onoff;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        ButterKnife.bind((Activity) this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_profile, R.id.nav_assign_booking, R.id.nav_manage_booking,
                R.id.nav_incentives, R.id.nav_accounting, R.id.nav_rating)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        this.switch_onoff.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    DashBoardActivity.this.tv_onoff.setText("Online");
                } else {
                    DashBoardActivity.this.tv_onoff.setText("Offline");
                }
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                if(menuItem.getTitle().equals("Logout")){
                    Intent intent = new Intent(DashBoardActivity.this, SignInActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK
                            | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    finishAffinity();
                    startActivity(intent);
                    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
                    finish();
                    return true;
                }else if(menuItem.getTitle().equals("About Us")){
                    startActivity(IntentFactory.startAboutUsActivity(DashBoardActivity.this));
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
                else if(menuItem.getTitle().equals("Support")){
                    startActivity(IntentFactory.startSupportActivity(DashBoardActivity.this));
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
                else if(menuItem.getTitle().equals("Educational Video")){
                    startActivity(IntentFactory.startEducationalVideo(DashBoardActivity.this));
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
                else if(menuItem.getTitle().equals("Refer & Earn")){
                    startActivity(IntentFactory.createReferenceCodeActivity(DashBoardActivity.this));
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }else if(menuItem.getTitle().equals("Profile")){
                    startActivity(IntentFactory.createProfileActivity(DashBoardActivity.this));
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }

                return false;
            }

        });
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
