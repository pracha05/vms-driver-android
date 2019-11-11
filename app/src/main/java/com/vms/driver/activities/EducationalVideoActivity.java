package com.vms.driver.activities;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.vms.driver.R;
import com.vms.driver.adapter.EducationalVideoAdapter;
import com.vms.driver.model.EducationalVideoPojo;
import com.vms.driver.utils.ConnectionToast;

import org.json.JSONException;
import org.json.JSONObject;

import javax.xml.transform.ErrorListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EducationalVideoActivity extends BaseActivity {

    @BindView(R.id.edu_video_rv)
    RecyclerView edu_video_rv;

    @BindView(R.id.toolbar)
    Toolbar mToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educational_video);
        ButterKnife.bind((Activity) this);
        if (mToolBar != null) {
            setSupportActionBar(mToolBar);
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(R.string.edu_video_title);

            mToolBar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                    overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out);
                }
            });
        }
        this.edu_video_rv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        if (isConnected()) {
            fetchLoadBookings();
        } else {
            ConnectionToast.showNoNetworkToastMessage(this);
        }
    }

    public void fetchLoadBookings() {
        showDialog();
        String str = "";
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("user_id", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(0, "https://api.myjson.com/bins/7pknc", new JSONObject(jsonObject.toString()), new Response.Listener<JSONObject>() {
                public void onResponse(JSONObject response) {
                    EducationalVideoActivity.this.hideDialog();
                    EducationalVideoActivity.this.edu_video_rv.setAdapter
                            (new EducationalVideoAdapter(EducationalVideoActivity.this, (EducationalVideoPojo) new Gson().fromJson(String.valueOf(response), EducationalVideoPojo.class)));
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                        EducationalVideoActivity.this.hideDialog();
                }
            });
            Volley.newRequestQueue(this).add(jsonObjectRequest);
        } catch (Exception e2) {
            e2.printStackTrace();
            hideDialog();
        }
    }

    public void onClick(View v) {
    }
}
